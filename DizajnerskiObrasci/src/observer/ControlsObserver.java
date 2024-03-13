package observer;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JButton;

import mvc.DrawingFrame;

public class ControlsObserver implements PropertyChangeListener {

	private DrawingFrame frame;
	
	public ControlsObserver(DrawingFrame frame) {
		this.frame = frame;
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		JButton button = null;
		switch (evt.getPropertyName() ) {
		case "modify":
			button = frame.getButtonModify(); break;
		case "delete":
			button = frame.getButtonDelete(); break;
		case "undo":
			button = frame.getBtnUndo(); break;
		case "redo":
			button = frame.getBtnRedo(); break;
		case "toFront":
			button = frame.getBtnToFront(); break;
		case "toBack":
			button = frame.getBtnToBack(); break;
		case "bringToFront":
			button = frame.getBtnBringToFront(); break;
		case "bringToBack":
			button = frame.getBtnBringToBack(); break;
		default:
			return;
		}
		button.setEnabled((boolean)evt.getNewValue());
	}
	
}
