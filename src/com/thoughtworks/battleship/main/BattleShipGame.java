package com.thoughtworks.battleship.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.thoghtworks.battleship.pojo.BattleField;
import com.thoghtworks.battleship.pojo.BattleShip;
import com.thoghtworks.battleship.pojo.Player;
import com.thoghtworks.battleship.pojo.ShipPosition;
import com.thoghtworks.battleship.pojo.ShipType;
import com.thoghtworks.battleship.service.PlayGameService;
import com.thoughtworks.battleship.util.BattleShipUtil;


public class BattleShipGame {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine();
		String[] input = line.split(" ");
		int width = Integer.parseInt(input[0]);
		int height = Character.getNumericValue(input[1].charAt(0))-Character.getNumericValue('A')+1;
		BattleField battleField1 = new BattleField(width, height);
		BattleField battleField2 = new BattleField(width, height);
		int nShips = Integer.parseInt(scanner.nextLine());
		List<BattleShip> battleShips1 = new ArrayList<>(nShips);
		List<BattleShip> battleShips2 = new ArrayList<>(nShips);
		ShipType type;
		ShipPosition start;
		ShipPosition end;
		for (int i = 0; i < nShips; i++) {
			line = scanner.nextLine();
			input = line.split(" ");
			type = input[0].equals("P") ? ShipType.P : ShipType.Q;
			width = Integer.parseInt(input[1]);
			height = Integer.parseInt(input[2]);
			start = BattleShipUtil.convertTargetToPosition(input[3]);
			end = new ShipPosition();
			end.setPointX(start.getPointX()+height-1);
			end.setPointY(start.getPointY()+width-1);
			for (int x = start.getPointX(); x <= end.getPointX(); x++) {
				for (int y = start.getPointY(); y <= end.getPointY(); y++) {
					battleField1.placeBattleShip(x, y, type);
				}
			}
			battleShips1.add(new BattleShip(height, width, type));
			start = BattleShipUtil.convertTargetToPosition(input[4]);
			end = new ShipPosition();
			end.setPointX(start.getPointX()+height-1);
			end.setPointY(start.getPointY()+width-1);
			for (int x = start.getPointX(); x <= end.getPointX(); x++) {
				for (int y = start.getPointY(); y <= end.getPointY(); y++) {
					battleField2.placeBattleShip(x, y, type);
				}
			}
			battleShips2.add(new BattleShip(height, width, type));
		}
		battleField1.setBattleShips(battleShips1);
		battleField2.setBattleShips(battleShips2);
		input = scanner.nextLine().split(" ");
		Player player1 = new Player("Player1", battleField1, new ArrayList<>(Arrays.asList(input)), false);
		input = scanner.nextLine().split(" ");
		Player player2 = new Player("Player2", battleField2, new ArrayList<>(Arrays.asList(input)), true);
		scanner.close();
		PlayGameService service  = new PlayGameService();
		service.playGame(player1, player2);
	}

}
