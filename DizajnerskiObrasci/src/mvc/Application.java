package mvc;

import strategy.DrawingLoadSave;

public class Application {

	public static void main(String[] args) {
		//realizacija mvc arhitekture
		DrawingModel model = new DrawingModel();
		DrawingFrame frame = new DrawingFrame();
		frame.getView().setModel(model);
		DrawingController controller = new DrawingController(model, frame);
		frame.setController(controller);
		
		DrawingLoadSave drawingStrategy = new DrawingLoadSave();
		controller.setDrawingStrategy(drawingStrategy, drawingStrategy);
		
		//frame
		frame.setVisible(true);
	}

}