package command;

import java.util.ArrayList;

import geometry.Shape;
import mvc.DrawingModel;

public class DeselectShapesCmd implements Command {
	private ArrayList<Shape> selectedShapes;
	private DrawingModel model;
	
	@Override
	public String toString() {
		String indexes = "";
		for (int i = 0; i < selectedShapes.size(); i++) {
			indexes += model.indexOf(selectedShapes.get(i));
			if(i != selectedShapes.size() -1) {
				indexes += ", ";
			}
		}
		return "Deselect [selectedShapes=" + indexes + "]";
	}

	public DeselectShapesCmd(ArrayList<Shape> selectedShapes, DrawingModel model) {
		this.selectedShapes = selectedShapes;
		this.model = model;
	}
	
	public DeselectShapesCmd(Shape selectedShape, DrawingModel model) {
		this.selectedShapes = new ArrayList<Shape>();
		this.selectedShapes.add(selectedShape);
		this.model = model;
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