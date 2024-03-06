package command;

import java.util.Collections;

import geometry.Shape;
import mvc.DrawingModel;

public class ShapeToFrontCmd implements Command {

	private Shape shape;
	private DrawingModel model;
	
	public ShapeToFrontCmd(Shape shape, DrawingModel model) {
		this.shape = shape;
		this.model = model;
	}

	@Override
	public void execute() {
		Collections.swap(model.getShapes(), model.indexOf(shape), model.indexOf(shape) + 1);
	}

	@Override
	public void unexecute() {
		Collections.swap(model.getShapes(), model.indexOf(shape), model.indexOf(shape) - 1);
	}

}
