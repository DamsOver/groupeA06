package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import enumerations.Theme;
import model.Player;
import model.Square;

class TestPlayer {
	
	private Player player;
	private Square sq,oldSq;

	@BeforeEach
	void setUp() throws Exception {
		player = new Player("Dams", 1, new Square(Theme.INFORMATICS));
		
		Field field = player.getClass().getDeclaredField("square");
		field.setAccessible(true);
		sq = (Square) field.get(player);
		
		Field field2 = player.getClass().getDeclaredField("oldSquare");
		field2.setAccessible(true);
		oldSq = (Square) field2.get(player);
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
	void testGetName() {
		assertEquals(player.getName(),"Dams");
	}
	
	@Test
	void testEqualsObject() {
		Player p1 = new Player("Dams", 1, new Square(Theme.INFORMATICS));
		assertEquals(player, p1);
		Player p2 = new Player("Test", 1, new Square(Theme.INFORMATICS));
		assertFalse(player.equals(p2));
	}

	void testGetSquare() {
		assertEquals(player.getSquare(), sq);
	}
	
	@Test
	void testSetSquare() {
		Square sq2 = new Square(Theme.IMPROBABLE);
		assertFalse(sq.equals(sq2));
		
		player.setSquare(sq2);
		assertTrue(player.getSquare().equals(sq2));
	}
	
	@Test
	void testSetSquare2() {
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
