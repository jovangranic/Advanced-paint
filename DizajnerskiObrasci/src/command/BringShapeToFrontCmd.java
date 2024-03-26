package command;

import geometry.Shape;
import mvc.DrawingModel;

public class BringShapeToFrontCmd implements Command {
	@Override
	public String toString() {
		return "Bring To Front [shape=" + shape + "]";
	}
	private Shape shape;
	private DrawingModel model;
	private int temp;
	
	public BringShapeToFrontCmd(Shape shape, DrawingModel model) {
		this.shape = shape;
		this.model = model;
	}

	@Override
	public void execute() {
		temp = model.indexOf(shape);
		model.remove(shape);
		model.add(shape);
	}

	@Override
	public void unexecute() {
		model.remove(shape);
		model.add(temp, shape);
	}

}
