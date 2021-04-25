package model;

import java.util.List;

import application.SceneManager;
import enumerations.PlayerColors;
import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.util.Duration;
import util.Constants;

/**
 * An object representing a player.
 * @author Damien
 * */

public class Player {
	
	/**
	 * The name of the player
	 */
	private String name;
	
	/**
	 * the color of the player*/
	private PlayerColors color;
	
	/**
	 * The Square the player is currently on*/
	private Square square;
	
	/**
	 * The last Square the player was on*/
	private Square oldSquare;

	/**
	 * Constructor without any previous square
	 * @param name		The name of the player
	 * @param number	The number of the player, which will become a Color 
	 * */
	public Player(String name, int number) {
		this.name = name;
		this.color = PlayerColors.getColor(number);
		this.square = SceneManager.getGameOperation().getGame().getBoard().getSquares().get(0);
	}

	/**
	 * Constructor with a previous square
	 * @param name		The name of the player
	 * @param number	The number of the player, which will become a Color 
	 * @param sq		The square the player was previously on
	 * */
	public Player(String name, int number, Square sq) {
		this.name = name;
		this.color = PlayerColors.getColor(number);
		this.square = sq;
	}

	/**
	 * returns the name
	 * @return the name of the Player
	 * */
	public String getName() {
		return name;
	}

	/**
	 * Convert the Player Object and his fields into a String
	 * @return The String describing the Object
	 * */
	@Override
	public String toString() {
		return "Player [name=" + name + ", color=" + color + ", square=" + square + ", oldSquare=" + oldSquare + "]";
	}
	
	/**
	 * Checks if two objects are equals
	 * @param obj 	The Object the method compares to
	 * @return True if this is equal to the Object obj
	 * */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		if (color != other.color)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (square == null) {
			if (other.square != null)
				return false;
		} else if (!square.equals(other.square))
			return false;
		return true;
	}

	/**
	 * returns the Color
	 * @return the PlayerColor of the Player
	 * */
	public PlayerColors getColor() {
		return color;
	}

	/**
	 * returns the current Square
	 * @return the current Square of the Player
	 * */
	public Square getSquare() {
		return square;
	}

	/**
	 * returns the last Square
	 * @return the last Square of the Player
	 * */
	public Square getOldSquare() {
		return oldSquare;
	}

	/**
	 * Sets a new current Square 
	 * @param square	The new Square*/
	public void setSquare(Square square) {
		//no need for clone, the squares are not unique
		this.square = square;
	}
	
	/**
	 * Sets an old Square 
	 * @param square	The old Square the player was on*/
	public void setOldSquare(Square square) {
		this.oldSquare = square;
	}

	/**
	 * Moves the player to an another square
	 *  @param square		the new square the player will be on
	 *  @param indexPlayer	the index of the player in the list of players
	 *  @param oldSquare	the lastSquare the player was on
	 *  old square is useful for the firsts turns of the game
	 *  @return a table of transition*/
	public Animation[] setSquare(Square square, int indexPlayer, Square oldSquare) {
		
		this.setSquare(square);
		this.setOldSquare(oldSquare);
		List<Square> squares = SceneManager.getGameOperation().getGame().getBoard().getSquares();

		int indexOfSquare = squares.indexOf(this.getSquare());
		int indexOfOldSquare = squares.indexOf(this.getOldSquare());
		
		Square currentSquare = oldSquare;
		Square targetSquare;
		
		
		Animation[] a = new Animation[Math.abs(indexOfSquare-indexOfOldSquare)+1];
		a[0]=SceneManager.getGameOperation().animation(Constants.ANIMATION_TIME_START,
				SceneManager.getStackGame(), null);
		
		for(int i = 0 ; i <Math.abs(indexOfSquare-indexOfOldSquare);i++) {
			double distX = 0;
			double distY = 0;
			
			int indexOfCurrentSquare = squares.indexOf(currentSquare);
			targetSquare = (indexOfSquare-indexOfOldSquare>0)?squares.get(indexOfCurrentSquare+1):squares.get(indexOfCurrentSquare-1);
			
			double currentPosX = squares.get(indexOfCurrentSquare).getPlayersPosition().get(indexPlayer).getX();
			double currentPosY = squares.get(indexOfCurrentSquare).getPlayersPosition().get(indexPlayer).getY();
			
			int indexOfNextSquare = squares.indexOf(targetSquare);
			double nextPosX = squares.get(indexOfNextSquare).getPlayersPosition().get(indexPlayer).getX();
			double nextPosY = squares.get(indexOfNextSquare).getPlayersPosition().get(indexPlayer).getY();
			
			distX = nextPosX - currentPosX;
			distY = nextPosY - currentPosY;
			
			TranslateTransition translate = new TranslateTransition();
			
			translate.setByX(distX);
			translate.setByY(distY);
			
			translate.setDuration(Duration.millis(Constants.ANIMATION_MOVEMENT));

			translate.setNode(SceneManager.getGame().getListImageView().get(indexPlayer));
			
			a[i+1]=translate;
			currentSquare=targetSquare;
		}
		return a;
	}

	/**
	 * Returns a Player with the fields having the exact same value as this Player.
	 * @return a Player Cloned
	 * */
	public Player clone() {
		return new Player(name, PlayerColors.getValue(color), square);
	}
}
