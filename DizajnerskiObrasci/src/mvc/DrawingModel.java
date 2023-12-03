package mvc;

import java.util.ArrayList;

import geometry.Shape;

public class DrawingModel {
	
	public ArrayList<Shape> shapes = new ArrayList<Shape>();
	
	public void add(Shape p) {
		shapes.add(p);
	}
	
	public void remove(Shape p) {
		shapes.remove(p);
	}
	
	public Shape get(int index) {
		return shapes.get(index);
	}
	
	public ArrayList<Shape> getShapes(){
		return shapes;
	}


}