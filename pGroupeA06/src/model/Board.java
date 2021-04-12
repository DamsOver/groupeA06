package model;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import serialisation.Serialisation;
import util.Constants;

public class Board {
	private List<Square> squares;
	
	public Board() {
		squares = new ArrayList<Square>();
	}
	
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
	
	public List<Square> getSquares(){
		return this.squares;
	}
	
	public String toJson() {
		return new Gson().toJson(this);
	}
	
	public Board fromJson() {
		
		return Serialisation.loadBoardClear(Constants.BOARD_PATH);
	}
	
	public String toString() {
		return "Board [Board=" + squares + "]";
	}
}
