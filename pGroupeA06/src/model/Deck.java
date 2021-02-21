package model;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import exceptions.AlreadyPresentException;
import exceptions.NotPresentException;
import exceptions.TooLittleException;

public class Deck {
	
	private List<BasicCard> deck;
	
	public Deck() {
		this.deck= new ArrayList<BasicCard>();
	}
	
	public boolean addBasicCard(BasicCard newBasicCard)throws AlreadyPresentException {
		if(newBasicCard==null)
			return false;
		
		//scanning the list of cards to check if the BasicCard already exists
		for(BasicCard bc : deck) {
			if(bc.equals(newBasicCard)) {
				throw new AlreadyPresentException(1);
			}
		}
		
		//if everything is ok, adding the card
		//clone because the card can only be accessed in one deck
		deck.add(newBasicCard.clone());
		return true;
	}
	
	
	//to remove a Basiccard
	public boolean removeBasicCard(BasicCard basicCard)throws TooLittleException,NotPresentException {

		//verification if the number of cards is not 0
		if(0==deck.size()) {
			throw new TooLittleException(1);
		}
		
		//scanning the list of card to check if it exists
		boolean x = false;
		for(BasicCard bc : deck) {
			if(bc.equals(basicCard)) {
				x=true;
			}
		}
		
		//if the card does not exist
		if(x==false) {
			throw new NotPresentException(1);
		}
		
		//removing the question
		deck.remove(basicCard);
		return true;
	}
	
	
	public String toJson() {
		return new Gson().toJson(this);
	}
	
	public Deck fromJson(String json) {
		return new Gson().fromJson(json,Deck.class);
	}


	public String toString() {
		return "Deck [deck=" + deck + "]";
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
		if (!deck.equals(other.deck))
			return false;
		return true;
	}	
	

	
	
}
