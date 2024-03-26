package command;

import geometry.Point;

public class UpdatePointCommand implements Command {
	private Point point;
	private Point newState;
	private Point original = new Point();

	public UpdatePointCommand(Point point, Point newState) {
		this.point = point;
		this.newState = newState;
	}

	@Override
	public void execute() {
		original.clone(point);
		point.clone(newState);
	}

	@Override
	public void unexecute() {
		point.clone(original);
	}

	@Override
	public String toString() {
		return "Update Point [point=" + point + ", newState=" + newState + "]";
	}

}