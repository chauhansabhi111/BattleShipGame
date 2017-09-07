package com.mycompany.battelship.pojo;

public class BattleShipPlacer {
	
	private String shipType;
	private int hitCount;
	public String getShipType() {
		return shipType;
	}
	public int getHitCount() {
		return hitCount;
	}
	public void setHitCount(int hitCount) {
		this.hitCount = hitCount;
	}
	public BattleShipPlacer(String shipType, int hitCount) {
		super();
		this.shipType = shipType;
		this.hitCount = hitCount;
	}
}
