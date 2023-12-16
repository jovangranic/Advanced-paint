package command;

import geometry.Donut;

public class UpdateDonutCommand implements Command {
	private Donut donut;
	private Donut newState;
	private Donut original = new Donut();

	public UpdateDonutCommand(Donut donut, Donut newState) {
		this.donut = donut;
		this.newState = newState;
	}

	@Override
	public void execute() {
		original.clone(donut);
		donut.clone(newState);
	}

	@Override
	public void unexecute() {
		donut.clone(original);
	}

}