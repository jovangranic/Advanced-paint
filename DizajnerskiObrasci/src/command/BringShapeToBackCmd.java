package command;

import geometry.Shape;
import mvc.DrawingModel;

public class BringShapeToBackCmd implements Command {

	private Shape shape;
	@Override
	public String toString() {
		return "Bring To Back [shape=" + shape + "]";
	}

	private DrawingModel model;
	private int temp;
	
	public BringShapeToBackCmd(Shape shape, DrawingModel model) {
		this.shape = shape;
		this.model = model;
	}

	@Override
	public void execute() {
		temp = model.indexOf(shape);
		model.remove(shape);
		model.add(0, shape);
	}

	@Override
	public void unexecute() {
		model.remove(shape);
		model.add(temp, shape);
	}

}
