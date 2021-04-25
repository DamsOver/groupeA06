package model;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import serialisation.Serialisation;
import util.Constants;

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
	 * Adds a square to the Board
	 * @param sq	Square to add to the board
	 * @return true if the square is successfully added*/
	public boolean addSquare(Square sq) {
		if(sq==null) {
			return false;
		}
		
		//no verification needed, 
		//the Square Objects are not Unique 
		//and can be modified inside and outside the class
		squares.add(sq);
		return true;
	}
	
	/**
	 * Returns the list of Square
	 * @return List of Square*/
	public List<Square> getSquares(){
		return this.squares;
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
	 * @return A new Board described by the String
	 * */
	public Board fromJson() {		
		return Serialisation.loadBoardClear(Constants.BOARD_PATH);
	}
	
	/**
	 * Convert the Board object and his fields into a String
	 * @return The String describing the object
	 * */
	public String toString() {
		return "Board [Board=" + squares + "]";
	}
}
