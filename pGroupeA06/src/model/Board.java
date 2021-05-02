package model;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import serialisation.Serialisation;

/**
 * A representation of the board of the game
 * @author Martin
 * */

public class Board {
	
	/**The list of squares that the board contains*/
	private List<Square> squares;
	
	
	/**
	 * Constructor of a Board*/
	public Board() {
		squares = new ArrayList<Square>();
	}
	
	
	/**
	 * Returns the list of Square
	 * @return List of Square*/
	public List<Square> getSquares(){
		List<Square> listSquare = new ArrayList<Square>();
		for(Square sq : squares) {
			listSquare.add(sq.clone());
		}
		return listSquare;
	}
	
	/**
	 * Transforms a Board Object into a String
	 * @return A Json String describing the Board
	 * */
	public String toJson() {
		return new Gson().toJson(this);
	}
	

	/**
	 * Transforms a String (Json) into a Board Object
	 * @param path Le chemin du deck
	 * @return A new Board described by the String
	 * */
	public Board fromJson(String path) {		
		return Serialisation.loadBoardClear(path);
	}
	
	/**
	 * Convert the Board object and his fields into a String
	 * @return The String describing the object
	 * */
	public String toString() {
		return "Board [Board=" + squares + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Board other = (Board) obj;
		if (squares == null) {
			if (other.squares != null)
				return false;
		} else if (!squares.equals(other.squares))
			return false;
		return true;
	}
	
	public Board clone() {
		Board b = new Board();
		List<Square> s = new ArrayList<Square>();
		for(Square sq : squares) {
			s.add(sq);
		}
		b.squares=s;
		return b;
	}
}
