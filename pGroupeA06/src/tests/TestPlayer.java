package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import enumerations.Theme;
import model.Player;
import model.Square;

class TestPlayer {
	
	private Player player;

	@BeforeEach
	void setUp() throws Exception {
		player = new Player("Dams", 1, new Square(Theme.INFORMATICS));
	}

	@AfterEach
	void tearDown() throws Exception {
		player = null;
	}

	@Test
	void testToString() {
		assertEquals(player.toString(),"Player [name=Dams, color=GREEN, square=INFORMATICS, [[]], oldSquare=null]");
	}

	@Test
	void testEqualsObject() {
		Player p1 = new Player("Dams", 1, new Square(Theme.INFORMATICS));
		assertEquals(player, p1);
		Player p2 = new Player("Test", 1, new Square(Theme.INFORMATICS));
		assertFalse(player.equals(p2));
	}

	@Test
	void testSetSquareSquareGamePlayerIntSquare() {
//		fail("Not yet implemented");
	}

	@Test
	void testSwitchSquares() {
//		fail("Not yet implemented");
	}

	@Test
	void testClone() {
		Player p1 = player.clone();
		assertEquals(player, p1);
		p1.setSquare(new Square(Theme.IMPROBABLE));
		assertFalse(player.equals(p1));
	}

}
