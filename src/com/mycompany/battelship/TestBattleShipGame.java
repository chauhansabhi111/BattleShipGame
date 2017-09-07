package com.mycompany.battelship;

import java.util.ArrayList;
import java.util.List;

import com.mycompany.battelship.enums.BattleShipType;
import com.mycompany.battelship.game.BattleShip;
import com.mycompany.battelship.game.Player;
import com.mycompany.battelship.pojo.Location;

public class TestBattleShipGame 
{

	
	public static void main(String[] args) 
	{
		Player player1 = new Player(5,5,2);
		BattleShip ship1= new BattleShip();
		ship1.setShipType(BattleShipType.Q);
		ship1.setShipWidth(1);
		ship1.setShipHeight(1);
		Location location1= new Location(1,1);
		location1.setxCoOrdianate(1);
		location1.setxCoOrdianate(1);
		ship1.setShipLocation(location1);
		
		BattleShip ship2= new BattleShip();
		ship2.setShipType(BattleShipType.P);
		ship2.setShipWidth(2);
		ship2.setShipHeight(1);
		Location location2= new Location(4,4);
		location2.setxCoOrdianate(4);
		location2.setxCoOrdianate(4);
		ship2.setShipLocation(location2);
		
		player1.placeBattleShip(ship1);
		player1.placeBattleShip(ship2);
		
		Player player2 = new Player(5,5,2);
		BattleShip ship3= new BattleShip();
		ship3.setShipType(BattleShipType.Q);
		ship3.setShipWidth(1);
		ship3.setShipHeight(1);
		Location location3= new Location(2,2);
		location3.setxCoOrdianate(2);
		location3.setxCoOrdianate(2);
		ship3.setShipLocation(location3);
		
		BattleShip ship4= new BattleShip();
		ship4.setShipType(BattleShipType.P);
		ship4.setShipWidth(2);
		ship4.setShipHeight(1);
		Location location4= new Location(4,4);
		location4.setxCoOrdianate(4);
		location4.setxCoOrdianate(4);
		ship4.setShipLocation(location4);
		
		player2.placeBattleShip(ship3);
		player2.placeBattleShip(ship4);
		
		List<Location> player1TargeteLocations= new ArrayList<Location>();
		player1TargeteLocations.add(new Location(1, 1));
		player1TargeteLocations.add(new Location(2, 2));
		player1TargeteLocations.add(new Location(2, 2));
		player1TargeteLocations.add(new Location(3, 2));
		
		List<Location> player2TargeteLocations= new ArrayList<Location>();
		player2TargeteLocations.add(new Location(1, 1));
		player2TargeteLocations.add(new Location(2, 2));
		player2TargeteLocations.add(new Location(3, 3));
		player2TargeteLocations.add(new Location(1, 1));
		player2TargeteLocations.add(new Location(4, 1));
		player2TargeteLocations.add(new Location(5, 1));
		player2TargeteLocations.add(new Location(4, 4));
		player2TargeteLocations.add(new Location(5, 5));
		player2TargeteLocations.add(new Location(5, 5));
		
		player1.setTargetLocations(player1TargeteLocations);
		player2.setTargetLocations(player2TargeteLocations);
		boolean isSuccess=player1.launchMissile(new Location(1,1),"Player1");
		isSuccess=player2.launchMissile(new Location(1,1),"Player2");
		isSuccess=player1.launchMissile(new Location(2,2),"Player1");
		System.out.println(isSuccess);
	}
	
}
