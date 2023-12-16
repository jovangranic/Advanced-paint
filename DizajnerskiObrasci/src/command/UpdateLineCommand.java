package command;

import geometry.Line;

public class UpdateLineCommand implements Command {
	private Line line;
	private Line newState;
	private Line original = new Line();

	public UpdateLineCommand(Line line, Line newState) {
		this.line = line;
		this.newState = newState;
	}

	@Override
	public void execute() {
		original.clone(line);
		line.clone(newState);
	}

	@Override
	public void unexecute() {
		line.clone(original);
	}

}