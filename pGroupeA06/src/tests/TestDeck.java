package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import enumerations.Theme;
import model.BasicCard;
import model.Deck;

class TestDeck {

	private Deck deck;
	private BasicCard bc, bc2;
	private List<BasicCard> basicCards;

	@SuppressWarnings("unchecked")
	@BeforeEach
	void setUp() throws Exception {
		deck = new Deck();
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
	void testAddBasicCard(){

		// add a card to the deck
		assertTrue(deck.addBasicCard(bc));
		assertEquals(basicCards.size(), 1);

		// add a null card to the deck
		assertFalse(deck.addBasicCard(null));
		assertEquals(basicCards.size(), 1);

		// add a copy of the card to the deck
		assertFalse(deck.addBasicCard(bc));
		assertEquals(basicCards.size(), 1);
	}

	@Test
	void testRemoveBasicCard(){
		// remove a card from an empty deck
		assertFalse(deck.removeBasicCard(bc));

		// add a card to the deck
		assertTrue(deck.addBasicCard(bc));
		assertEquals(basicCards.size(), 1);

		// remove a non-existing card
		assertFalse(deck.removeBasicCard(null));
		assertEquals(basicCards.size(), 1);

		// remove a question
		assertTrue(deck.removeBasicCard(bc));
		assertEquals(basicCards.size(), 0);
	}

	@Test
	void testGetBasicCards(){

		// add 2 cards to the deck
		deck.addBasicCard(bc);
		deck.addBasicCard(bc2);

		List<BasicCard> copyDeck = deck.getBasicCards();

		// Check if the method getBasicCards of deck contains 2 cards
		assertEquals(2, copyDeck.size());

		// Check if the method getBasicCards of deck return the same Object that
		// basicCards
		assertEquals(basicCards, copyDeck);

		// Check if the size of basicCards and copyDeck are the same
		assertEquals(basicCards.size(), copyDeck.size());

		// Check if the deletion of an element does not affect basicCards and copyDeck
		deck.removeBasicCard(bc2);
		assertFalse(basicCards.size() == copyDeck.size());
	}

	@Test
	void testToJson() {
		// add the card to the deck
		deck.addBasicCard(bc);
		assertEquals(deck.toJson(),
				"{\"cards\":[{\"subject\":\"Nature\",\"questions\":[{\"author\":\"Martin\",\"theme\":\"IMPROBABLE\",\"subject\":\"Nature\",\"challenge\":\"What is the only flying mammal?\",\"answer\":\"The bat\"}],\"author\":\"Martin\",\"theme\":\"IMPROBABLE\"}]}");
	}

	@Test
	void testFromJson(){
		deck.addBasicCard(new BasicCard("Martin", Theme.IMPROBABLE, "Earth"));
		assertEquals(deck,deck.fromJson("deckTest.JSON"));
	}

	@Test
	void testToString(){
		// add the card to the deck
		deck.addBasicCard(bc);
		assertEquals(deck.toString(),
				"Deck [cards=[\nBasicCard [author=Martin, theme=IMPROBABLE, subject=Nature, questions=[\nQuestion [author=Martin, theme=IMPROBABLE, subject=Nature, challenge=What is the only flying mammal?, answer=The bat]]]\n]]");
	}

	@Test
	void testEqualsObject(){
		// Add the card to the deck
		deck.addBasicCard(bc);

		assertTrue(deck.equals(deck));
		assertFalse(deck.equals(null));
		assertFalse(deck.equals(basicCards));

		Deck deck2 = new Deck();
		assertFalse(deck.equals(deck2));
	}

	@Test
	void testClone(){
		deck.addBasicCard(bc);
		Deck copyDeck = deck.clone();
		assertEquals(deck, copyDeck);
		copyDeck.removeBasicCard(bc);
		assertTrue(!deck.equals(copyDeck));
		
		copyDeck=deck.clone();
		basicCards.add(bc);
		Deck test=deck.clone();
		assertEquals(test,copyDeck);
	}
}
