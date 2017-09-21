package com.thoghtworks.battleship.pojo;

import java.util.List;

public class BattleField {
	private int width;
	private int height;
	private int[][] battleArea;
	private List<BattleShip> battleShips;
	public BattleField(int width, int height) {
		this.width = width;
		this.height = height;
		battleArea = new int[height][width];
	}
	public void placeBattleShip (int x, int y, ShipType type) {
		this.battleArea[x][y] = type.getNumVal();
	}
	
	public boolean updateBattleArea (int x, int y) {
		if (this.battleArea[x][y] != 0) {
			this.battleArea[x][y]--;
			return true;
		}
		return false;
	}
	
	public int getBattleAreaHealth () {
		int health =0;
		for (int i = 0; i < this.height; i++) {
			for (int j =0; j< this.width; j++) {
				health += this.battleArea[i][j];
			}
		}
		return health;
	}
	public void displayBattleArea () {
		for (int i = 0; i < this.height; i++) {
			for (int j =0; j< this.width; j++) {
				System.out.print(this.battleArea[i][j]+ "  ");
			}
			System.out.println();
		}
	}
	public List<BattleShip> getBattleShips() {
		return battleShips;
	}
	public void setBattleShips(List<BattleShip> battleShips) {
		this.battleShips = battleShips;
	}
}
