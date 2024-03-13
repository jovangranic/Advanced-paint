package observer;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ObservableControls {
	
	private boolean modifyOn;
	private boolean deleteOn;
	private boolean undoOn;
	private boolean redoOn;
	private boolean toFrontOn;
	private boolean toBackOn;
	private boolean bringToFrontOn;
	private boolean bringToBackOn;
	private PropertyChangeSupport support = new PropertyChangeSupport(this);
	
	public void addListener(PropertyChangeListener pcl) {
		support.addPropertyChangeListener(pcl);
	}
	
	public void removeListener(PropertyChangeListener pcl) {
		support.removePropertyChangeListener(pcl);
	}
	
	public void setModify(boolean b) {
		support.firePropertyChange("modify", this.modifyOn, b);
		this.modifyOn = b;
	}
	
	public void setDelete(boolean b) {
		support.firePropertyChange("delete", this.deleteOn, b);
		this.deleteOn = b;
	}
	
	public void setUndo(boolean b) {
		support.firePropertyChange("undo", this.undoOn, b);
		this.undoOn = b;
	}
	
	public void setRedo(boolean b) {
		support.firePropertyChange("redo", this.redoOn, b);
		this.redoOn = b;
	}
	
	public void setToFront(boolean b) {
		support.firePropertyChange("toFront", this.toFrontOn, b);
		this.toFrontOn = b;
	}
	
	public void setToBack(boolean b) {
		support.firePropertyChange("toBack", this.toBackOn, b);
		this.toBackOn = b;
	}
	
	public void setBringToFront(boolean b) {
		support.firePropertyChange("bringToFront", this.bringToFrontOn, b);
		this.bringToFrontOn = b;
	}
	
	public void setBringToBack(boolean b) {
		support.firePropertyChange("bringToBack", this.bringToBackOn, b);
		this.bringToBackOn = b;
	}
}
