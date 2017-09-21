package com.thoghtworks.battleship.service;

import com.thoghtworks.battleship.pojo.Player;

public class PlayGameService {
	
	public void playGame (Player player1, Player player2) 
	{
		while (!(player1.getTargets().isEmpty() && player2.getTargets().isEmpty())
				&& player1.getBattleField().getBattleAreaHealth() != 0 && player2.getBattleField().getBattleAreaHealth() != 0) {

			if (player1.isTurn()) {
				player1.fireMissile(player2);
			} else if (player2.isTurn()) {
				player2.fireMissile(player1);
			} 
		}
		if (player1.getBattleField().getBattleAreaHealth() == 0) {
			System.out.println(player2.getPlayerName()+" won the battle");
		} else if (player2.getBattleField().getBattleAreaHealth() == 0) {
			System.out.println(player1.getPlayerName()+" won the battle");
		} else {
			System.out.println("No winner");
		}
	}
}
