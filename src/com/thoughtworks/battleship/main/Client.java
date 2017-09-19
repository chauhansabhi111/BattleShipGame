package com.thoughtworks.battleship.main;

import java.util.List;

import com.thoghtworks.battleship.pojo.Player;
import com.thoghtworks.battleship.service.PlayGameService;

/**
 * This class is used to call the service method for playing battleship game
 * @author Abhishek
 *
 */
public class Client {

	/**
	 * Main method to start the game
	 * @param args
	 */
	public static void main(String[] args) {
		PlayGameService service  = new PlayGameService();
		List <Player> players = service.readInput();
		service.playGame(players);
	}

}
