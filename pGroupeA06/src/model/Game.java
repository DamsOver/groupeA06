package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import application.SceneManager;
import enumerations.PlayerColors;
import enumerations.Theme;
import exceptions.AlreadyPresentException;
import javafx.animation.Animation;
import javafx.animation.Transition;
import util.Constants;
import vue.GameAP;

public class Game {
	private List<Player> players;
	private static Board board;
	private int turn;
	private Deck deck;

	public Game() {
		board = new Board().fromJson();
		this.players = new ArrayList<Player>();
		this.turn = 0;
		this.deck = new Deck().fromJson();
	}

	public boolean addPlayer(String name, int number) throws AlreadyPresentException {
		if (number < 0 || number > 7) {
			return false;
		} else {
			if (players.size() == 0) {
				players.add(new Player(name, number));
				return true;
			} else {
				// scanning the list of players to check if the color has already been
				// attributed
				for (Player p : players) {
					if (p.getColor().equals(PlayerColors.getColor(number))) {
						throw new AlreadyPresentException(2.0);
					}
				}

				players.add(new Player(name, number));
				return true;
			}
		}

	}

	public void addPlayer(Player p) {
		players.add(p);
	}

	public Animation[] movePlayer(int next, Square sq, Player p) {

		int tmp;
		int indexPlayer = players.indexOf(p);
		int playerSquare=board.getSquares().indexOf(p.getSquare());
		
		tmp = playerSquare + next;
		
		return p.setSquare(board.getSquares().get(tmp),this,p, indexPlayer, board.getSquares().get(playerSquare));
	}

	public static Board getBoard() {
		return board;
	}

	public void turnUp() {
		this.turn++;
	}

	public Deck getDeck() {

		// not clone to be able to remove the used cards
		return deck.clone();
	}

	public int getTurn() {
		return this.turn;
	}

	public Game clone() {
		Game g = new Game();
		for (Player p : players) {
			g.addPlayer(p.clone());
		}
		g.turn = this.turn;
		g.deck = this.deck.clone();
		return g;
	}

	public List<Player> getPlayers() {
		List<Player> p = new ArrayList<Player>();
		for (Player pl : players) {
			p.add(pl);
		}
		return p;
	}
}