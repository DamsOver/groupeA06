package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import enumerations.Theme;
import exceptions.AlreadyPresentException;
import exceptions.NotPresentException;
import exceptions.TooLittleException;
import model.BasicCard;
import model.Deck;
import test.Explorateur;

class TestDeck {

	private Deck deck;
	private BasicCard bc;
	private List<BasicCard> basicCards;
	
	@SuppressWarnings("unchecked")
	
	@BeforeEach
	void setUp() throws Exception {
		deck = new Deck();
		bc = new BasicCard("Martin",Theme.IMPROBABLE,"Nature");
		basicCards = ((List<BasicCard>) Explorateur.getField(deck, "deck"));
		bc.addQuestion("What is the only flying mammal?", "The bat");
	}
	
	@AfterEach
	void tearDown() throws Exception {
		deck = null;
		bc = null;
		basicCards=null;
	}
	
	
	@Test
	void testAddBasicCard() throws AlreadyPresentException {
		
		//add a card to the deck
		assertTrue(deck.addBasicCard(bc));
		assertEquals(basicCards.size(),1);
		
		//add a null card to the deck
		assertFalse(deck.addBasicCard(null));
		assertEquals(basicCards.size(),1);
		
		//add a copy of the card to the deck
		assertThrows(AlreadyPresentException.class,()->deck.addBasicCard(bc));
		assertEquals(basicCards.size(),1);
		
	}
	
	@Test
	void testRemoveBasicCard() throws TooLittleException,NotPresentException, AlreadyPresentException {
		
		//remove a card from an empty deck
		assertThrows(TooLittleException.class,()->deck.removeBasicCard(bc));
		
		//add a card to the deck
		assertTrue(deck.addBasicCard(bc));
		assertEquals(basicCards.size(),1);	
		
		//remove a non-existing card
		assertThrows(NotPresentException.class,()->deck.removeBasicCard(null));
		assertEquals(basicCards.size(),1);
		
		//remove a question
		assertTrue(deck.removeBasicCard(bc));
		assertEquals(basicCards.size(),0);
	}
	
	
	

	@Test
	void testJson() throws AlreadyPresentException {
		//add the card to the deck
		deck.addBasicCard(bc);
		
		assertEquals(deck.toJson(),"{\"deck\":[{\"author\":\"Martin\",\"theme\":\"IMPROBABLE\",\"subject\":\"Nature\",\"questions\":[{\"author\":\"Martin\",\"theme\":\"IMPROBABLE\",\"subject\":\"Nature\",\"challenge\":\"What is the only flying mammal?\",\"answer\":\"The bat\"}]}]}");
		assertEquals(deck.fromJson(),deck);
	}
	
	@Test
	void testEquals() throws AlreadyPresentException {
		
		//Add the card to the deck
		deck.addBasicCard(bc);
		
		assertTrue(deck.equals(deck));
		assertFalse(deck.equals(null));
		assertFalse(deck.equals(basicCards));
		
		Deck deck2 = new Deck();
		assertFalse(deck.equals(deck2));
	}
	
	@Test
	void testToString() throws AlreadyPresentException {
		//add the card to the deck
		deck.addBasicCard(bc);
		assertEquals(deck.toString(),"Deck [deck=[BasicCard [author=Martin, theme=IMPROBABLE, subject=Nature, questions=[Question [author=Martin, theme=IMPROBABLE, subject=Nature, challenge=What is the only flying mammal?, answer=The bat]\n]]\n]]");
	}
	
	
}
