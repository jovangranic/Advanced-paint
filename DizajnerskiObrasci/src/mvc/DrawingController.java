
	//sva poslovna logika; najveca klasa
	//mouseclicked, eventlisteneri...

package mvc;

import java.awt.Color;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import geometry.*;
import drawing.*;

public class DrawingController {
	
	DrawingModel model;
	DrawingFrame frame;
	
	private Point startPoint = null;

	private Color edgeColor = Color.black;
	private Color fillColor = Color.white;
	
	public DrawingController(DrawingModel model, DrawingFrame frame) {
		this.model = model;
		this.frame = frame;
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
				model.get(i).setSelected(true);
				frame.repaint();
				return;
			}
		}
	}
	
	private void deselectAll() {
		for (int i = model.getShapes().size() - 1; i >= 0; i--) {
			model.get(i).setSelected(false);
		}
		frame.repaint();
	}
	
	public void mouseClicked(MouseEvent e) {

		Point clickPosition = new Point(e.getX(), e.getY());

		deselectAll();

		if (frame.getToggleSelect().isSelected()) {
			select(clickPosition);
			return;
		}

		if (frame.getToggleCircle().isSelected()) {
			DlgCircle dlgCircle = new DlgCircle();
			dlgCircle.setPoint(clickPosition);
			dlgCircle.setColors(edgeColor, fillColor);
			dlgCircle.setVisible(true);

			if (dlgCircle.getCircle() != null) {
				model.add(dlgCircle.getCircle());
			}
		}

		else if (frame.getToggleDonut().isSelected()) {
			DlgDonut dlgDonut = new DlgDonut();
			dlgDonut.setPoint(clickPosition);
			dlgDonut.setColors(edgeColor, fillColor);
			dlgDonut.setVisible(true);

			if (dlgDonut.getDonut() != null) {
				model.add(dlgDonut.getDonut());
			}
		}

		else if (frame.getToggleRectangle().isSelected()) {
			DlgRectangle dlgRectangle = new DlgRectangle();
			dlgRectangle.setPoint(clickPosition);
			dlgRectangle.setColors(edgeColor, fillColor);
			dlgRectangle.setVisible(true);

			if (dlgRectangle.getRectangle() != null) {
				model.add(dlgRectangle.getRectangle());
			}
		}

		else if (frame.getTogglePoint().isSelected()) {
			DlgPoint dlgPoint = new DlgPoint();
			dlgPoint.setPoint(clickPosition);
			dlgPoint.setColor(edgeColor);
			dlgPoint.setVisible(true);

			if (dlgPoint.getPoint() != null) {
				model.add(dlgPoint.getPoint());
			}
		}

		else if (frame.getToggleLine().isSelected()) {
			if (startPoint != null) {
				DlgLine dlgLine = new DlgLine();
				dlgLine.setLine(startPoint, clickPosition);
				dlgLine.setColor(edgeColor);
				dlgLine.setVisible(true);

				if (dlgLine.getLine() != null) {
					model.add(dlgLine.getLine());
				}
				startPoint = null;
			} else {
				startPoint = clickPosition;
			}
		}
		frame.repaint();
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
			model.remove(model.get(i));
			frame.repaint();
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
				((Point) shape).setX(dlgPoint.getPoint().getX());
				((Point) shape).setY(dlgPoint.getPoint().getY());
				shape.moveTo(dlgPoint.getPoint().getX(), dlgPoint.getPoint().getY());
			}
		}

		else if (shape instanceof Line) {
			DlgLine dlgLine = new DlgLine();
			dlgLine.setLine(((Line) shape).getStartPoint(), ((Line) shape).getEndPoint());
			dlgLine.setVisible(true);
			Line line = dlgLine.getLine();

			if (line != null) {
				((Line) shape).setStartPoint(line.getStartPoint());
				((Line) shape).setEndPoint(line.getEndPoint());
				shape.setColor(line.getColor());
			}
		}

		else if (shape instanceof Rectangle) {
			DlgRectangle dlgRectangle = new DlgRectangle();
			dlgRectangle.setRectangle((Rectangle) shape);
			dlgRectangle.setVisible(true);
			Rectangle rect = dlgRectangle.getRectangle();

			if (rect != null) {
				((Rectangle) shape).setUpperLeftPoint(rect.getUpperLeftPoint());
				((Rectangle) shape).setWidth(rect.getWidth());
				((Rectangle) shape).setHeight(rect.getHeight());
				shape.setColor(rect.getColor());
				((Rectangle) shape).setFillColor(rect.getFillColor());
			}
		}

		else if (shape instanceof Donut) {
			DlgDonut dlgDonut = new DlgDonut();
			dlgDonut.setDonut((Donut) shape);
			dlgDonut.setVisible(true);
			Donut donut = dlgDonut.getDonut();

			if (donut != null) {
				((Donut) shape).setCenter(donut.getCenter());
				((Donut) shape).setRadius(donut.getRadius());
				((Donut) shape).setInnerRadius(donut.getInnerRadius());
				shape.setColor(donut.getColor());
				((Donut) shape).setFillColor(donut.getFillColor());
			}
		}

		else if (shape instanceof Circle) {
			DlgCircle dlgCircle = new DlgCircle();
			dlgCircle.setCircle((Circle) shape);
			dlgCircle.setVisible(true);
			Circle circle = dlgCircle.getCircle();

			if (circle != null) {
				((Circle) shape).setCenter(circle.getCenter());
				((Circle) shape).setRadius(circle.getRadius());
				// shape.moveTo(dlgCircle.getCircle().getCenter().getX(),
				// dlgCircle.getCircle().getCenter().getY());
				shape.setColor(circle.getColor());
				((Circle) shape).setFillColor(circle.getFillColor());
			}
		}

		frame.repaint();
	}
}