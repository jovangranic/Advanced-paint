package strategy;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import geometry.Shape;

public class DrawingLoadSave implements LoadFileStrategy, SaveFileStrategy {

	@Override
	public void save(Object toSave, String path) {
		try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(path))) {
            ArrayList<Shape> shapes = (ArrayList<Shape>)toSave;
            outputStream.writeObject(shapes);
        } catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Object load(String path) {
		try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(path))) {
			return inputStream.readObject();
	    }  catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
			return null;
		} 
	}

}
