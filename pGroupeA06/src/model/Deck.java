package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import exceptions.AlreadyPresentException;
import exceptions.NotPresentException;
import exceptions.TooLittleException;
import serialisation.Serialisation;
import util.Constants;

public class Deck {
	
	private List<BasicCard> cards;
	
	public Deck() {
		this.cards= new ArrayList<BasicCard>();
	}
	
	public boolean addBasicCard(BasicCard newBasicCard)throws AlreadyPresentException {
		if(newBasicCard==null)
			return false;
		
		//scanning the list of cards to check if the BasicCard already exists
		for(BasicCard bc : cards) {
			if(bc.equals(newBasicCard)) {
				System.out.println(bc.getSubject());
				throw new AlreadyPresentException(1);
			}
		}
		
		//if everything is ok, adding the card
		//clone because the card can only be accessed in one deck
		cards.add(newBasicCard.clone());
		return true;
	}
	
	
	//to remove a Basiccard
	public boolean removeBasicCard(BasicCard basicCard)throws TooLittleException,NotPresentException {

		//verification if the number of cards is not 0
		if(0==cards.size()) {
			throw new TooLittleException(1);
		}
		
		//scanning the list of card to check if it exists
		boolean x = false;
		for(BasicCard bc : cards) {
			if(bc.equals(basicCard)) {
				x=true;
			}
		}
		
		//if the card does not exist
		if(x==false) {
			throw new NotPresentException(1);
		}
		
		//removing the question
		cards.remove(basicCard);
		return true;
	}
	
	public List<BasicCard> getBasicCards(){
		ArrayList<BasicCard> newCards = new ArrayList<BasicCard>();
		for(BasicCard bc : cards) {
			newCards.add(bc.clone());
		}
		
		return newCards;
	}
	
	
	public String toJson() {
		return new Gson().toJson(this);
	}
	
	public Deck fromJson() {
		return Serialisation.loadDeckClear(Constants.DECK_PATH);
	}


	public String toString() {
		return "Deck [cards=" + cards + "]";
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Deck other = (Deck) obj;
		if (!cards.equals(other.cards))
			return false;
		return true;
	}	
	
	public Deck clone() {
		Deck newDeck = new Deck();
		for(BasicCard bc : cards) {
			try {
				newDeck.addBasicCard(bc.clone());
			} catch (AlreadyPresentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return newDeck;
	}
}
