package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import application.SceneManager;
import enumerations.PlayerColors;
import enumerations.Theme;
import javafx.animation.Animation;
import model.Player;
import model.Position;
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
	void testGetColor() {
		assertEquals(player.getColor(),PlayerColors.GREEN);
	}
	
	@Test
	void testGetOldSquare() {
		
		assertEquals(player.getOldSquare(), oldSq);
	}
	
	@Test
	void testEqualsObject() {
		
		assertTrue(player.equals(player));
		assertFalse(player.equals(null));
		assertFalse(player.equals("  "));
		assertFalse(player.equals(new Player("Dams",2,new Square(Theme.INFORMATICS))));
		assertFalse(player.equals(new Player(null,1,new Square(Theme.INFORMATICS))));
		Player p = new Player(null, 1, new Square(Theme.INFORMATICS));
		Player p2 = new Player("Dams", 1, new Square(Theme.INFORMATICS));
		assertFalse(p.equals(p2));
		Player p3 = new Player("Dams", 1, null);
		Player p4 = new Player("Dams", 1, new Square(Theme.INFORMATICS));
		assertFalse(p3.equals(p4));
		Player p1 = new Player("Dams", 1, new Square(Theme.INFORMATICS));
		assertEquals(player, p1);

	}
	
	@Test
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
		Square sq2 = new Square(Theme.IMPROBABLE);
		assertFalse(sq.equals(sq2));
		
		player.setOldSquare(sq2);
		assertTrue(player.getOldSquare().equals(sq2));
	}

	@Test
	void testClone() {
		Player p1 = player.clone();
		assertEquals(player, p1);
		p1.setSquare(new Square(Theme.IMPROBABLE));
		assertFalse(player.equals(p1));
	}
	
	@Test
	void testSetSquare3() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		//impossible to test because of the need of JFX
	}
	
}
