package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import enumerations.Theme;
import model.BasicCard;
import model.Question;

class TestBasicCard {

	private BasicCard bc;
	private List<Question> questions;

	@SuppressWarnings("unchecked")
	@BeforeEach
	void setUp() throws Exception {
		bc = new BasicCard("Martin", Theme.IMPROBABLE, "Nature");
		Field field = bc.getClass().getDeclaredField("questions");
		field.setAccessible(true);
		questions = (List<Question>)(field.get(bc));
	}

	@AfterEach
	void tearDown() throws Exception {
		bc = null;
		questions = null;
	}

	@Test
	void testAddQuestion(){
		// add a single question
		assertTrue(bc.addQuestion("What is the only flying mammal?", "The bat"), "1st add succeed");
		assertEquals(questions.size(), 1);

		// add the same question
		assertFalse(bc.addQuestion("What is the only flying mammal?", "The bat"));
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
		assertFalse(bc.addQuestion("What is the only flying mammal?", "The"));
		assertEquals(questions.size(), 4);
	}

	@Test
	void testGetQuestions() {
		assertEquals(questions.size(), bc.getQuestions().size());
		assertEquals(questions, bc.getQuestions());
	}

	@Test
	void testRemoveQuestion(){
		// remove a question from an empty list
		assertEquals(questions.size(), 0);
		assertFalse(bc.removeQuestion("What is the only flying mammal?", "The bat"));

		// add a question
		assertTrue(bc.addQuestion("What is the only flying mammal?", "The bat"));
		assertEquals(questions.size(), 1);

		// remove a non-existing question
		assertFalse(bc.removeQuestion("What is the only flying mammal?", "The ba"));
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
		
		BasicCard bc4 = new BasicCard("Mart",Theme.IMPROBABLE,"Nature");
		assertFalse(bc.equals(bc4));
	}

	@Test
	void testToString(){
		assertTrue(bc.addQuestion("What is the only flying mammal?", "The bat"));
		assertEquals(bc.toString(),"\nBasicCard [author=Martin, theme=IMPROBABLE, subject=Nature, questions=[\nQuestion [author=Martin, theme=IMPROBABLE, subject=Nature, challenge=What is the only flying mammal?, answer=The bat]]]\n");
	}

	@Test
	void testFromJson(){
		String test = "{\"subject\":\"Nature\",\"questions\":[{\"author\":\"Martin\",\"theme\":\"IMPROBABLE\",\"subject\":\"Nature\",\"challenge\":\"What is the only flying mammal?\",\"answer\":\"The bat\"}],\"author\":\"Martin\",\"theme\":\"IMPROBABLE\"}";
		bc.addQuestion("What is the only flying mammal?", "The bat");
		BasicCard bcTest = bc.fromJson(test);
		System.out.println(bc.fromJson(test).toString());
		System.out.println(bc.toString());
		assertEquals(bc,bcTest);
	}

	@Test
	void testToJson(){
		bc.addQuestion("What is the only flying mammal?", "The bat");
		assertEquals(bc.toJson(), "{\"subject\":\"Nature\",\"questions\":[{\"author\":\"Martin\",\"theme\":\"IMPROBABLE\",\"subject\":\"Nature\",\"challenge\":\"What is the only flying mammal?\",\"answer\":\"The bat\"}],\"author\":\"Martin\",\"theme\":\"IMPROBABLE\"}");

	}


	@Test
	void testClone(){
		bc.addQuestion("What is the only flying mammal?", "The bat");
		BasicCard copyBc = bc.clone();
		assertEquals(bc, copyBc);
		copyBc.removeQuestion("What is the only flying mammal?", "The bat");
		assertFalse(bc.getQuestions().size() == copyBc.getQuestions().size(), "The list of bc does'nt have the same size as the list of copyBc");
	}
	
	@Test
	void testGetSubject() {
		assertEquals(bc.getSubject(),"Nature");
	}

}
