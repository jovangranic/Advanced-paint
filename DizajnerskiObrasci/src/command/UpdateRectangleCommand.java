package command;

import geometry.Rectangle;

public class UpdateRectangleCommand implements Command {
	private Rectangle rectangle;
	private Rectangle newState;
	private Rectangle original = new Rectangle();

	public UpdateRectangleCommand(Rectangle rectangle, Rectangle newState) {
		this.rectangle = rectangle;
		this.newState = newState;
	}

	@Override
	public void execute() {
		original.clone(rectangle);
		rectangle.clone(newState);
	}

	@Override
	public void unexecute() {
		rectangle.clone(original);
	}

}