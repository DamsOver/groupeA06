package model;

import java.util.List;

import exceptions.AlreadyPresentException;

public class GameOperation {
	
	private static Game game;
	
	public GameOperation() {
		this.game= new Game();
	}
	
	public static void addPlayers(List<String> playerNames) {
		//adding the players to the list of players from the Game Class
		int i = 0;
		for(String s : playerNames) {
			try {
				game.addPlayer(s, i);
			} catch (AlreadyPresentException e) {
				e.printStackTrace();
			}
			i++;
		}
	}
	
	public static void turn() {
		//afficher l
		
		
	}
	
	
	public static Game getGame() {
		return game.clone();
	}
}
