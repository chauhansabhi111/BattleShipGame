package com.thoghtworks.battleship.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.thoghtworks.battleship.pojo.BattleArea;
import com.thoghtworks.battleship.pojo.BattleShip;
import com.thoghtworks.battleship.pojo.Player;
import com.thoghtworks.battleship.pojo.Point;
import com.thoghtworks.battleship.pojo.ShipType;
import com.thughtworks.battleship.util.BattleShipUtil;
/**
 * This class is service class which includes service methods for reading inputs and playing game
 * @author Abhishek
 *
 */
public class PlayGameService {
	/**
	 * This method is a service method to read all the input from command line
	 * @return
	 */
	public List<Player> readInput () {
		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine();
		String[] input = line.split(" ");
		int width = Integer.parseInt(input[0]);
		int height = Character.getNumericValue(input[1].charAt(0))-Character.getNumericValue('A')+1;
		BattleArea area1 = new BattleArea(width, height);
		BattleArea area2 = new BattleArea(width, height);
		List <Player> players = new ArrayList<>();
		Player player1 = new Player();
		Player player2 = new Player();
		player1.setBattleArea(area1);
		player2.setBattleArea(area2);
		int nShips = Integer.parseInt(scanner.nextLine());
		List<BattleShip> battleShips1 = new ArrayList<>(nShips);
		List<BattleShip> battleShips2 = new ArrayList<>(nShips);
		ShipType type;
		Point start;
		Point end;
		for (int i = 0; i < nShips; i++) {
			line = scanner.nextLine();
			input = line.split(" ");
			type = input[0].equals("P") ? ShipType.P : ShipType.Q;
			width = Integer.parseInt(input[1]);
			height = Integer.parseInt(input[2]);
			start = BattleShipUtil.convertPositionToPoint(input[3]);
			end = new Point();
			end.setPointX(start.getPointX()+height-1);
			end.setPointY(start.getPointY()+width-1);
			for (int j = start.getPointX(); j <= end.getPointX(); j++) {
				for (int k = start.getPointY(); k <= end.getPointY(); k++) {
					area1.setArea(j, k, type);
				}
			}
			battleShips1.add(new BattleShip(height, width, start, type));
			start = BattleShipUtil.convertPositionToPoint(input[4]);
			end = new Point();
			end.setPointX(start.getPointX()+height-1);
			end.setPointY(start.getPointY()+width-1);
			for (int j = start.getPointX(); j <= end.getPointX(); j++) {
				for (int k = start.getPointY(); k <= end.getPointY(); k++) {
					area2.setArea(j, k, type);
				}
			}
			battleShips2.add(new BattleShip(height, width, start, type));
		}
		player1.setBattleShips(battleShips1);
		player2.setBattleShips(battleShips2);
		input = scanner.nextLine().split(" ");
		player1.setTargets(Arrays.asList(input));
		input = scanner.nextLine().split(" ");
		player2.setTargets(Arrays.asList(input));
		players.add(player1);
		players.add(player2);
		scanner.close();
		return players;
	}
	
	/**
	 * This mehtod takes a list of player as input and use to play game
	 * @param players
	 */
	public void playGame (List<Player> players)
	{
		String target;
		Player player1 = players.get(0);
		Player player2 = players.get(1);
		boolean p1Turn = true;
		boolean p2Turn = false;
		Iterator<String> i1 = player1.getTargets().iterator();
		Iterator<String> i2 = player2.getTargets().iterator();
		while ((p1Turn || p2Turn) && (i1.hasNext() || i2.hasNext())) 
		{
			if (p1Turn) 
			{
				if (i1.hasNext())
				{
					target = i1.next();
					System.out.print("P1 fires missile with target " + target + " which got ");
					if (BattleShipUtil.updateTargetArea(player2.getBattleArea(), BattleShipUtil.convertPositionToPoint(target)))
					{
						System.out.println(" hit");
						p2Turn = false;
						if (player2.getBattleArea().getBattleAreaHealth() == 0) 
						{
							break;
						}
						continue;
					} 
					else 
					{
						p2Turn = true;
						System.out.println(" miss");
					}
				} 
				else 
				{
					p2Turn = true;
					System.out.println("P1 has no missile left");
				}
			}
			if (p2Turn) 
			{
				if (i2.hasNext())
				{
					target = i2.next();
					System.out.print("P2 fires missile with target " + target + " which got ");
					if (BattleShipUtil.updateTargetArea(player1.getBattleArea(), BattleShipUtil.convertPositionToPoint(target)))
					{
						System.out.println(" hit");
						p1Turn = false;
						if (player1.getBattleArea().getBattleAreaHealth() == 0) 
						{
							break;
						}
						continue;
					}
					else 
					{
						p1Turn = true;
						System.out.println(" miss");
					}
				} 
				else
				{
					p1Turn = true;
					System.out.println("P2 has no missile left");
				}
			}
		}
		if (player1.getBattleArea().getBattleAreaHealth() == 0)
		{
			System.out.println("P2 wont the battle");
		}
		else if (player2.getBattleArea().getBattleAreaHealth() == 0) 
		{
			System.out.println("P1 wont the battle");
		} 
		else
		{
			System.out.println("No winner and there is a tie between both players");
		}
	}
}
