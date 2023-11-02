package geometry;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Shape implements Moveable, Comparable{
	protected boolean selected;
	protected Color color;
	protected Color innerColor;

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Color getInnerColor() {
		return innerColor;
	}

	public void setInnerColor(Color innerColor) {
		this.innerColor = innerColor;
	}

	public Shape() {

	}

	public Shape(boolean selected) {
		this.selected = selected;
	}
	
	public Shape(Color color) {
		this.color = color;
	}
	public Shape(Color edgeColor, Color innerColor) {
		this(edgeColor);
		this.innerColor = innerColor;
	}
	
	public abstract boolean contains(int x, int y);
	public abstract void draw(Graphics g);

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
}