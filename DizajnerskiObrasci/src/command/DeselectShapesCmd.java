package command;

import java.util.ArrayList;
import geometry.Shape;

public class DeselectShapesCmd implements Command {
	private ArrayList<Shape> selectedShapes;

	public DeselectShapesCmd(ArrayList<Shape> selectedShapes) {
		this.selectedShapes = selectedShapes;
	}
	
	public DeselectShapesCmd(Shape selectedShape) {
		this.selectedShapes = new ArrayList<Shape>();
		this.selectedShapes.add(selectedShape);
	}

	@Override
	public void execute() {
		for (int i = 0; i < selectedShapes.size(); i++) {
			selectedShapes.get(i).setSelected(false);
		}
	}

	@Override
	public void unexecute() {
		for (int i = 0; i < selectedShapes.size(); i++) {
			selectedShapes.get(i).setSelected(true);
		}
	}

}