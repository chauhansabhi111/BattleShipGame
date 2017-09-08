package com.mycompany.battelship.util;

import com.mycompany.battelship.game.Player;

public class BattleShipUtil {
	
	public static void checkWinner(Player player1, Player player2)
	{
		if(player1.getShipList().size()>0 && player2.getShipList().size()>0)
		{
			System.out.println("Match tie");
		}
		else if(player1.getShipList().size()>0 && player2.getShipList().size()==0)
		{
			System.out.println("Player with name "+player2.getPlayerName()+" won");
		}
		else if(player2.getShipList().size()>0 && player1.getShipList().size()==0)
		{
			System.out.println("Player with name "+player1.getPlayerName()+" won");
		}
	}

}
