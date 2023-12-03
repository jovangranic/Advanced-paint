package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends ShapeSurface {
	protected Point center;
	private int radius;

	public Circle() {

	}

	public Circle(Point center, int radius) {
		this.center = center;
		this.radius = radius;
	}

	public Circle(Point center, int radius, boolean selected) {
		this(center, radius);
		this.selected = selected;
	}

	public Circle(Point center, int radius, Color edgeColor, Color fillColor) {
		this(center, radius);
		this.color = edgeColor;
		this.fillColor = fillColor;
	}

	public boolean equals(Object obj) {
		if (obj instanceof Circle) {
			Circle pomocni = (Circle) obj;
			if (this.center.equals(pomocni.center) && this.radius == pomocni.radius) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public boolean contains(int x, int y) {
		return this.center.distance(x, y) <= radius;
	}

	public boolean contains(Point clickPoint) {
		return getCenter().distance(clickPoint.getX(), clickPoint.getY()) <= radius;
	}

	public double area() {
		return radius * getRadius() * Math.PI;
	}

	public double circumference() {
		return 2 * radius * Math.PI;
	}

	@Override
	public void moveTo(int x, int y) {
		center.moveTo(x, y);
	}

	@Override
	public void moveBy(int byX, int byY) {
		center.moveBy(byX, byY);
	}

	@Override
	public int compareTo(Object obj) {
		if (obj instanceof Circle) {
			Circle shapeToCompare = (Circle) obj;
			return (int) (this.area() - shapeToCompare.area());
		}
		return 0;
	}

	public Point getCenter() {
		return center;
	}

	public void setCenter(Point center) {
		this.center = center;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public String toString() {
		return "Center=" + center + ", radius=" + radius;
	}

	@Override
	public void fill(Graphics g) {
		g.setColor(this.fillColor);
		g.fillOval(this.center.getX() - this.radius + 1, this.center.getY() - this.radius + 1, this.radius * 2 - 2,
				this.radius * 2 - 2);
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(this.color);
		g.drawOval(this.center.getX() - radius, this.center.getY() - radius, radius + radius, radius + radius);
		this.fill(g);
		if (isSelected()) {
			g.setColor(Color.BLUE);
			g.drawRect(center.getX() - 2, center.getY() - 2, 4, 4);
			g.drawRect(center.getX() - radius - 2, center.getY() - 2, 4, 4);
			g.drawRect(center.getX() + radius - 2, center.getY() - 2, 4, 4);
			g.drawRect(center.getX() - 2, center.getY() - radius - 2, 4, 4);
			g.drawRect(center.getX() - 2, center.getY() + radius - 2, 4, 4);
			g.setColor(Color.black);
		}
	}

}