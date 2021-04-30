package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import enumerations.Theme;
import model.Position;
import model.Square;

class TestSquare {
	
	private Square sq;
	private List<Position> playersPosition;

	@SuppressWarnings("unchecked")
	@BeforeEach
	void setUp() throws Exception {
		sq = new Square(Theme.INFORMATICS);
		Field field = sq.getClass().getDeclaredField("playersPosition");
		field.setAccessible(true);
		playersPosition = (List<Position>) field.get(sq);
	}

	@AfterEach
	void tearDown() throws Exception {
		sq = null;
		playersPosition = null;
	}

	@Test
	void testGetPlayersPosition() {
		playersPosition.add(new Position(1,1));
		playersPosition.add(new Position(2,2));
		
		assertEquals(sq.getPlayersPosition(),playersPosition);
	}

	@Test
	void testToString() {
		playersPosition = Arrays.asList(new Position(2.5,3.5),new Position(4.5,5.5));
		assertEquals(sq.toString(),"INFORMATICS, [[]]");
	}

	@Test
	void testEqualsObject() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		assertTrue(sq.equals(sq));
		assertFalse(sq.equals(null));
		assertFalse(sq.equals("ok"));
		
		
		Square sq2 = new Square(Theme.INFORMATICS);
		Field field2 = sq2.getClass().getDeclaredField("playersPosition");
		field2.setAccessible(true);
		List<Position> playersPosition2 = (List<Position>) field2.get(sq2);
		
		assertTrue(sq.equals(sq2));
		playersPosition2.add(new Position(1,1));
		assertFalse(sq.equals(sq2));
		
		Square sq3 = new Square(Theme.IMPROBABLE);
		assertFalse(sq.equals(sq3));
	}
	
	@Test
	void testClone(){
		playersPosition.add(new Position(1,1));
		playersPosition.add(new Position(2,2));
		
		assertEquals(sq.clone(),sq);
	}
	
	@Test
	void testGetTheme() {
		assertEquals(sq.getTheme(),Theme.INFORMATICS);
	}

}
