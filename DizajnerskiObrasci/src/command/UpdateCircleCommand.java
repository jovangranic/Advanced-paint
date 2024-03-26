package command;

import geometry.Circle;

public class UpdateCircleCommand implements Command {
	@Override
	public String toString() {
		return "Update Circle [circle=" + circle + ", newState=" + newState + "]";
	}

	private Circle circle;
	private Circle newState;
	private Circle original = new Circle();

	public UpdateCircleCommand(Circle circle, Circle newState) {
		this.circle = circle;
		this.newState = newState;
	}

	@Override
	public void execute() {
		original.clone(circle);
		circle.clone(newState);
	}

	@Override
	public void unexecute() {
		circle.clone(original);
	}

}