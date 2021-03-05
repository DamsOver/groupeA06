package model;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import serialisation.Serialisation;

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
	
	public String toJson() {
		return new Gson().toJson(this);
	}
	
	public Board fromJson(String nom) {
		return Serialisation.loadBoardClear(nom);
	}
	
	public String toString() {
		return "Deck [deck=" + squares + "]";
	}
}
