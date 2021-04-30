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
		assertTrue(pos.equals(pos));
		assertFalse(pos.equals(null));
		assertFalse(pos.equals("ok"));
		Position p1 = new Position(2.5,3.0);
		assertTrue(pos.equals(p1));
		Position p2 = new Position(2.5,3.5);
		assertFalse(pos.equals(p2));
		Position p3 = new Position(2.0,3.0);
		assertFalse(pos.equals(p3));
	}

	@Test
	void testToString() {
		assertEquals(pos.toString(),"Position [x=2.5, y=3.0]");
	}
	
	@Test
	void testGetX() {
		assertEquals(2.5,pos.getX());
	}
	
	@Test
	void testGetY() {
		assertEquals(3.0,pos.getY());
	}
	
	@Test
	void testClone() {
		assertEquals(pos,pos.clone());
	}

}
