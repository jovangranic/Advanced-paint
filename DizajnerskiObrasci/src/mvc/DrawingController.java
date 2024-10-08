
	//sva poslovna logika; najveca klasa
	//mouseclicked, eventlisteneri...

package mvc;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import command.AddShapeCmd;
import command.BringShapeToBackCmd;
import command.BringShapeToFrontCmd;
import command.Command;
import command.DeselectShapesCmd;
import command.RemoveShapeCmd;
import command.SelectShapeCmd;
import command.ShapeToBackCmd;
import command.ShapeToFrontCmd;
import command.UpdateCircleCommand;
import command.UpdateDonutCommand;
import command.UpdateHexagonCommand;
import command.UpdateLineCommand;
import command.UpdatePointCommand;
import command.UpdateRectangleCommand;
import drawing.DlgCircle;
import drawing.DlgDonut;
import drawing.DlgHexagon;
import drawing.DlgLine;
import drawing.DlgPoint;
import drawing.DlgRectangle;
import geometry.Circle;
import geometry.Donut;
import geometry.HexagonAdapter;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import geometry.Shape;
import observer.ControlsObserver;
import observer.ObservableControls;
import strategy.LoadFileStrategy;
import strategy.SaveFileStrategy;

public class DrawingController {
	
	DrawingModel model;
	DrawingFrame frame;
	
	private Point startPoint = null;

	private Color edgeColor = Color.black;
	private Color fillColor = Color.white;
	
	private Stack<Command> undoStack = new Stack<>();
	private Stack<Command> redoStack = new Stack<>();
	
	private ObservableControls controls = new ObservableControls();
	private ControlsObserver observer;
	
	private LoadFileStrategy drawingLoader;
	private SaveFileStrategy drawingSaver;
	private LoadFileStrategy logLoader;
	private SaveFileStrategy logSaver;
	
	public DrawingController(DrawingModel model, DrawingFrame frame) {
		this.model = model;
		this.frame = frame;
		this.observer = new ControlsObserver(frame);
		this.controls.addListener(observer);
	}
	
	public void setDrawingStrategy(LoadFileStrategy load, SaveFileStrategy save) {
		this.drawingLoader = load;
		this.drawingSaver = save;
	}
	
	public void setLogStrategy(LoadFileStrategy load, SaveFileStrategy save) {
		this.logLoader = load;
		this.logSaver = save;
	}
	
	private void executeCommand(Command command) {
		command.execute();
		undoStack.push(command);
		redoStack.clear();
		updateControls();
		frame.getTextArea().append(command.toString() + '\n');
		frame.repaint();
	}
	
	public void undo() {
		Command cmd = undoStack.pop();
		cmd.unexecute();
		redoStack.push(cmd);
		updateControls();
		frame.getTextArea().append("Undo: " + cmd.toString() + '\n');
		frame.repaint();
	}
	
	public void redo() {
		Command cmd = redoStack.pop();
		cmd.execute();
		undoStack.push(cmd);
		updateControls();
		frame.getTextArea().append("Redo: " + cmd.toString() + '\n');
		frame.repaint();
	}
	
	private void updateControls() {
		int selectedShapes = getSelectedShapesAmount();
		if (selectedShapes == 1) { 			// one shape selected
			controls.setModify(true);
			controls.setDelete(true);
			if (getSelected() == 0) {
				controls.setToBack(false);
				controls.setBringToBack(false);
			} else {
				controls.setToBack(true);
				controls.setBringToBack(true);
			}
			if (getSelected() == model.getShapes().size() - 1) {
				controls.setToFront(false);
				controls.setBringToFront(false);
			} else {
				controls.setToFront(true);
				controls.setBringToFront(true);
			}
		} else if (selectedShapes > 0) { 	// multiple shapes selected
			controls.setModify(false);
			controls.setDelete(true);
			controls.setToBack(false);
			controls.setBringToBack(false);
			controls.setToFront(false);
			controls.setBringToFront(false);
		} else {							// no shapes selected
			controls.setModify(false);
			controls.setDelete(false);
			controls.setToBack(false);
			controls.setBringToBack(false);
			controls.setToFront(false);
			controls.setBringToFront(false);
		}
		
		if (undoStack.size() > 0) {
			controls.setUndo(true);
		} else {
			controls.setUndo(false);
		}
		if (redoStack.size() > 0) {
			controls.setRedo(true);
		} else {
			controls.setRedo(false);
		}
	}
	
	private int getSelected() {
		for (int i = model.getShapes().size() - 1; i >= 0; i--) {
			if (model.get(i).isSelected()) {
				return i;
			}
		}
		return -1;
	}
	
	private int getSelectedShapesAmount() {
		int amount = 0;
		for (int i = model.getShapes().size() - 1; i >= 0; i--) {
			if (model.get(i).isSelected()) {
				amount++;
			}
		}
		return amount;
	}
	
	private Shape getShapeAt(Point p) {
		for (int i = model.getShapes().size() - 1; i >= 0; i--) {
			if (model.get(i).contains(p.getX(), p.getY())) {
				return model.get(i);
			}
		}
		return null;
	}
	
	private void select(Point p) {
		for (int i = model.getShapes().size() - 1; i >= 0; i--) {
			if (model.get(i).contains(p.getX(), p.getY())) {
				executeCommand(new SelectShapeCmd(model.get(i), model));
				return;
			}
		}
	}
	
	private void deselectAll() {
		ArrayList<Shape> selectedShapes = new ArrayList<Shape>();
		for (int i = model.getShapes().size() - 1; i >= 0; i--) {
			if(model.get(i).isSelected()) {
				selectedShapes.add(model.get(i));
			}
		}
		if(selectedShapes.size() > 0) {
			executeCommand(new DeselectShapesCmd(selectedShapes, model));
		}
	}
	
	public void mouseClicked(MouseEvent e) {

		Point clickPosition = new Point(e.getX(), e.getY());
		Shape clicked = getShapeAt(clickPosition);

		if (clicked == null)
			deselectAll();

		if (frame.getToggleSelect().isSelected()) {
			if (clicked == null)
				return;
			
			if (clicked.isSelected()) {
				executeCommand(new DeselectShapesCmd(clicked, model));
			} else {
				executeCommand(new SelectShapeCmd(clicked, model));
			}
			return;
		}
		
		Shape shape = null;

		if (frame.getToggleCircle().isSelected()) {
			DlgCircle dlgCircle = new DlgCircle();
			dlgCircle.setPoint(clickPosition);
			dlgCircle.setColors(edgeColor, fillColor);
			dlgCircle.setVisible(true);
			
			shape = dlgCircle.getCircle();
		}

		else if (frame.getToggleDonut().isSelected()) {
			DlgDonut dlgDonut = new DlgDonut();
			dlgDonut.setPoint(clickPosition);
			dlgDonut.setColors(edgeColor, fillColor);
			dlgDonut.setVisible(true);
			
			shape = dlgDonut.getDonut();
		}

		else if (frame.getToggleRectangle().isSelected()) {
			DlgRectangle dlgRectangle = new DlgRectangle();
			dlgRectangle.setPoint(clickPosition);
			dlgRectangle.setColors(edgeColor, fillColor);
			dlgRectangle.setVisible(true);

			shape = dlgRectangle.getRectangle();
		}

		else if (frame.getTogglePoint().isSelected()) {
			DlgPoint dlgPoint = new DlgPoint();
			dlgPoint.setPoint(clickPosition);
			dlgPoint.setColor(edgeColor);
			dlgPoint.setVisible(true);

			shape = dlgPoint.getPoint();
		}

		else if (frame.getToggleLine().isSelected()) {
			if (startPoint != null) {
				DlgLine dlgLine = new DlgLine();
				dlgLine.setLine(startPoint, clickPosition);
				dlgLine.setColor(edgeColor);
				dlgLine.setVisible(true);

				shape = dlgLine.getLine();
				startPoint = null;
			} else {
				startPoint = clickPosition;
			}
		}
		
		else if (frame.getToggleHexagon().isSelected()) {
			DlgHexagon dlgHexagon = new DlgHexagon();
			dlgHexagon.setPoint(clickPosition);
			dlgHexagon.setColors(edgeColor, fillColor);
			dlgHexagon.setVisible(true);
			
			shape = dlgHexagon.getHexagon();
		}
		if(shape != null) {
			executeCommand(new AddShapeCmd(shape, model));
		}
	}
	
	public void delete(){
		ArrayList<Shape> selectedShapes = new ArrayList<Shape>();
		for (int i = 0; i < model.getShapes().size(); i++) {
			if (model.get(i).isSelected()) {
				selectedShapes.add(model.get(i));
			}
		}
		executeCommand(new RemoveShapeCmd(selectedShapes, model));
	}
	
	public void modify() {
		int i = getSelected();
		if (i == -1) {
			JOptionPane.showMessageDialog(null, "Select an object to modify first!", "Error!",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		Shape shape = model.get(i);

		if (shape instanceof Point) {
			DlgPoint dlgPoint = new DlgPoint();
			dlgPoint.setPoint((Point) shape);
			dlgPoint.setVisible(true);

			if (dlgPoint.getPoint() != null) {
				executeCommand(new UpdatePointCommand((Point)shape, dlgPoint.getPoint()));
			}
		}

		else if (shape instanceof Line) {
			DlgLine dlgLine = new DlgLine();
			dlgLine.setLine((Line) shape);
			dlgLine.setVisible(true);
			Line line = dlgLine.getLine();

			if (line != null) {
				executeCommand(new UpdateLineCommand((Line)shape, dlgLine.getLine()));
			}
		}

		else if (shape instanceof Rectangle) {
			DlgRectangle dlgRectangle = new DlgRectangle();
			dlgRectangle.setRectangle((Rectangle) shape);
			dlgRectangle.setVisible(true);
			Rectangle rect = dlgRectangle.getRectangle();

			if (rect != null) {
				executeCommand(new UpdateRectangleCommand((Rectangle)shape, dlgRectangle.getRectangle()));
			}
		}

		else if (shape instanceof Donut) {
			DlgDonut dlgDonut = new DlgDonut();
			dlgDonut.setDonut((Donut) shape);
			dlgDonut.setVisible(true);
			Donut donut = dlgDonut.getDonut();

			if (donut != null) {
				executeCommand(new UpdateDonutCommand((Donut)shape, dlgDonut.getDonut()));
			}
		}

		else if (shape instanceof Circle) {
			DlgCircle dlgCircle = new DlgCircle();
			dlgCircle.setCircle((Circle) shape);
			dlgCircle.setVisible(true);
			Circle circle = dlgCircle.getCircle();

			if (circle != null) {
				executeCommand(new UpdateCircleCommand((Circle)shape, dlgCircle.getCircle()));
			}
		}
		
		else if (shape instanceof HexagonAdapter) {
			DlgHexagon dlgHexagon = new DlgHexagon();
			dlgHexagon.setHexagon((HexagonAdapter) shape);
			dlgHexagon.setVisible(true);
			HexagonAdapter circle = dlgHexagon.getHexagon();

			if (circle != null) {
				executeCommand(new UpdateHexagonCommand((HexagonAdapter)shape, dlgHexagon.getHexagon()));
			}
		}
	}
	
	public void shapeToBack () {
		int i = getSelected();
		ShapeToBackCmd back = new ShapeToBackCmd(model.get(i), model);
		executeCommand(back);
	}
	
	public void shapeToFront () {
		int i = getSelected();
		ShapeToFrontCmd front = new ShapeToFrontCmd(model.get(i), model);
		executeCommand(front);
	}
	
	public void bringShapeToBack () {
		int i = getSelected();
		BringShapeToBackCmd toBack = new BringShapeToBackCmd(model.get(i), model);
		executeCommand(toBack);
	}
	
	public void bringShapeToFront () {
		int i = getSelected();
		BringShapeToFrontCmd toFront = new BringShapeToFrontCmd(model.get(i), model);
		executeCommand(toFront);
	}
	
	public void setEdgeColor() {
		Color color = JColorChooser.showDialog(frame, "Choose edge color", edgeColor);
		if(color != null) {
			this.edgeColor = color;
		}
	}
	
	public void setFillColor() {
		Color color = JColorChooser.showDialog(frame, "Choose fill color", fillColor);
		if(color != null) {
			this.fillColor = color;
		}
	}
	
	public void loadDrawing() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Load Drawing");
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Binary Files", "bin");
		fileChooser.setFileFilter(filter);
		if (fileChooser.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			String path = file.getAbsolutePath();
			model.setShapes((ArrayList<Shape>) drawingLoader.load(path));
			undoStack.clear();
			redoStack.clear();
			frame.getTextArea().setText("");
			updateControls();
			frame.repaint();
		}
	}
	
	public void saveDrawing() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Save Drawing As");
		if (fileChooser.showSaveDialog(frame) == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			String path = file.getAbsolutePath();
			drawingSaver.save(model.getShapes(), path + ".bin");
		}
	}
	
	public void loadLog() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Load Log");
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt");
		fileChooser.setFileFilter(filter);
		if (fileChooser.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			String path = file.getAbsolutePath();
			undoStack.clear();
			redoStack.clear();
			frame.getTextArea().setText("");
			updateControls();
			logLoader.load(path);
			frame.repaint();
		}
	}
	
	public void saveLog() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Save Log As");
		if (fileChooser.showSaveDialog(frame) == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			String path = file.getAbsolutePath();
			logSaver.save(frame.getTextArea().getText(), path + ".txt");
		}
	}
	
	private Shape stringToShape(String shapeStr) {
		Shape newShape = null;
		String[] split = shapeStr.split("=");
		
		// Point [x|=|84, y|=|83, color|=|java.awt.Color[r|=|0,g|=|0,b|=|0]]
		
		if (shapeStr.startsWith("Point")) {
			int x = Integer.parseInt(split[1].split(",")[0]);
			int y = Integer.parseInt(split[2].split(",")[0]);
			int r = Integer.parseInt(split[4].split(",")[0]);
			int g = Integer.parseInt(split[5].split(",")[0]);
			int b = Integer.parseInt(split[6].split("\\]")[0]);
			newShape = new Point(x, y, new Color(r,g,b));
		} else if (shapeStr.startsWith("Line")) {
			int x1 = Integer.parseInt(split[1].split(",")[0]);
			int y1 = Integer.parseInt(split[2].split(",")[0]);
			int x2 = Integer.parseInt(split[3].split(",")[0]);
			int y2 = Integer.parseInt(split[4].split(",")[0]);
			int r = Integer.parseInt(split[6].split(",")[0]);
			int g = Integer.parseInt(split[7].split(",")[0]);
			int b = Integer.parseInt(split[8].split("\\]")[0]);
			newShape = new Line(new Point(x1, y1), new Point(x2, y2), new Color(r,g,b));
		} else if (shapeStr.startsWith("Rectangle")) {
			int x = Integer.parseInt(split[1].split(",")[0]);
			int y = Integer.parseInt(split[2].split(",")[0]);
			int width = Integer.parseInt(split[3].split(",")[0]);
			int height = Integer.parseInt(split[4].split(",")[0]);
			int r1 = Integer.parseInt(split[6].split(",")[0]);
			int g1 = Integer.parseInt(split[7].split(",")[0]);
			int b1 = Integer.parseInt(split[8].split("\\]")[0]);
			int r2 = Integer.parseInt(split[10].split(",")[0]);
			int g2 = Integer.parseInt(split[11].split(",")[0]);
			int b2 = Integer.parseInt(split[12].split("\\]")[0]);
			newShape = new Rectangle(new Point(x, y), width, height, new Color(r2,g2,b2), new Color(r1,g1,b1));
		} else if (shapeStr.startsWith("Circle")) {
			int x = Integer.parseInt(split[1].split(",")[0]);
			int y = Integer.parseInt(split[2].split(",")[0]);
			int r = Integer.parseInt(split[3].split(",")[0]);
			int r1 = Integer.parseInt(split[5].split(",")[0]);
			int g1 = Integer.parseInt(split[6].split(",")[0]);
			int b1 = Integer.parseInt(split[7].split("\\]")[0]);
			int r2 = Integer.parseInt(split[9].split(",")[0]);
			int g2 = Integer.parseInt(split[10].split(",")[0]);
			int b2 = Integer.parseInt(split[11].split("\\]")[0]);
			newShape = new Circle(new Point(x, y), r, new Color(r2,g2,b2), new Color(r1,g1,b1));
		} else if (shapeStr.startsWith("Donut")) {
			int x = Integer.parseInt(split[1].split(",")[0]);
			int y = Integer.parseInt(split[2].split(",")[0]);
			int r = Integer.parseInt(split[3].split(",")[0]);
			int innerR = Integer.parseInt(split[4].split(",")[0]);
			int r1 = Integer.parseInt(split[6].split(",")[0]);
			int g1 = Integer.parseInt(split[7].split(",")[0]);
			int b1 = Integer.parseInt(split[8].split("\\]")[0]);
			int r2 = Integer.parseInt(split[10].split(",")[0]);
			int g2 = Integer.parseInt(split[11].split(",")[0]);
			int b2 = Integer.parseInt(split[12].split("\\]")[0]);
			newShape = new Donut(new Point(x, y), r, innerR, new Color(r2,g2,b2), new Color(r1,g1,b1));
		} else if (shapeStr.startsWith("HexagonAdapter")) {
			int x = Integer.parseInt(split[1].split(",")[0]);
			int y = Integer.parseInt(split[2].split(",")[0]);
			int r = Integer.parseInt(split[3].split(",")[0]);
			int r1 = Integer.parseInt(split[5].split(",")[0]);
			int g1 = Integer.parseInt(split[6].split(",")[0]);
			int b1 = Integer.parseInt(split[7].split("\\]")[0]);
			int r2 = Integer.parseInt(split[9].split(",")[0]);
			int g2 = Integer.parseInt(split[10].split(",")[0]);
			int b2 = Integer.parseInt(split[11].split("\\]")[0]);
			newShape = new HexagonAdapter(x, y, r, new Color(r1,g1,b1), new Color(r2,g2,b2));
		}
		
		return newShape;
	}
	
	public void executeLine(String line) {
		if(line.startsWith("Add")) {
			String[] split = line.split("shape=");
			String shapeStr = split[1].substring(0, split[1].length() - 1);
			executeCommand(new AddShapeCmd(stringToShape(shapeStr), model));
		} else if (line.startsWith("Remove")) {
			this.delete();
		} else if (line.startsWith("Bring To Back")) {
			this.bringShapeToBack();
		} else if (line.startsWith("Bring To Front")) {
			this.bringShapeToFront();
		} else if (line.startsWith("To Back")) {
			this.shapeToBack();
		} else if (line.startsWith("To Front")) {
			this.shapeToFront();
		} else if (line.startsWith("Deselect")) {
			String[] split = line.split("=");
			String substr = split[1].substring(0, split[1].length() - 1);
			String[] indexes = substr.split(", ");
			ArrayList<Shape> shapes = new ArrayList<Shape>();
			for (int i = 0; i < indexes.length; i++) {
				shapes.add(model.get(Integer.parseInt(indexes[i])));
			}
			executeCommand(new DeselectShapesCmd(shapes, model));
		} else if (line.startsWith("Select")) {
			String[] split = line.split("=");
			String substr = split[1].substring(0, split[1].length() - 1);
			executeCommand(new SelectShapeCmd(model.get(Integer.parseInt(substr)), model));
		} else if (line.startsWith("Update Point")) {
			String[] split = line.split("newState=");
			String shapeStr = split[1].substring(0, split[1].length() - 1);
			executeCommand(new UpdatePointCommand((Point)model.get(getSelected()), 
					(Point)stringToShape(shapeStr)));
		} else if (line.startsWith("Update Line")) {
			String[] split = line.split("newState=");
			String shapeStr = split[1].substring(0, split[1].length() - 1);
			executeCommand(new UpdateLineCommand((Line)model.get(getSelected()), 
					(Line)stringToShape(shapeStr)));
		} else if (line.startsWith("Update Rectangle")) {
			String[] split = line.split("newState=");
			String shapeStr = split[1].substring(0, split[1].length() - 1);
			executeCommand(new UpdateRectangleCommand((Rectangle)model.get(getSelected()), 
					(Rectangle)stringToShape(shapeStr)));
		} else if (line.startsWith("Update Circle")) {
			String[] split = line.split("newState=");
			String shapeStr = split[1].substring(0, split[1].length() - 1);
			executeCommand(new UpdateCircleCommand((Circle)model.get(getSelected()), 
					(Circle)stringToShape(shapeStr)));
		} else if (line.startsWith("Update Donut")) {
			String[] split = line.split("newState=");
			String shapeStr = split[1].substring(0, split[1].length() - 1);
			executeCommand(new UpdateDonutCommand((Donut)model.get(getSelected()), 
					(Donut)stringToShape(shapeStr)));
		} else if (line.startsWith("Update Hexagon")) {
			String[] split = line.split("newState=");
			String shapeStr = split[1].substring(0, split[1].length() - 1);
			executeCommand(new UpdateHexagonCommand((HexagonAdapter)model.get(getSelected()), 
					(HexagonAdapter)stringToShape(shapeStr)));
		} else if (line.startsWith("Undo")) {
			this.undo();
		} else if (line.startsWith("Redo")) {
			this.redo();
		} 
	}
}