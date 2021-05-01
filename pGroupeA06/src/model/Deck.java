package model;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;

import exceptions.AlreadyPresentException;
import exceptions.NotPresentException;
import exceptions.NullException;
import exceptions.TooLittleException;
import serialisation.Serialisation;

/**
 * An object representing a Deck, containing different BasicCard object
 * @author Martin
 * */

public class Deck {
	
	/**
	 * The List of BasicCard
	 */
	private List<BasicCard> cards;
	
	/**
	 * Constructor of a Deck
	 * */
	public Deck() {
		this.cards= new ArrayList<BasicCard>();
	}
	
	
	/**
	 * Adds a BasicCard to the Deck
	 * @param newBasicCard	BasicCard to add to the board
	 * @throws AlreadyPresentException error if the basic card is already present
	 * @throws NullException error if the basic card is null
	 * @return true if the BasicCard is successfully added*/
	public boolean addBasicCard(BasicCard newBasicCard) throws AlreadyPresentException, NullException {
		if(newBasicCard==null)
			throw new NullException();
		
		//scanning the list of cards to check if the BasicCard already exists
		for(BasicCard bc : cards) {
			if(bc.equals(newBasicCard)) {
				throw new AlreadyPresentException();
			}
		}
		
		//if everything is ok, adding the card
		//clone because the card can only be accessed in one deck
		cards.add(newBasicCard.clone());
		return true;
	}
	
	
	/**
	 * removes a BasicCard from the Deck
	 * @param basicCard	The BasicCard to remove
	 * @throws NotPresentException error if the BasicCard is not present
	 * @throws TooLittleException error if there is no BasicCard
	 * @return true if the BasicCard has been successfully removed from the Deck
	 * */
	public boolean removeBasicCard(BasicCard basicCard) throws TooLittleException, NotPresentException{

		//verification if the number of cards is not 0
		if(0==cards.size()) {
			throw new TooLittleException();
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
			throw new NotPresentException();
		}
		
		//removing the question
		cards.remove(basicCard);
		return true;
	}
	
	
	/**
	 * returns the list of BasicCard cloned
	 * @return the list of BasicCard of the Deck
	 * */
	public List<BasicCard> getBasicCards(){
		//no need to verify Duplicates because the list has none
		ArrayList<BasicCard> newCards = new ArrayList<BasicCard>();
		for(BasicCard bc : cards) {
			newCards.add(bc.clone());
		}
		
		return newCards;
	}
	
	/**
	 * Transforms a Deck Object into a String
	 * @return A Json String describing the Deck
	 * */
	public String toJson() {
		return new Gson().toJson(this);
	}
	
	
	/**
	 * Transforms a String (Json) into a Deck Object
	 * @param deckPath The name of the JSON file
	 * @return A new Deck described by the String
	 * */
	public Deck fromJson(String deckPath) {
		return Serialisation.loadDeckClear(deckPath);
	}

	/**
	 * Convert the Deck and his fields into a String
	 * @return The String describing the object
	 * */
	public String toString() {
		return "Deck [cards=" + cards + "]";
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
		Deck other = (Deck) obj;
		if (!cards.equals(other.cards))
			return false;
		return true;
	}	
	
	/**
	 * Returns a Deck with the fields having the exact same value as this Deck.
	 * @return a Deck Cloned
	 * */
	public Deck clone(){
		Deck newDeck = new Deck();
		for(BasicCard bc : cards) {
			try {
				newDeck.addBasicCard(bc.clone());
			} catch (AlreadyPresentException | NullException e) {
			}
		}
		return newDeck;
	}
}
