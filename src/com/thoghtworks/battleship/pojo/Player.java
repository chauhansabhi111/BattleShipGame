package com.thoghtworks.battleship.pojo;

import java.util.List;

import com.thoughtworks.battleship.util.BattleShipUtil;

public class Player {
	private String playerName;
	private BattleField battleField;
	private List<String> targets;
	private boolean turn;
	public Player(String playerName, BattleField battleField, List<String> targets, boolean turn) {
		this.playerName = playerName;
		this.setBattleField(battleField);
		this.targets = targets;
		this.turn = turn;
	}
	public List<String> getTargets() {
		return targets;
	}
	public void setTargets(List<String> targets) {
		this.targets = targets;
	}
	public void fireMissile (Player enemyPlayer) {
		String target;
		this.turn = false;
		if (!this.targets.isEmpty()) {
			target = this.targets.remove(0);
			String status;
			ShipPosition targetPoint = BattleShipUtil.convertTargetToPosition(target);
			boolean hit = enemyPlayer.getBattleField().updateBattleArea(targetPoint.getPointX(), targetPoint.getPointY());
			if (hit) {
				status = "hit";
				this.turn = true;
			} else {
				status = "miss";
				enemyPlayer.turn = true;
			}
			System.out.println(this.playerName + " fires missile with target " + target + " which got "+status);
		} else {
			System.out.println(this.playerName + " has no missile left.");
			enemyPlayer.turn = true;
		}
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public boolean isTurn() {
		return turn;
	}
	public void setTurn(boolean turn) {
		this.turn = turn;
	}
	public BattleField getBattleField() {
		return battleField;
	}
	public void setBattleField(BattleField battleField) {
		this.battleField = battleField;
	}
	
}
