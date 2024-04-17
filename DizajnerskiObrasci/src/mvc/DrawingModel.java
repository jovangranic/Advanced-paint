package mvc;

import java.util.ArrayList;

import geometry.Shape;

public class DrawingModel {
	
	public ArrayList<Shape> shapes = new ArrayList<Shape>();
	
	public void add(Shape s) {
		shapes.add(s);
	}
	
	public void add(int index, Shape s) {
		shapes.add(index, s);
	}
	
	public void remove(Shape s) {
		shapes.remove(s);
	}
	
	public Shape get(int index) {
		return shapes.get(index);
	}
	
	public ArrayList<Shape> getShapes(){
		return shapes;
	}
	
	public void setShapes(ArrayList<Shape> shapes) {
		this.shapes = shapes;
	}

	public int indexOf(Shape s) {
		return shapes.indexOf(s);
	}
}