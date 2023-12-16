
	//sva poslovna logika; najveca klasa
	//mouseclicked, eventlisteneri...

package mvc;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.JOptionPane;

import command.AddShapeCmd;
import command.Command;
import command.DeselectShapesCmd;
import command.RemoveShapeCmd;
import command.SelectShapeCmd;
import command.UpdateCircleCommand;
import command.UpdateDonutCommand;
import command.UpdateLineCommand;
import command.UpdatePointCommand;
import command.UpdateRectangleCommand;
import geometry.*;
import drawing.*;

public class DrawingController {
	
	DrawingModel model;
	DrawingFrame frame;
	
	private Point startPoint = null;

	private Color edgeColor = Color.black;
	private Color fillColor = Color.white;
	
	private Stack<Command> undoStack = new Stack<>();
	private Stack<Command> redoStack = new Stack<>();
	
	public DrawingController(DrawingModel model, DrawingFrame frame) {
		this.model = model;
		this.frame = frame;
	}
	
	private void executeCommand(Command command) {
		command.execute();
		undoStack.push(command);
		redoStack.clear();
		frame.repaint();
	}
	
	public void undo() {
		Command cmd = undoStack.pop();
		cmd.unexecute();
		redoStack.push(cmd);
		frame.repaint();
	}
	
	public void redo() {
		Command cmd = redoStack.pop();
		cmd.execute();
		undoStack.push(cmd);
		frame.repaint();
	}
	
	private int getSelected() {
		for (int i = model.getShapes().size() - 1; i >= 0; i--) {
			if (model.get(i).isSelected()) {
				return i;
			}
		}
		return -1;
	}
	
	private void select(Point p) {
		for (int i = model.getShapes().size() - 1; i >= 0; i--) {
			if (model.get(i).contains(p.getX(), p.getY())) {
				executeCommand(new SelectShapeCmd(model.get(i)));
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
			executeCommand(new DeselectShapesCmd(selectedShapes));
		}
	}
	
	public void mouseClicked(MouseEvent e) {

		Point clickPosition = new Point(e.getX(), e.getY());

		deselectAll();

		if (frame.getToggleSelect().isSelected()) {
			select(clickPosition);
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
		if(shape != null) {
			executeCommand(new AddShapeCmd(shape, model));
		}
	}
	
	public void delete(){
		int i = getSelected();
		if (i == -1) {
			JOptionPane.showMessageDialog(null, "Select an object to delete first!", "Error!",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		if (JOptionPane.showConfirmDialog(null, "Do you really want to delete selected object?",
				"Deleting selected object", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0) {
			executeCommand(new RemoveShapeCmd(model.get(i), model));
		}
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
			dlgLine.setLine(((Line) shape).getStartPoint(), ((Line) shape).getEndPoint());
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
	}
}