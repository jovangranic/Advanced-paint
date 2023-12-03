package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends ShapeSurface {
	private Point upperLeftPoint;
	private int width;
	private int height;

	public Rectangle() {
	}

	public Rectangle(Point upperLeftPoint, int width, int height) {
		this.upperLeftPoint = upperLeftPoint;
		this.width = width;
		this.height = height;
	}

	public Rectangle(Point upperLeftPoint, int width, int height, Color edgeColor, Color fillColor) {
		this(upperLeftPoint, width, height);
		this.color = edgeColor;
		this.fillColor = fillColor;
	}

	public Rectangle(Point upperLeftPoint, int width, int height, Color edgeColor, Color fillColor, boolean selected) {
		this(upperLeftPoint, width, height, edgeColor, fillColor);
		this.selected = selected;
	}

	public boolean equals(Object obj) {
		if (obj instanceof Rectangle) {
			Rectangle pomocna = (Rectangle) obj;
			if (this.upperLeftPoint.equals(pomocna.upperLeftPoint) && this.width == pomocna.width
					&& this.height == pomocna.height)
				return true;
			else
				return false;
		} else
			return false;
	}

	public boolean contains(int x, int y) {
		return x >= upperLeftPoint.getX() && x <= this.upperLeftPoint.getX() + width && y >= upperLeftPoint.getY()
				&& y <= getUpperLeftPoint().getY() + height;
	}

	public boolean contains(Point clickPoint) {
		return clickPoint.getX() >= upperLeftPoint.getX() && clickPoint.getX() <= this.upperLeftPoint.getX() + width
				&& clickPoint.getY() >= upperLeftPoint.getY()
				&& clickPoint.getY() <= getUpperLeftPoint().getY() + getHeight();
	}

	public int area() {
		return width * height;
	}

	public int circumference() {
		return 2 * (width + height);
	}

	@Override
	public void moveTo(int x, int y) {
		upperLeftPoint.moveTo(x, y);
	}

	@Override
	public void moveBy(int byX, int byY) {
		upperLeftPoint.moveBy(byX, byY);
	}

	@Override
	public int compareTo(Object obj) {
		if (obj instanceof Rectangle) {
			Rectangle shapeToCompare = (Rectangle) obj;
			return this.area() - shapeToCompare.area();
		}
		return 0;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void setUpperLeftPoint(Point upperLeftPoint) {
		this.upperLeftPoint = upperLeftPoint;
	}

	public Point getUpperLeftPoint() {
		return upperLeftPoint;
	}

	public String toString() {
		return "Upper left point:" + upperLeftPoint + ", width =" + width + ",height = " + height;
	}

	@Override
	public void fill(Graphics g) {
		g.setColor(fillColor);
		g.fillRect(this.upperLeftPoint.getX() + 1, this.upperLeftPoint.getY() + 1, this.width - 1, this.height - 1);
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(this.color);
		g.drawRect(upperLeftPoint.getX(), upperLeftPoint.getY(), width, height);
		this.fill(g);
		if (isSelected()) {
			g.setColor(Color.blue);
			g.drawRect(upperLeftPoint.getX() - 2, upperLeftPoint.getY() - 2, 4, 4);
			g.drawRect(upperLeftPoint.getX() + width - 2, upperLeftPoint.getY() - 2, 4, 4);
			g.drawRect(upperLeftPoint.getX() - 2, upperLeftPoint.getY() + height - 2, 4, 4);
			g.drawRect(upperLeftPoint.getX() + width - 2, upperLeftPoint.getY() + height - 2, 4, 4);
			g.setColor(Color.black);
		}
	}
}
