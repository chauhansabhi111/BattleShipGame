package com.thoghtworks.battleship.pojo;
/**
 * This class contains fields of battle area and some of the utility methods of it
 * @author Abhishek
 *
 */
public class BattleArea {
	private int width;
	private int height;
	private int[][] area;
	public BattleArea(int width, int height) {
		this.width = width;
		this.height = height;
		area = new int[height][width];
	}
	public void setArea (int x, int y, ShipType type) {
		this.area[x][y] = type.getNumVal();
	}
	
	public boolean updateArea (int x, int y) {
		if (this.area[x][y] != 0) {
			this.area[x][y]--;
			return true;
		}
		return false;
	}
	
	public int getBattleAreaHealth () {
		int health =0;
		for (int i = 0; i < this.height; i++) {
			for (int j =0; j< this.width; j++) {
				health += this.area[i][j];
			}
		}
		return health;
	}
	public void displayBattleArea () {
		for (int i = 0; i < this.height; i++) {
			for (int j =0; j< this.width; j++) {
				System.out.print(this.area[i][j]+ "  ");
			}
			System.out.println();
		}
	}
}
