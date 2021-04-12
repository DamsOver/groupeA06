package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import enumerations.Theme;
import exceptions.AlreadyPresentException;
import model.BasicCard;
import model.Deck;
import serialisation.Serialisation;
import test.Explorateur;

class TestSerialisation {

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
	void testWriteReadClear() throws AlreadyPresentException{
		
		//add a card to the deck
		assertTrue(deck.addBasicCard(bc));
		assertEquals(basicCards.size(),1);
		
		assertThrows(Exception.class,()->Serialisation.saveDeckClear(null,"deckTest.JSON"));
//		try {
//			Serialisation.saveDeckClear(deck,"deckTest.JSON");
//		} catch (IOException e1) {
//			System.out.println("IO Exception");
//		}
//		try {
//			assertEquals(Serialisation.loadDeckClear("deckTest.JSON"),deck);
//		} catch (FileNotFoundException e) {
//			System.out.println("File not Found");
//		}
		assertThrows(Exception.class,()->Serialisation.loadDeckClear("d.JSON"));
	}

}

