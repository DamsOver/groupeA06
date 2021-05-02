package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exceptions.AlreadyPresentException;
import model.Board;
import model.Deck;
import model.Game;
import util.Constants;

class TestGame {
	private Game game;
	private Board board;
	private Deck d;

	@BeforeEach
	void setUp() throws Exception {
		game = new Game();
		
		Field field2 = game.getClass().getDeclaredField("board");
		field2.setAccessible(true);
		board = (Board) field2.get(game);
		
		Field field3 = game.getClass().getDeclaredField("deck");
		field3.setAccessible(true);
		d = (Deck) field3.get(game);
		
	}

	@AfterEach
	void tearDown() throws Exception {
		game = null;
	}

	@Test
	void testGetPlayers() throws AlreadyPresentException{
		//Impossible because calls a method of player that uses the vue
		//Player p1 = new Player("Player1",1,new Square(Theme.INFORMATICS));
		//Player p2 = new Player("Player2",2,new Square(Theme.PLEASURE));
		//game.addPlayer("Player1",1);
		//game.addPlayer("Player2",2);
	}

	@Test
	void testaddPlayer() throws AlreadyPresentException {
		//impossible because calls a method of player that uses the vue
		/*
		Player p = new Player("J",1);
		assertTrue(!players.contains(p));
		assertTrue(game.addPlayer("J",1));
		assertTrue(players.contains(p));
		*/
	}
	
	@Test
	void testTurnUp() {
		game.turnUp();
		assertEquals(game.getTurn(), 1);
	}


	@Test
	void testGetTurn() {
		game.turnUp();
		assertEquals(game.getTurn(), 1);
	}

	@Test 
	void testGetBoard(){
		board = board.fromJson(Constants.BOARD_PATH);
		assertEquals(board,game.getBoard());
	}
	
	@Test
	void testGetDeck() {
		d=d.fromJson(Constants.DECK_PATH);
		Deck deck = d.fromJson(Constants.DECK_PATH);
		assertEquals(game.getDeck(),deck);
	}
	
	@Test
	void testGetBasicCard() {

		
		
		
		
		
	}
	
	
	@Test 
	void testDrawCard() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
		d=d.fromJson("deckTest.JSON");
		
		Field field4 = d.getClass().getDeclaredField("cards");
		field4.setAccessible(true);
		//@SuppressWarnings("unchecked")
		//ArrayList<BasicCard> bcs = (ArrayList<BasicCard>) field4.get(d);
	}
	
	
}
