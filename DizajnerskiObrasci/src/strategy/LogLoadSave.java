package strategy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import mvc.DrawingController;

public class LogLoadSave implements LoadFileStrategy, SaveFileStrategy {
	
	private DrawingController controller;

	public LogLoadSave(DrawingController controller) {
		this.controller = controller;
	}

	@Override
	public void save(Object toSave, String path) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
			writer.write((String)toSave);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Object load(String path) {
		try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
			String line = "";
			while ((line = reader.readLine()) != null) {
				if (JOptionPane.showConfirmDialog(null, "Do you want to execute this line: \n" + line,
						"Confirm", JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION) {
					break;
				}
				controller.executeLine(line);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

}
