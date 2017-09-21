package com.thoghtworks.battleship.pojo;

public enum ShipType {
	P(1), Q(2);
	
	private int numVal;
	ShipType(int numVal) {
        this.numVal = numVal;
    }
    public int getNumVal() {
        return numVal;
    }
}
