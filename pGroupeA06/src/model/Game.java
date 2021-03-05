package model;

import java.util.ArrayList;
import java.util.List;

import enumerations.PlayerColors;
import exceptions.AlreadyPresentException;

public class Game {
	private List<Player> players;
	private static Board board;
	
	public Game() {
		this.board=new Board().fromJson("board.JSON");
		this.players = new ArrayList<Player>();
	}
	
	public boolean addPlayer(String name, int number) throws AlreadyPresentException {
		if(number<0||number>7) {
			return false;
		}
		else {
			if(players.size()==0) {
				players.add(new Player(name,number));
				return true;
			}
			else {
				//scanning the list of players to check if the color has already been attributed
				for(Player p : players) {
					if(p.getColor().equals(PlayerColors.getColor(number))) {
						throw new AlreadyPresentException(2.0);
					}
				}
				
				players.add(new Player(name,number));
				return true;
			}
		}
		
	}
	public void addPlayer(Player p){
		players.add(p);
	}
	
	public static Board getBoard() {
		return board;
	}
	
	public Game clone() {
		Game g = new Game();
		for(Player p : players) {
			g.addPlayer(p.clone());
		}
		return g;
	}

	public List<Player> getPlayers() {
		List<Player>p = new ArrayList<Player>();
		for(Player pl : players) {
			p.add(pl.clone());
		}
		return p;
	}	
}
