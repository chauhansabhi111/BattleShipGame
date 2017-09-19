package com.thoghtworks.battleship.pojo;
/**
 * This class contains properties of battleship
 * @author Abhishek
 *
 */
public class BattleShip {
	private int height;
	private int width;
	private Point start;
	private ShipType type;
	public BattleShip(int height, int width, Point start, ShipType type) {
		this.start = start;
		this.height = height;
		this.width = width;
		this.type = type;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public ShipType getType() {
		return type;
	}
	public void setType(ShipType type) {
		this.type = type;
	}
	public Point getStart() {
		return start;
	}
	public void setStart(Point start) {
		this.start = start;
	}
}
