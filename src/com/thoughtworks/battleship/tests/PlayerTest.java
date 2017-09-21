package com.thoughtworks.battleship.tests;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.thoghtworks.battleship.pojo.BattleField;
import com.thoghtworks.battleship.pojo.Player;
import com.thoghtworks.battleship.pojo.ShipType;

public class PlayerTest {

	Player player1;
	Player player2;
	
	@Before
	public void setup() {
		BattleField battleField1 = new BattleField(3, 3);
		battleField1.placeBattleShip(0, 0, ShipType.P);
		battleField1.placeBattleShip(0, 1, ShipType.Q);
		List<String> target1 = new ArrayList<>();
		target1.add("A2");
		target1.add("B2");
		player1 = new Player("Player1", battleField1, target1, true);
		
		BattleField battleField2 = new BattleField(3, 3);
		battleField2.placeBattleShip(0, 1, ShipType.P);
		battleField2.placeBattleShip(1, 1, ShipType.Q);
		List<String> target2 = new ArrayList<>();
		target2.add("A1");
		target2.add("B2");
		player2 = new Player("Player2", battleField2, target2, false);
		
	}
	@Test
	public void testFireMissile() {
		player1.fireMissile(player2);
		assertTrue(player1.isTurn());
	}

}
