package geometry;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Drawing extends JPanel {

	public static void main(String args[]) {
		JFrame frame = new JFrame("Drawing");
		frame.setSize(800, 600);
		Drawing drawing = new Drawing();
		frame.getContentPane().add(drawing);
		frame.setVisible(true);
	}

	public void paint(Graphics g) {

		/*
		 * Point p = new Point(10, 20); p.draw(g);
		 * 
		 * Shape shape = new Line(new Point(30, 40), new Point(50, 60)); // Shape shape
		 * = new Shape(); shape.draw(g); // System.out.println(shape.getStartPoint());
		 * if (shape instanceof Line) { System.out.println(((Line)
		 * shape).getStartPoint()); }
		 * 
		 * g.setColor(Color.red); Circle c = new Circle (new Point(50,50), 40);
		 * c.draw(g);
		 * 
		 * g.setColor(Color.black); Rectangle r = new Rectangle(new
		 * Point(100,100),50,50); r.draw(g);
		 */

		// Vezbe 8.
		Point p = new Point(50, 50);

		Line l1 = new Line(new Point(100, 100), new Point(200, 200));

		Rectangle r1 = new Rectangle(l1.getEndPoint(), 100, 50);

		Circle c1 = new Circle(new Point(500, 100), 80);

		Donut d1 = new Donut(new Point(800, 100), 50, 25, true);

		Rectangle k1 = new Rectangle(new Point(500, 500), 50, 50);

		// Zadatak 1.
		ArrayList<Shape> shapes = new ArrayList<Shape>();
		shapes.add(p);
		shapes.get(0).draw(g);
		shapes.add(l1);
		shapes.add(c1);
		shapes.add(d1);
		shapes.add(k1);
		Iterator<Shape> it = shapes.iterator();

		while (it.hasNext()) {
			Shape sh = it.next();
			sh.moveBy(10, 0);
			System.out.println(sh);
		}
		// Collections.sort(shapes);

		// Zadatak 2.
		shapes.get(3).draw(g);

		shapes.get(shapes.size() - 1).draw(g);

		shapes.remove(1);
		// pomera se lista
		shapes.get(1).draw(g);

		shapes.get(3).draw(g);

		shapes.add(3, l1);

		// Exception
		try {
			c1.setRadius(-10);
			System.out.println("try");
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}

		it = shapes.iterator();
		while (it.hasNext()) {
			Shape sh = it.next();
			sh.moveBy(10, 0);
			sh.setSelected(true);
			sh.draw(g);
		}

	}
}