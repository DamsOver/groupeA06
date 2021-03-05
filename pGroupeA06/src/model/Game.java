package model;

import java.util.List;

public class Game {
	private List<Player> players;
	private static Board board;
	
	public Game() {
		this.board=new Board().fromJson("board.JSON");
	}
	
	
	
	public static Board getBoard() {
		return board;
	}
	
	
}
