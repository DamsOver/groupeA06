package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import enumerations.Theme;
import model.Question;

class TestQuestion {

	private Question question;
	
	@BeforeEach
	void setUp() throws Exception {
		question = new Question("Damien", Theme.INFORMATICS, "oop", "What is the name of the process that takes care of automatic memory management?", "Garbage Collector");
	}

	@AfterEach
	void tearDown() throws Exception {
		question = null;
	}

	@Test
	void testToJson() {
		assertEquals(question.toJson(),"{\"author\":\"Damien\",\"theme\":\"INFORMATICS\",\"subject\":\"oop\",\"challenge\":\"What is the name of the process that takes care of automatic memory management?\",\"answer\":\"Garbage Collector\"}");
	}

	@Test
	void testFromJson() {
//		fail("Not yet implemented");
	}

	@Test
	void testToString() {
		assertEquals(question.toString(),"\nQuestion [author=Damien, theme=INFORMATICS, subject=oop, challenge=What is the name of the process that takes care of automatic memory management?, answer=Garbage Collector]");
	}

	@Test
	void testEqualsObject() {
		Question q1 = new Question("Damien", Theme.INFORMATICS, "oop", "What is the name of the process that takes care of automatic memory management?", "Garbage Collector");
		assertEquals(question, q1);
		Question q2 = new Question("Test", Theme.INFORMATICS, "oop", "What is the name of the process that takes care of automatic memory management?", "test");
		assertFalse(question.equals(q2));
	}

	@Test
	void testClone() {
		Question q1 = question.clone();
		assertEquals(question, q1);
		q1.setAnswer("test");
		assertFalse(question.equals(q1));
	}

}
