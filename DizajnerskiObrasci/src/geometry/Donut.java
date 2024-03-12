package geometry;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

public class Donut extends Circle {

	private int innerRadius;

	public Donut() {

	}

	public Donut(Point center, int radius, int innerRadius) {
		super(center, radius);
		this.innerRadius = innerRadius;
	}

	public Donut(Point center, int radius, int innerRadius, Color edgeColor, Color fillColor) {
		this(center, radius, innerRadius);
		this.color = edgeColor;
		this.fillColor = fillColor;
	}

	public Donut(Point center, int radius, int innerRadius, Color edgeColor, Color fillColor, boolean selected) {
		this(center, radius, innerRadius, edgeColor, fillColor);
		this.selected = selected;
	}

	public boolean equals(Object obj) {
		if (obj instanceof Donut) {
			Donut pomocni = (Donut) obj;
			if (super.equals(obj) && innerRadius == pomocni.innerRadius) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public boolean contains(Point clickPoint) {
		return super.contains(clickPoint) && getCenter().distance(clickPoint.getX(), clickPoint.getY()) >= innerRadius;
	}

	public boolean contains(int x, int y) {
		return super.contains(x, y) && getCenter().distance(x, y) >= innerRadius;
	}

	public double area() {
		return super.area() - innerRadius * innerRadius * Math.PI;
	}

	public void fill(Graphics g) {
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		Ellipse2D outerCircle = new Ellipse2D.Double(getCenter().getX() - getRadius(), getCenter().getY() - getRadius(),
				getRadius() * 2, getRadius() * 2);

		Ellipse2D innerCircle = new Ellipse2D.Double(getCenter().getX() - innerRadius, getCenter().getY() - innerRadius,
				innerRadius * 2, innerRadius * 2);

		Area donutArea = new Area(outerCircle);
		donutArea.subtract(new Area(innerCircle));
		g2d.setColor(this.fillColor);
		g2d.fill(donutArea);

		g2d.dispose();
	}

	@Override
	public void draw(Graphics g) {
		super.draw(g);
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		this.fill(g);
		g2d.setColor(this.color);
		// Stroke
		g2d.setStroke(new BasicStroke(2));
		g2d.drawOval(this.center.getX() - getRadius(), this.center.getY() - getRadius(), getRadius() * 2,
				getRadius() * 2);
		g2d.drawOval(this.center.getX() - innerRadius, this.center.getY() - innerRadius, innerRadius * 2,
				innerRadius * 2);

		if (isSelected()) {
			g2d.setColor(Color.BLUE);
			g2d.drawRect(getCenter().getX() - 2, getCenter().getY() - 2, 4, 4);
			g2d.drawRect(getCenter().getX() - innerRadius - 2, getCenter().getY() - 2, 4, 4);
			g2d.drawRect(getCenter().getX() + innerRadius - 2, getCenter().getY() - 2, 4, 4);
			g2d.drawRect(getCenter().getX() - 2, getCenter().getY() - innerRadius - 2, 4, 4);
			g2d.drawRect(getCenter().getX() - 2, getCenter().getY() + innerRadius - 2, 4, 4);
			g2d.setColor(Color.BLACK);
		}

		g2d.dispose();
	}

	@Override
	public int compareTo(Object obj) {
		if (obj instanceof Donut) {
			Donut shapeToCompare = (Donut) obj;
			return (int) (this.area() - shapeToCompare.area());
		}
		return 0;
	}

	public int getInnerRadius() {
		return innerRadius;
	}

	public void setInnerRadius(int innerRadius) {
		this.innerRadius = innerRadius;
	}

	public String toString() {
		// Center=(x,y), radius= radius, innerRadius=innerRadius
		return super.toString() + ", innerRadius=" + innerRadius;
	}

	public void clone(Donut donut) {
		super.clone(donut);
		this.innerRadius = donut.innerRadius;
	}
}
