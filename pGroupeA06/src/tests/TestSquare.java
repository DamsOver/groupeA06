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
//		fail("Not yet implemented");
	}

	@Test
	void testToString() {
		playersPosition = Arrays.asList(new Position(2.5,3.5),new Position(4.5,5.5));
		assertEquals(sq.toString(),"INFORMATICS, [[]]");
	}

	@Test
	void testEqualsObject() {
//		fail("Not yet implemented");
	}

}
