package com.mycompany.battelship.game;

import java.util.ArrayList;
import java.util.List;

import com.mycompany.battelship.enums.BattleShipType;
import com.mycompany.battelship.pojo.BattleShipPlacer;
import com.mycompany.battelship.pojo.Location;

public class Player implements Runnable
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
	public List<BattleShip> getShipList() {
		return shipList;
	}

	private int playerBattleAreaWidth;
	private List<Location> targetLocations;
	private int playerBattleAreaHeight;
	private BattleShipPlacer [][] playerBattleArea;
	
	
	public Player(int width,int height,int noOfBattleShip)
	{
		this.playerBattleAreaWidth=width;
		this.playerBattleAreaHeight=height;
		this.playerBattleArea=new BattleShipPlacer[width][height];
		for (int i = 0; i < playerBattleArea.length; i++) 
		{
			for (int j = 0; j < playerBattleArea.length; j++) 
			{
				BattleShipPlacer battleShipPlacer= new BattleShipPlacer(null,-1);
				playerBattleArea[i][j]=battleShipPlacer;
			}
		}
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
			if(shipType!=null && shipType.toString().equals("P"))
				hitCount=2;
			else if(shipType!=null && shipType.toString().equals("Q"))
				hitCount=1;
			for (int i =0;i< battleShip.getShipWidth(); i++) 
			{
				for (int j=0;j< battleShip.getShipHeight();j++) 
				{
					shipPlacer= new BattleShipPlacer(shipType.toString(),hitCount);
					System.out.println("Placing ship with type "+shipPlacer.getShipType().toString());
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
		if(targetLocation!=null && targetLocation.getyCoOrdianate()<playerBattleAreaHeight && targetLocation.getxCoOrdianate()<playerBattleAreaWidth)
		{
			shipPlacer=playerBattleArea [targetLocation.getxCoOrdianate()][targetLocation.getyCoOrdianate()];
			int hitCount=shipPlacer.getHitCount();
			if(shipPlacer!=null && hitCount>0)
			{
				System.out.println(playerName+" fires a missile with target "+targetLocation.toString() +"which got hit");
				shipPlacer.setHitCount(hitCount-1);
				playerBattleArea[targetLocation.getxCoOrdianate()][targetLocation.getyCoOrdianate()]=shipPlacer;
				isSuccessfulHit=true;
				if(hitCount==0)
				{
					shipList.remove(0);
				}
			}
			else
			{
				System.out.println(playerName+" fires a missile with target "+targetLocation.toString() +"which got miss");
			}
		}
		return isSuccessfulHit;
	}

	@Override
	public void run()
	{
		synchronized (this) 
		{
			for (Location location : targetLocations) 
			{
				boolean result=launchMissile(location,playerName);
				if(result)
				{
					continue;
				}
				else
				{
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}

}
