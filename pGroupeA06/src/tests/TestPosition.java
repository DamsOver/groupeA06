package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Position;

class TestPosition {
	private Position pos;

	@BeforeEach
	void setUp() throws Exception {
		pos = new Position(2.5,3.0);
	}

	@AfterEach
	void tearDown() throws Exception {
		pos = null;
	}

	@Test
	void testEqualsObject() {
		Position p1 = new Position(2.5,3.0);
		assertTrue(pos.equals(p1));
		Position p2 = new Position(2.5,3.5);
		assertFalse(pos.equals(p2));
	}

	@Test
	void testToString() {
		assertEquals(pos.toString(),"Position [x=2.5, y=3.0]");
	}

}
