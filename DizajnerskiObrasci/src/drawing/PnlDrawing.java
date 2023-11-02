package drawing;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JPanel;

import geometry.Point;
import geometry.Shape;

import java.awt.Color;

public class PnlDrawing extends JPanel {
	
	private ArrayList<Shape> shapes = new ArrayList<Shape>();

	/**
	 * Create the panel.
	 */
	public PnlDrawing() {
		setBackground(Color.WHITE);

	}
	
	public void paint(Graphics g) {
		super.paint(g);
		Iterator<Shape> it = shapes.iterator();
		while(it.hasNext())
			it.next().draw(g);	
	}
	
	public void addShape(Shape shape) {
		shapes.add(shape);
		repaint(); //poziva paint, sluzi za osvezavanje slike
	}
	
	public void select(Point p) {
		for(int i = shapes.size() - 1; i >= 0; i--) {
			if(shapes.get(i).contains(p.getX(), p.getY())) {
				shapes.get(i).setSelected(true);
				repaint();
				return;
			}
		}
	}
	
	public void deselect() {
		for(int i = 0; i < shapes.size(); i++) {
			shapes.get(i).setSelected(false);
		}
		repaint();
	}
	
	public int getSelected() {
		for(int i = shapes.size() - 1; i >= 0; i--) {
			if(shapes.get(i).isSelected()) {
				return i;
			}
		}
		return -1;
	}
	
	public Shape getShape(int index) {
		return shapes.get(index);
	}
	
	public void delete(int index) {
		shapes.remove(index);
		repaint();
	}

}
