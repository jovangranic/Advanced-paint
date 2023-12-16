package geometry;

import java.awt.Color;
import java.awt.Graphics;

import hexagon.Hexagon;

public class HexagonAdapter extends ShapeSurface {
	
	private Hexagon hexagon;
	
	public HexagonAdapter() {
		hexagon = new Hexagon(0,0,0);
	}
	
	public HexagonAdapter(int x, int y, int r) {
		hexagon = new Hexagon(x, y, r);
	}
	
	public HexagonAdapter(int x, int y, int r, Color edgeColor, Color fillColor) {
		this(x, y, r);
		hexagon.setBorderColor(edgeColor);
		hexagon.setAreaColor(fillColor);
	}
	
	public int getX() {
		return hexagon.getX();
	}
	
	public void setX(int x) {
		hexagon.setX(x);
	}
	
	public int getY() {
		return hexagon.getY();
	}
	
	public void setY(int Y) {
		hexagon.setY(Y);
	}
	
	public int getR() {
		return hexagon.getR();
	}
	
	public void setR(int r) {
		hexagon.setR(r);
	}
	
	@Override
	public Color getColor() {
		return hexagon.getBorderColor();
	}
	
	@Override
	public void setColor(Color color) {
		hexagon.setBorderColor(color);
	}
	
	@Override
	public Color getFillColor() {
		return hexagon.getAreaColor();
	}
	
	@Override
	public boolean isSelected() {
		return hexagon.isSelected();
	}
	
	@Override
	public void setSelected(boolean selected) {
		hexagon.setSelected(selected);
	}
	
	@Override
	public void setFillColor(Color fillColor) {
		hexagon.setAreaColor(fillColor);
	}

	@Override
	public void moveTo(int x, int y) {
		hexagon.setX(x);
		hexagon.setY(y);
	}

	@Override
	public void moveBy(int byX, int byY) {
		hexagon.setX(hexagon.getX() + byX);
		hexagon.setY(hexagon.getY() + byY);
	}

	@Override
	public int compareTo(Object o) {
		if(o instanceof HexagonAdapter) {
			HexagonAdapter h = (HexagonAdapter)o;
			return hexagon.getR() - h.getR();
		}
		return 0;
	}

	@Override
	public void fill(Graphics g) {

	}

	@Override
	public boolean contains(int x, int y) {
		return hexagon.doesContain(x, y);
	}

	@Override
	public void draw(Graphics g) {
		hexagon.paint(g);
	}

	public void clone(HexagonAdapter hexagon) {
		this.setX(hexagon.getX());
		this.setY(hexagon.getY());
		this.setR(hexagon.getR());
		this.setColor(hexagon.getColor());
		this.setFillColor(hexagon.getFillColor());
	}
}
