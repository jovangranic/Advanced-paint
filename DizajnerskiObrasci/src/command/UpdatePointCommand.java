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
		//point = newState; 
		original.setX(point.getX());
		original.setY(point.getY());
		original.setColor(point.getColor());
		
		point.setX(newState.getX());
		point.setY(newState.getY());
		point.setColor(newState.getColor());
	}

	@Override
	public void unexecute() {
		//newState = point;
		point.setX(original.getX());
		point.setY(original.getY());
		point.setColor(original.getColor());
	}

}