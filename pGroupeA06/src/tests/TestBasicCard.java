package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
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
	void testAddQuestion() throws AlreadyPresentException, TooManyException{
		
		Question q = new Question("Martin",Theme.IMPROBABLE,"Nature","What is the only flying mammal?", "The bat");
		
		// add a question
		assertEquals(questions.size(), 0,"No questions");
		assertTrue(bc.addQuestion("What is the only flying mammal?", "The bat"), "1st add succeed");
		assertEquals(questions.size(), 1,"One question");
		assertTrue(questions.contains(q),"Questions contains the question");
	}
	
	@Test
	void testAddQuestionAlreadyPresentException() throws AlreadyPresentException, TooManyException{
		
		Question q = new Question("Martin",Theme.IMPROBABLE,"Nature","What is the only flying mammal?", "The bat");
		
		// add a first question
		
		questions.add(q);
		assertEquals(questions.size(), 1,"One questions");
		assertTrue(questions.contains(q),"Contains question q");
		
		// add the same question
		assertThrows(AlreadyPresentException.class,()->bc.addQuestion("What is the only flying mammal?", "The bat"));
	}
	
	@Test
	void testAddQuestionTooManyException() throws AlreadyPresentException, TooManyException{
		
		Question q = new Question("Martin",Theme.IMPROBABLE,"Nature","What is the only flying mammal?", "The bat");
		Question q1 = new Question("Martin",Theme.IMPROBABLE,"Nature","What is the only flying mamma?", "The ba");
		Question q2 = new Question("Martin",Theme.IMPROBABLE,"Nature","What is the only flying mamm?", "The b");
		Question q3= new Question("Martin",Theme.IMPROBABLE,"Nature","What is the only flying mam?", "The ");
		
		// add a first question
		
		questions.add(q);
		questions.add(q1);
		questions.add(q2);
		questions.add(q3);
		assertEquals(questions.size(), 4,"4 questions");

		// add another question
		assertThrows(TooManyException.class,()->bc.addQuestion("What is the only flying?", "The"));
	}
	

	@Test
	void testGetQuestions() {
		assertEquals(questions.size(), bc.getQuestions().size());
		assertEquals(questions, bc.getQuestions());
	}

	@Test
	void testRemoveQuestion() throws TooLittleException, NotPresentException{
		
		// add a question
		questions.add(new Question("Martin",Theme.IMPROBABLE,"Nature","What is the only flying mammal?", "The bat"));
		assertEquals(questions.size(), 1,"1 question in questions");

		// remove a question
		assertTrue(bc.removeQuestion("What is the only flying mammal?", "The bat"));
		assertEquals(questions.size(), 0);
	}
	
	@Test
	void testRemoveQuestionTooLittleException() throws TooLittleException, NotPresentException{
		// remove a question from an empty list
		assertEquals(questions.size(), 0);
		assertThrows(TooLittleException.class,()-> bc.removeQuestion("What is the only flying mammal?", "The bat"));
	}
	
	@Test
	void testRemoveQuestionNotPresentException() throws TooLittleException, NotPresentException{


		// add a question
		questions.add(new Question("Martin",Theme.IMPROBABLE,"Nature","What is the only flying mammal?", "The bat"));
		assertEquals(questions.size(), 1,"1 question in questions");

		// remove a non-existing question
		assertThrows(NotPresentException.class,()->bc.removeQuestion("What is the only flying mammal?", "The ba"));
		assertEquals(questions.size(), 1);
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
	void testToString() throws AlreadyPresentException, TooManyException{
		assertTrue(bc.addQuestion("What is the only flying mammal?", "The bat"));
		assertEquals(bc.toString(),"\nBasicCard [author=Martin, theme=IMPROBABLE, subject=Nature, questions=[\nQuestion [author=Martin, theme=IMPROBABLE, subject=Nature, challenge=What is the only flying mammal?, answer=The bat]]]\n");
	}

	@Test
	void testFromJson() throws AlreadyPresentException, TooManyException{
		String test = "{\"subject\":\"Nature\",\"questions\":[{\"author\":\"Martin\",\"theme\":\"IMPROBABLE\",\"subject\":\"Nature\",\"challenge\":\"What is the only flying mammal?\",\"answer\":\"The bat\"}],\"author\":\"Martin\",\"theme\":\"IMPROBABLE\"}";
		bc.addQuestion("What is the only flying mammal?", "The bat");
		BasicCard bcTest = bc.fromJson(test);
		assertEquals(bc,bcTest);
	}

	@Test
	void testToJson() throws AlreadyPresentException, TooManyException{
		bc.addQuestion("What is the only flying mammal?", "The bat");
		assertEquals(bc.toJson(), "{\"subject\":\"Nature\",\"questions\":[{\"author\":\"Martin\",\"theme\":\"IMPROBABLE\",\"subject\":\"Nature\",\"challenge\":\"What is the only flying mammal?\",\"answer\":\"The bat\"}],\"author\":\"Martin\",\"theme\":\"IMPROBABLE\"}");

	}


	@Test
	void testClone() throws AlreadyPresentException, TooManyException, TooLittleException, NotPresentException{
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
