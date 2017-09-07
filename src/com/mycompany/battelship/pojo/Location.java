package com.mycompany.battelship.pojo;

public class Location {
	private int xCoOrdianate;
	private int yCoOrdianate;
	public int getxCoOrdianate() {
		return xCoOrdianate;
	}
	public Location(int xCoOrdianate, int yCoOrdianate) {
		super();
		this.xCoOrdianate = xCoOrdianate;
		this.yCoOrdianate = yCoOrdianate;
	}
	public void setxCoOrdianate(int xCoOrdianate) {
		this.xCoOrdianate = xCoOrdianate;
	}
	public int getyCoOrdianate() {
		return yCoOrdianate;
	}
	public void setyCoOrdianate(int yCoOrdianate) {
		this.yCoOrdianate = yCoOrdianate;
	}

	@Override
	public String toString() 
	{
		return "["+xCoOrdianate+" "+yCoOrdianate+"]";
	}
}
