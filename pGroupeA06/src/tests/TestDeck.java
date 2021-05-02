package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import enumerations.Theme;
import exceptions.AlreadyPresentException;
import exceptions.NotPresentException;
import exceptions.NullException;
import exceptions.TooLittleException;
import model.BasicCard;
import model.Deck;

class TestDeck {

	private Deck deck,copyDeck;
	private BasicCard bc, bc2;
	private List<BasicCard> basicCards,basicCards2;

	@SuppressWarnings("unchecked")
	@BeforeEach
	void setUp() throws Exception {
		deck = new Deck();
		copyDeck = new Deck();
		bc = new BasicCard("Martin", Theme.IMPROBABLE, "Nature");
		bc2 = new BasicCard("Damien", Theme.INFORMATICS, "oop");

		Field field = deck.getClass().getDeclaredField("cards");
		field.setAccessible(true);

		basicCards = (List<BasicCard>) field.get(deck);
		bc.addQuestion("What is the only flying mammal?", "The bat");
			
	}

	@AfterEach
	void tearDown() throws Exception {
		deck = null;
		bc = null;
		bc2 = null;
		basicCards = null;
	}

	@Test
	void testAddBasicCard() throws AlreadyPresentException, NullException{

		// add a card to the deck
		assertEquals(basicCards.size(), 0,"Does not contain any card");
		assertTrue(deck.addBasicCard(bc),"Card added");
		assertEquals(basicCards.size(), 1,"Contain 1 card");
		assertTrue(basicCards.contains(bc));
	}

	@Test
	void testAddBasicCardNullException() throws AlreadyPresentException, NullException{

		// add a null card to the deck
		assertThrows(NullException.class,()->deck.addBasicCard(null));
	}
	
	@Test
	void testAddBasicCardAlreadyPresentException() throws AlreadyPresentException, NullException{

		basicCards.add(bc);
		
		// add a copy of the card to the deck
		assertTrue(basicCards.contains(bc));
		assertEquals(basicCards.size(), 1);
		assertThrows(AlreadyPresentException.class,()->deck.addBasicCard(bc));
		assertEquals(basicCards.size(), 1);
	}
	
	
	@Test
	void testRemoveBasicCard() throws TooLittleException, NotPresentException{

		// add a card to the deck
		basicCards.add(bc);
		assertTrue(basicCards.contains(bc));

		// remove a question
		assertTrue(deck.removeBasicCard(bc));
		assertTrue(!basicCards.contains(bc));
	}

	@Test
	void testRemoveBasicCardTooLittleException() throws TooLittleException, NotPresentException{
		// remove a card from an empty deck
		assertEquals(basicCards.size(),0);
		assertThrows(TooLittleException.class,()->deck.removeBasicCard(bc));
	}
	
	@Test
	void testRemoveBasicCardNotPresentException() throws TooLittleException, NotPresentException{

		// add a card to the deck
		basicCards.add(bc);
		assertTrue(basicCards.contains(bc));

		// remove a non-existing card
		assertThrows(NotPresentException.class,()->deck.removeBasicCard(bc2));
		assertEquals(basicCards.size(), 1);
	}
	
	@Test
	void testGetBasicCards(){

		// add 2 cards to the deck
		basicCards.add(bc);
		basicCards.add(bc2);

		List<BasicCard> copyDeck = deck.getBasicCards();

		// Check if the method getBasicCards of deck contains 2 cards
		assertEquals(2, copyDeck.size());

		// Check if the method getBasicCards of deck return the same Object that
		// basicCards
		assertEquals(basicCards, copyDeck);

		// Check if the size of basicCards and copyDeck are the same
		assertEquals(basicCards.size(), copyDeck.size());

		// Check if the deletion of an element does not affect basicCards and copyDeck
		basicCards.remove(bc);
		assertFalse(basicCards.size() == copyDeck.size());
	}

	@Test
	void testToJson() {
		// add the card to the deck
		basicCards.add(bc);
		assertEquals(deck.toJson(),
				"{\"cards\":[{\"subject\":\"Nature\",\"questions\":[{\"author\":\"Martin\",\"theme\":\"IMPROBABLE\",\"subject\":\"Nature\",\"challenge\":\"What is the only flying mammal?\",\"answer\":\"The bat\"}],\"author\":\"Martin\",\"theme\":\"IMPROBABLE\"}]}");
	}

	@Test
	void testFromJson(){
		basicCards.add(new BasicCard("Martin", Theme.IMPROBABLE, "Earth"));
		assertEquals(deck,deck.fromJson("deckTest.JSON"));
	}

	@Test
	void testToString(){
		// add the card to the deck
		basicCards.add(bc);
		assertEquals(deck.toString(),
				"Deck [cards=[\nBasicCard [author=Martin, theme=IMPROBABLE, subject=Nature, questions=[\nQuestion [author=Martin, theme=IMPROBABLE, subject=Nature, challenge=What is the only flying mammal?, answer=The bat]]]\n]]");
	}

	@Test
	void testEqualsObject(){
		// Add the card to the deck
		basicCards.add(bc);

		assertTrue(deck.equals(deck));
		assertFalse(deck.equals(null));
		assertFalse(deck.equals(basicCards));

		Deck deck2 = new Deck();
		assertFalse(deck.equals(deck2));
	}

	@SuppressWarnings("unchecked")
	@Test
	void testClone() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
		
		basicCards.add(bc);
		
		copyDeck = deck.clone();
		assertEquals(deck, copyDeck);
			
		Field field2 = copyDeck.getClass().getDeclaredField("cards");
		field2.setAccessible(true);
		basicCards2 = (List<BasicCard>) field2.get(copyDeck);
		
		
		basicCards2.remove(bc);
		assertTrue(!deck.equals(copyDeck));
		
		basicCards.add(bc);
		basicCards.add(bc);
		
		copyDeck=deck.clone();
	}
}
