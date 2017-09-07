package com.mycompany.battelship.game;

import java.util.ArrayList;
import java.util.List;

import com.mycompany.battelship.enums.BattleShipType;
import com.mycompany.battelship.pojo.BattleShipPlacer;
import com.mycompany.battelship.pojo.Location;

public class Player
{
	private  int noOfBattleShip;
	private  String playerName;
	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	private List<BattleShip> shipList;
	private int playerBattleAreaWidth;
	private List<Location> targetLocations;
	private int playerBattleAreaHeight;
	private BattleShipPlacer [][] playerBattleArea;
	
	
	public Player(int width,int height,int noOfBattleShip)
	{
		this.playerBattleAreaWidth=width;
		this.playerBattleAreaHeight=height;
		this.playerBattleArea=new BattleShipPlacer[width][height];
		this.noOfBattleShip=noOfBattleShip;
		shipList= new ArrayList<BattleShip>(noOfBattleShip);
	}
	
	public List<Location> getTargetLocations() {
		return targetLocations;
	}

	public void setTargetLocations(List<Location> targetLocations) {
		this.targetLocations = targetLocations;
	}

	/**
	 * 
	 * @return
	 */
	public int getRemainingShips()
	{
		return noOfBattleShip;
	}
	
	/**
	 * 
	 * @param battleShip
	 */
	public void placeBattleShip(BattleShip battleShip)
	{
		BattleShipPlacer shipPlacer= null;
		int hitCount=0;
		if(battleShip!=null && battleShip.getShipHeight()<=playerBattleAreaHeight && battleShip.getShipWidth()<=playerBattleAreaWidth)
		{
			BattleShipType shipType= battleShip.getShipType();
			if(shipType.toString().equals("P"))
				hitCount=2;
			else if(shipType.toString().equals("Q"))
				hitCount=1;
			for (int i = battleShip.getShipWidth(); i < playerBattleAreaWidth; i++) 
			{
				for (int j = battleShip.getShipHeight(); j < playerBattleAreaHeight; j++) 
				{
					shipPlacer= new BattleShipPlacer(shipType.toString(),hitCount);
					playerBattleArea [i][j]=shipPlacer;
				}
			}
			shipList.add(battleShip);
		}
	}
	/**
	 * 
	 * @param targetLocation
	 * @return
	 */
	public synchronized boolean launchMissile(Location targetLocation,String playerName)
	{
		boolean isSuccessfulHit=false;
		BattleShipPlacer shipPlacer= null;
	/*	if(shipList.size()==0)
		{
			System.out.println("Battleship has been destroyed so ending game");
			return isSuccessfulHit;
		}*/
		if(targetLocation!=null && targetLocation.getyCoOrdianate()<playerBattleAreaHeight && targetLocation.getxCoOrdianate()<playerBattleAreaWidth)
		{
			shipPlacer=playerBattleArea [targetLocation.getxCoOrdianate()][targetLocation.getyCoOrdianate()];
			if(shipPlacer!=null && shipPlacer.getHitCount()>0)
			{
				System.out.println(playerName+" fires a missile with target "+targetLocation.toString() +"which got hit");
				shipPlacer.setHitCount((shipPlacer.getHitCount())-1);
				playerBattleArea[targetLocation.getxCoOrdianate()][targetLocation.getyCoOrdianate()]=shipPlacer;
				isSuccessfulHit=true;
				//shipList.remove(0);
			}
			else
			{
				System.out.println("Its a unsuccessful hit so  give chance to another player");
			}
		}
		return isSuccessfulHit;
	}

	/*@Override
	public void run() 
	{
		for (Location location : targetLocations) 
		{
			boolean b=launchMissile(location,playerName);
			if(b!=true)
			{
				
			}
		}
	}*/
}
