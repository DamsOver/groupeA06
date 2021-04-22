package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import enumerations.Theme;
import model.BasicCard;
import model.Deck;
import java.lang.reflect.Field;

class TestSerialisation {
	
	private Deck deck;
	private BasicCard bc;
	private List<BasicCard> basicCards;

	@BeforeEach
	void setUp() throws Exception {
		deck = new Deck();
		bc = new BasicCard("Martin", Theme.IMPROBABLE, "Nature");

		Field field = deck.getClass().getDeclaredField("cards");
		field.setAccessible(true);

		basicCards = (List<BasicCard>) field.get(deck);
		bc.addQuestion("What is the only flying mammal?", "The bat");
	}

	@AfterEach
	void tearDown() throws Exception {
		deck = null;
		bc = null;
		basicCards = null;
	}

	@Test
	void testSaveDeckClear() {
//		fail("Not yet implemented");
		// add a card to the deck
//		assertTrue(deck.addBasicCard(bc), "Carte ajouté au deck");
//		assertThrows(AlreadyPresentException.class, () -> deck.addBasicCard(bc), "Doublon");
//		assertEquals(basicCards.size(), 1);

//				assertThrows(Exception.class,()->Serialisation.saveDeckClear(null,"groupeA06.JSON"));
//				try {
//					Serialisation.saveDeckClear(deck,"deckTest.JSON");
//				} catch (IOException e1) {
//					System.out.println("IO Exception");
//				}
//				try {
//					assertEquals(Serialisation.loadDeckClear("deckTest.JSON"),deck);
//				} catch (FileNotFoundException e) {
//					System.out.println("File not Found");
//				}
//				assertThrows(Exception.class,()->Serialisation.loadDeckClear("d.JSON"));
	}

	@Test
	void testLoadDeckClear() {
//		fail("Not yet implemented");
	}

	@Test
	void testLoadBoardClear() {
//		fail("Not yet implemented");
	}

}
