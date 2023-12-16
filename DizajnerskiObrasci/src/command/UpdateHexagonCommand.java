package command;

import geometry.HexagonAdapter;

public class UpdateHexagonCommand implements Command {
	private HexagonAdapter hexagon;
	private HexagonAdapter newState;
	private HexagonAdapter original = new HexagonAdapter();

	public UpdateHexagonCommand(HexagonAdapter hexagon, HexagonAdapter newState) {
		this.hexagon = hexagon;
		this.newState = newState;
	}

	@Override
	public void execute() {
		original.clone(hexagon);
		hexagon.clone(newState);
	}

	@Override
	public void unexecute() {
		hexagon.clone(original);
	}

}