package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import enumerations.Theme;
import model.Board;
import model.Question;
import model.Square;

class TestBoard {
	private Board board;
	private List<Square> squares;

	@BeforeEach
	void setUp() throws Exception {
		board = new Board();
		Field field = board.getClass().getDeclaredField("squares");
		field.setAccessible(true);
		squares = (List<Square>) field.get(board);
	}

	@AfterEach
	void tearDown() throws Exception {
		board = null;
		squares = null;
	}

	@Test
	void testAddSquare() {
		Square square1 = new Square(Theme.INFORMATICS);
		Square square2 = new Square(Theme.IMPROBABLE);
		board.addSquare(square1);
		board.addSquare(square2);
		assertEquals(board.getSquares().size(), 2);
//		fail("Not yet implemented");
	}

	@Test
	void testGetSquares() {
//		fail("Not yet implemented");
	}

	@Test
	void testToJson() {
		Square square1 = new Square(Theme.INFORMATICS);
		Square square2 = new Square(Theme.IMPROBABLE);
		assertTrue(board.addSquare(square1));
		assertTrue(board.addSquare(square2));
		assertEquals(board.toJson(), "{\"squares\":[{\"theme\":\"INFORMATICS\",\"playersPosition\":[]},{\"theme\":\"IMPROBABLE\",\"playersPosition\":[]}]}");
	}

	@Test
	void testFromJson() {
//		fail("Not yet implemented");
	}

	@Test
	void testToString() {
		Square square1 = new Square(Theme.INFORMATICS);
		Square square2 = new Square(Theme.IMPROBABLE);
		assertTrue(board.addSquare(square1));
		assertTrue(board.addSquare(square2));
		assertEquals(board.toString(),"Board [Board=[INFORMATICS, [[]], IMPROBABLE, [[]]]]");
	}

}
