package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import enumerations.Theme;
import model.Board;
import model.Question;
import model.Square;

class TestBoard {
	private Board board,b;
	private List<Square> squares,listSquares;

	@SuppressWarnings("unchecked")
	@BeforeEach
	void setUp() throws Exception {
		board = new Board();
		b=new Board();
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
	void testGetSquares() {
		Square s = new Square(Theme.IMPROBABLE);
		Square s2 = new Square(Theme.INFORMATICS);
		squares.add(s);
		squares.add(s2);
		
		List<Square> squareList = new ArrayList<Square>();
		squareList.add(s);
		squareList.add(s2);
		
		assertEquals(board.getSquares(),squareList);
	}

	@Test
	void testToJson() {
		Square s = new Square(Theme.IMPROBABLE);
		Square s2 = new Square(Theme.INFORMATICS);
		squares.add(s2);
		squares.add(s);
		assertEquals(board.toJson(), "{\"squares\":[{\"theme\":\"INFORMATICS\",\"playersPosition\":[]},{\"theme\":\"IMPROBABLE\",\"playersPosition\":[]}]}");
	}

	@SuppressWarnings("unchecked")
	@Test
	void testFromJson() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Square s = new Square(Theme.START);
		Square s2 = new Square(Theme.FINISH);
		squares.add(s);
		squares.add(s2);
		
		b =b.fromJson("boardTest.JSON");
		
		Field field2 = board.getClass().getDeclaredField("squares");
		field2.setAccessible(true);
		listSquares = (List<Square>) field2.get(b);
		
		
		assertEquals(squares,listSquares);
		
	}

	@Test
	void testToString() {
		Square s = new Square(Theme.IMPROBABLE);
		Square s2 = new Square(Theme.INFORMATICS);
		squares.add(s2);
		squares.add(s);
		assertEquals(board.toString(),"Board [Board=[INFORMATICS, [[]], IMPROBABLE, [[]]]]");
	}
	
	@SuppressWarnings("unchecked")
	@Test
	void testEquals() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		assertTrue(board.equals(board));
		assertTrue(!board.equals(null));
		assertTrue(!board.equals(""));
		b=new Board();
		
		assertTrue(board.equals(b));
		
		b =b.fromJson("boardTest.JSON");
		Field field2 = board.getClass().getDeclaredField("squares");
		field2.setAccessible(true);
		listSquares = (List<Square>) field2.get(b);
		
		assertTrue(!board.equals(b));
		
		listSquares=null;
		assertTrue(!board.equals(b));
		
	}
	

}
