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
		assertTrue(question.equals(question));
		assertFalse(question.equals(null));
		assertFalse(question.equals("ok"));
		
		Question q1a = new Question("Damien", Theme.INFORMATICS, "oop", "What is the name of the process that takes care of automatic memory management?", null);
		assertFalse(question.equals(q1a));
		assertFalse(q1a.equals(question));
		
		Question q1b = new Question("Damien", Theme.INFORMATICS, null, "What is the name of the process that takes care of automatic memory management?", "Garbage Collector");
		assertFalse(question.equals(q1b));
		assertFalse(q1b.equals(question));
		
		Question q1 = new Question("Damien", Theme.INFORMATICS, "oop", "What is the name of the process that takes care of automatic memory management?", "Garbage Collector");
		assertEquals(question, q1);
		Question q3 = new Question("Damien", Theme.IMPROBABLE, "oop", "What is the name of the process that takes care of automatic memory management?", "Garbage Collector");
		assertFalse(question.equals(q3));
		Question q4 = new Question("Damien", Theme.INFORMATICS, "", "What is the name of the process that takes care of automatic memory management?", "Garbage Collector");
		assertFalse(question.equals(q4));
		Question q6 = new Question("Damien", Theme.INFORMATICS, "oop", "What is the name of the process that takes care of automatic memory management?", "");
		assertFalse(question.equals(q6));
	}

	@Test
	void testClone() {
		Question q1 = question.clone();
		assertEquals(question, q1);
		q1.setAnswer("test");
		assertFalse(question.equals(q1));
	}
	
	@Test
	void testGetChallenge() {
		assertEquals(question.getChallenge(),"What is the name of the process that takes care of automatic memory management?");
	}
	
	@Test
	void testGetAsnwer() {
		assertEquals(question.getAnswer(),"Garbage Collector");
	}

}
