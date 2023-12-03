package command;

import geometry.Shape;
import mvc.DrawingModel;

public class RemoveShapeCmd implements Command {
	private Shape shape;
	private DrawingModel model;

	public RemoveShapeCmd(Shape shape, DrawingModel model) {
		this.shape = shape;
		this.model = model;
	}

	@Override
	public void execute() {
		model.remove(shape);
	}

	@Override
	public void unexecute() {
		model.add(shape);
	}

}