package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import enumerations.Theme;
import exceptions.AlreadyPresentException;
import model.Game;
import model.Player;
import model.Square;

class TestGame {
	private Game game;
	private List<Player> players;

	@BeforeEach
	void setUp() throws Exception {
		game = new Game();
		Field field = game.getClass().getDeclaredField("players");
		field.setAccessible(true);
		players = (List<Player>) field.get(game);
	}

	@AfterEach
	void tearDown() throws Exception {
		game = null;
		players = null;
	}

	@Test
	void testMovePlayer() {
//		fail("Not yet implemented");
	}

	@Test
	void testGetBoard() {
//		fail("Not yet implemented");
	}

	@Test
	void testTurnUp() {
		game.turnUp();
		assertEquals(game.getTurn(), 1);
	}

	@Test
	void testGetDeck() {
//		fail("Not yet implemented");
	}

	@Test
	void testGetTurn() {
		game.turnUp();
		assertEquals(game.getTurn(), 1);
	}

	@Test
	void testClone() {
//		fail("Not yet implemented");
	}

	@Test
	void testGetPlayers() throws AlreadyPresentException {
		Player p1 = new Player("Player1",1,new Square(Theme.INFORMATICS));
		Player p2 = new Player("Player2",2,new Square(Theme.PLEASURE));
		game.addPlayer("Player1",1);
		game.addPlayer("Player2",2);
		assertEquals(game.getPlayers().size(), 2);
	}

	@Test
	void testSetPlayerVisible() {
//		fail("Not yet implemented");
	}

}
