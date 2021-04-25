package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import enumerations.Theme;
import exceptions.AlreadyPresentException;
import exceptions.NotPresentException;
import exceptions.TooLittleException;
import exceptions.TooManyException;
import model.BasicCard;
import model.Question;

class TestBasicCard {

	private BasicCard bc;
	private List<Question> questions;

	@BeforeEach
	void setUp() throws Exception {
		bc = new BasicCard("Martin", Theme.IMPROBABLE, "Nature");
		Field field = bc.getClass().getDeclaredField("questions");
		field.setAccessible(true);
		questions = (List<Question>) field.get(bc);
	}

	@AfterEach
	void tearDown() throws Exception {
		bc = null;
		questions = null;
	}

	@Test
	void testAddQuestion() throws AlreadyPresentException, TooManyException {
		// add a single question
		assertTrue(bc.addQuestion("What is the only flying mammal?", "The bat"), "1st add succeed");
		assertEquals(questions.size(), 1);

		// add the same question
		assertThrows(AlreadyPresentException.class, () -> bc.addQuestion("What is the only flying mammal?", "The bat"));
		assertEquals(questions.size(), 1);

		// add a 2nd question
		assertTrue(bc.addQuestion("What is the only flying mammal?", "The ba"), "2nd add succeed");
		assertEquals(questions.size(), 2);

		// add a 3rd question
		assertTrue(bc.addQuestion("What is the only flying mammal?", "The b"), "3rd add succeed");
		assertEquals(questions.size(), 3);

		// add a 4th question
		assertTrue(bc.addQuestion("What is the only flying mammal?", "The "), "4th add succeed");
		assertEquals(questions.size(), 4);

		// try to add a 5th question
		assertThrows(TooManyException.class, () -> bc.addQuestion("What is the only flying mammal?", "The"));
		assertEquals(questions.size(), 4);
	}

	@Test
	void testGetQuestions() {
		assertEquals(questions.size(), bc.getQuestions().size());
		assertEquals(questions, bc.getQuestions());
	}

	@Test
	void testRemoveQuestion()
			throws NotPresentException, TooLittleException, AlreadyPresentException, TooManyException {
		// remove a question from an empty list
		assertEquals(questions.size(), 0);
		assertThrows(TooLittleException.class, () -> bc.removeQuestion("What is the only flying mammal?", "The bat"));

		// add a question
		assertTrue(bc.addQuestion("What is the only flying mammal?", "The bat"));
		assertEquals(questions.size(), 1);

		// remove a non-existing question
		assertThrows(NotPresentException.class, () -> bc.removeQuestion("What is the only flying mammal?", "The ba"));
		assertEquals(questions.size(), 1);

		// remove a question
		assertTrue(bc.removeQuestion("What is the only flying mammal?", "The bat"));
		assertEquals(questions.size(), 0);
	}

	@Test
	void testEqualsObject() {
		assertTrue(bc.equals(bc));
		assertFalse(bc.equals(null));
		assertFalse(bc.equals(questions));
		
		BasicCard bc2 = new BasicCard("Martin",Theme.INFORMATICS,"Nature");
		assertFalse(bc.equals(bc2));
		BasicCard bc3 = new BasicCard("Martin",Theme.IMPROBABLE,"Na");
		assertFalse(bc.equals(bc3));
	}

	@Test
	void testToString() throws AlreadyPresentException, TooManyException {
		assertTrue(bc.addQuestion("What is the only flying mammal?", "The bat"));
		assertEquals(bc.toString(),"\nBasicCard [author=Martin, theme=IMPROBABLE, subject=Nature, questions=[\nQuestion [author=Martin, theme=IMPROBABLE, subject=Nature, challenge=What is the only flying mammal?, answer=The bat]]]\n");
	}

	@Test
	void testFromJson() throws AlreadyPresentException, TooManyException {
		String test = "{\"subject\":\"Nature\",\"questions\":[{\"author\":\"Martin\",\"theme\":\"IMPROBABLE\",\"subject\":\"Nature\",\"challenge\":\"What is the only flying mammal?\",\"answer\":\"The bat\"}],\"author\":\"Martin\",\"theme\":\"IMPROBABLE\"}";
		bc.addQuestion("What is the only flying mammal?", "The bat");
		BasicCard bcTest = bc.fromJson(test);
		assertEquals(bc,bcTest);
	}

	@Test
	void testToJson() throws AlreadyPresentException, TooManyException {
		bc.addQuestion("What is the only flying mammal?", "The bat");
		assertEquals(bc.toJson(), "{\"subject\":\"Nature\",\"questions\":[{\"author\":\"Martin\",\"theme\":\"IMPROBABLE\",\"subject\":\"Nature\",\"challenge\":\"What is the only flying mammal?\",\"answer\":\"The bat\"}],\"author\":\"Martin\",\"theme\":\"IMPROBABLE\"}");

	}


	@Test
	void testClone() throws AlreadyPresentException, TooManyException, NotPresentException, TooLittleException {
		bc.addQuestion("What is the only flying mammal?", "The bat");
		BasicCard copyBc = bc.clone();
		assertEquals(bc, copyBc);
		copyBc.removeQuestion("What is the only flying mammal?", "The bat");
		assertFalse(bc.getQuestions().size() == copyBc.getQuestions().size(), "The list of bc does'nt have the same size as the list of copyBc");
	}

}
