package model;

import java.util.ArrayList;
import java.util.List;

import application.SceneManager;
import enumerations.PlayerColors;
import exceptions.AlreadyPresentException;
import javafx.animation.Animation;
import util.Constants;


/**
 * A representation of a game.
 * This class was initially intended to be saved in a Json file and used to save the progression of the game
 * This is only in charge of the players, the deck and the board, not of the animations (except for a part of the movement of player) and not of the conduct of the game itself.
 * @author Martin
 * */
public class Game {
	
	
	/**The list of the Player */
	private List<Player> players;
	
	/**The board used in the Game*/
	private Board board;
	
	/**The integer indicating the turn of the game*/
	private int turn;
	
	/**The Deck used in the Game*/
	private Deck deck;

	/** Constructor of a Game*/
	public Game() {
		board = new Board().fromJson();
		this.players = new ArrayList<Player>();
		this.turn = 0;
		this.deck = new Deck().fromJson();
	}

	/**
	 * Adds a Player to the list of players
	 * @param name		The name of the Player
	 * @param number 	The number of the Player
	 * @throws AlreadyPresentException
	 * @return true if the Player has been successfully added to the list of questions
	 * */
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

	/**
	 * Calls the setSquare method from Player, which returns an animation of the player movement
	 * @params next The number of square you need to move
	 * @param p 	The Player that need to move
	 * @return A table containing the Animation of the movement of the player*/
	public Animation[] movePlayer(int next, Player p) {

		int tmp;
		int indexPlayer = players.indexOf(p);
		int playerSquare=board.getSquares().indexOf(p.getSquare());
		
		tmp = playerSquare + next;
		
		return p.setSquare(board.getSquares().get(tmp), indexPlayer, board.getSquares().get(playerSquare));
	}

	/**
	 * returns the Board
	 * @return the Board of the game
	 * */
	public Board getBoard() {
		return this.board;
	}

	/**Add 1 to the turn of the game*/
	public void turnUp() {
		this.turn++;
	}

	/**
	 * returns the Deck
	 * @return the Deck of the Game*/
	public Deck getDeck() {
		// not cloned to be able to remove the used cards
		return deck.clone();
	}

	/**
	 * returns the turn
	 * @return the current Turn*/
	public int getTurn() {
		return this.turn;
	}

	/**
	 * Returns a Game with the fields having the exact same value as this Game.
	 * @return a Game Cloned
	 * */
	public Game clone() {
		Game g = new Game();
		for (Player p : players) {
			g.getPlayers().add(p.clone());
		}
		g.turn = this.turn;
		g.deck = this.deck.clone();
		return g;
	}

	/**
	 * return a new List containing Player's clones
	 * @return the list of Players*/
	public List<Player> getPlayers() {
		List<Player> p = new ArrayList<Player>();
		for (Player pl : players) {
			p.add(pl);
		}
		return p;
	}
	
	/**
	 * sets the visibility of the players playing the game to true*/
	public void setPlayerVisible() {
		for(int i = Constants.NB_PLAYER-1; i>=players.size();i--) {
			SceneManager.getGame().getListImageView().get(i).setVisible(false);
		}
	}
}