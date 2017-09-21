package com.thoghtworks.battleship.pojo;

public class BattleShip {
	private int height;
	private int width;
	private ShipType type;
	public BattleShip(int height, int width, ShipType type) {
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
}
