package command;

import geometry.Shape;

public class SelectShapeCmd implements Command {
	private Shape shape;

	public SelectShapeCmd(Shape shape) {
		this.shape = shape;
	}

	@Override
	public void execute() {
		shape.setSelected(true);
	}

	@Override
	public void unexecute() {
		shape.setSelected(false);
	}

}