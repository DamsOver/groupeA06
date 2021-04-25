package model;

import java.util.ArrayList;
import java.util.List;

import enumerations.Theme;


/**
 * An representation of a square, a small part of a Board
 * @author Damien
 * */
public class Square {
	
	/**
	 * The Theme of the Square
	 */
	private Theme theme;
	
	/**
	 * The List of Position of the Players
	 */
	private List<Position> playersPosition;

	/**
	 * Constructor
	 * @param theme	The theme of the Square
	 * */
	public Square(Theme theme) {
		this.theme = theme;
		this.playersPosition = new ArrayList<>();
	}

	/**
	 * returns the Theme
	 * @return the Theme of the Square
	 * */
	public Theme getTheme() {
		return theme;
	}
	
	/**
	 * returns the list of Position of the players
	 * @return a list of Position*/
	public List<Position> getPlayersPosition() {
		List<Position> p = new ArrayList<Position>();
		for(Position position : playersPosition) {
			p.add(position);
		}
		return p;
	}

	/**
	 * Converts the Square Object and his fields into a String
	 * @return The String describing the Object
	 * */
	public String toString() {
		return theme.toString() + ", [" + playersPosition + "]";
	}
	
	/**
	 * Returns a Square with the fields having the exact same value as this Square.
	 * @return a Square Cloned
	 * */
	public Square clone() {
		Square sq =new Square(this.theme);
		sq.playersPosition=this.getPlayersPosition();
		return sq;
	}
	
	/**
	 * Checks if two objects are equals.
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
		Square other = (Square) obj;
		if (playersPosition == null) {
			if (other.playersPosition != null)
				return false;
		} else if (!playersPosition.equals(other.playersPosition))
			return false;
		if (theme != other.theme)
			return false;
		return true;
	}
}