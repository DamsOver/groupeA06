package tests;

import static org.junit.jupiter.api.Assertions.*;

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
import test.Explorateur;

class TestBasicCard {

	private BasicCard bc;
	private List<Question> questions;
	
	@SuppressWarnings("unchecked")
	
	@BeforeEach
	void setUp() throws Exception {
		bc = new BasicCard("Martin",Theme.IMPROBABLE,"Nature");
		questions = ((List<Question>) Explorateur.getField(bc, "questions"));
	}
	
	@AfterEach
	void tearDown() throws Exception {
		bc = null;
		questions = null;
	}
	
	
	@Test
	void testAddQuestion()throws AlreadyPresentException,TooManyException  {
		
		//add a single question
		assertTrue(bc.addQuestion("What is the only flying mammal?", "The bat"),"1st add succeed");
		assertEquals(questions.size(), 1);
		
		//add the same question
		assertThrows(AlreadyPresentException.class,()->bc.addQuestion("What is the only flying mammal?", "The bat"));
		assertEquals(questions.size(), 1);
		
		
		//add a 2nd question
		assertTrue(bc.addQuestion("What is the only flying mammal?", "The ba"),"2nd add succeed");
		assertEquals(questions.size(), 2);
		
		//add a 3rd question
		assertTrue(bc.addQuestion("What is the only flying mammal?", "The b"),"3rd add succeed");
		assertEquals(questions.size(), 3);
		
		//add a 4th question
		assertTrue(bc.addQuestion("What is the only flying mammal?", "The "),"4th add succeed");
		assertEquals(questions.size(), 4);
		
		//try to add a 5th question
		assertThrows(TooManyException.class,()->bc.addQuestion("What is the only flying mammal?", "The"));
		assertEquals(questions.size(), 4);
	}

	@Test
	void testRemoveQuestion() throws NotPresentException,TooLittleException, AlreadyPresentException, TooManyException{
		//remove a question from an empty list
		assertEquals(questions.size(),0);
		assertThrows(TooLittleException.class,()->bc.removeQuestion("What is the only flying mammal?", "The bat"));
	
		
		//add a question
		assertTrue(bc.addQuestion("What is the only flying mammal?", "The bat"));
		assertEquals(questions.size(), 1);
		
		//remove a non-existing question
		assertThrows(NotPresentException.class,()->bc.removeQuestion("What is the only flying mammal?", "The ba"));
		assertEquals(questions.size(),1);
		
		//remove a question
		assertTrue(bc.removeQuestion("What is the only flying mammal?", "The bat"));
		assertEquals(questions.size(),0);
	}
	@Test
	void testJson() throws AlreadyPresentException, TooManyException {
		//add a question
		assertTrue(bc.addQuestion("What is the only flying mammal?", "The bat"));
	
		
		assertEquals(bc.toJson(),"{\"author\":\"Martin\",\"theme\":\"IMPROBABLE\",\"subject\":\"Nature\",\"questions\":[{\"author\":\"Martin\",\"theme\":\"IMPROBABLE\",\"subject\":\"Nature\",\"challenge\":\"What is the only flying mammal?\",\"answer\":\"The bat\"}]}");
		assertEquals(bc.fromJson(bc.toJson()),bc);
	}
	
	@Test
	void testToString() throws AlreadyPresentException, TooManyException {
		//add a question
		assertTrue(bc.addQuestion("What is the only flying mammal?", "The bat"));
		assertEquals(bc.toString(),"BasicCard [author=Martin, theme=IMPROBABLE, subject=Nature, questions=[Question [author=Martin, theme=IMPROBABLE, subject=Nature, challenge=What is the only flying mammal?, answer=The bat]\n]]\n");
	}
	
	@Test
	void testEquals() {
		assertTrue(bc.equals(bc));
		assertFalse(bc.equals(null));
		assertFalse(bc.equals(questions));
		
		BasicCard bc2 = new BasicCard("Martin",Theme.INFORMATICS,"Nature");
		assertFalse(bc.equals(bc2));
		BasicCard bc3 = new BasicCard("Martin",Theme.IMPROBABLE,"Na");
		assertFalse(bc.equals(bc3));
		
	}
	
	
}
