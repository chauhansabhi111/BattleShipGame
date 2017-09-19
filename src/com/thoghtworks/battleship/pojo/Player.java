package com.thoghtworks.battleship.pojo;

import java.util.List;
/**
 * This class contains all the properties of a player 
 * @author Abhishek
 *
 */
public class Player {
	private BattleArea battleArea;
	private List<BattleShip> battleShips;
	private List<String> targets;
	public BattleArea getBattleArea() {
		return battleArea;
	}
	public void setBattleArea(BattleArea battleArea) {
		this.battleArea = battleArea;
	}
	public List<BattleShip> getBattleShips() {
		return battleShips;
	}
	public void setBattleShips(List<BattleShip> battleShips) {
		this.battleShips = battleShips;
	}
	public List<String> getTargets() {
		return targets;
	}
	public void setTargets(List<String> targets) {
		this.targets = targets;
	}
	
}
