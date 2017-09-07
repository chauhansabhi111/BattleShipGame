package com.mycompany.battelship.game;

import com.mycompany.battelship.enums.BattleShipType;
import com.mycompany.battelship.pojo.Location;

public class BattleShip {

	private BattleShipType shipType;
	private int shipWidth;
	private int shipHeight;
	private Location shipLocation;
	
	public BattleShipType getShipType() {
		return shipType;
	}
	public void setShipType(BattleShipType shipType) {
		this.shipType = shipType;
	}
	public int getShipWidth() {
		return shipWidth;
	}
	public void setShipWidth(int shipWidth) {
		this.shipWidth = shipWidth;
	}
	public int getShipHeight() {
		return shipHeight;
	}
	public void setShipHeight(int shipHeight) {
		this.shipHeight = shipHeight;
	}
	public Location getShipLocation() {
		return shipLocation;
	}
	public void setShipLocation(Location shipLocation) {
		this.shipLocation = shipLocation;
	}
}
