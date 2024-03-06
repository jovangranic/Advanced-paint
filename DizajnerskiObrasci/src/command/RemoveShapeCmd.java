package command;

import java.util.ArrayList;

import geometry.Shape;
import mvc.DrawingModel;

public class RemoveShapeCmd implements Command {
	private ArrayList<Shape> shapes;
	private DrawingModel model;
	private int temp[];

	public RemoveShapeCmd(ArrayList<Shape> shapes, DrawingModel model) {
		this.shapes = shapes;
		this.model = model;
	}

	@Override
	public void execute() {
		temp = new int[shapes.size()];
		for(int i = 0; i < shapes.size(); i++) {
			temp[i] = model.indexOf(shapes.get(i));
			model.remove(shapes.get(i));
		}
	}

	@Override
	public void unexecute() {
		for(int i = shapes.size() - 1; i >= 0; i--) {
			model.add(temp[i], shapes.get(i));
		}
	}

}