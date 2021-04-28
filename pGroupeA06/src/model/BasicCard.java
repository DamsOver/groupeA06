package model;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import enumerations.Theme;
import exceptions.AlreadyPresentException;
import exceptions.NotPresentException;
import exceptions.TooLittleException;
import exceptions.TooManyException;
import util.Constants;


/**
 * An object representing a card, containing different Question object
 * @author Martin
 * */

public class BasicCard {
	
	/**
	 * The subject of the card
	 */
	private String subject;
	
	/**
	 * The list of Questions
	 */
	private List<Question> questions;
	
	/**
	 * The author of the card
	 */
	private String author;
	
	/**
	 * The Theme of the card
	 */
	private Theme theme;

	
	
	/**
	 * Constructor without any questions
	 * @param author	The author of the card
	 * @param theme		The Theme of the card 
	 * @param subject	The subject of the card
	 * */
	public BasicCard(String author, Theme theme, String subject) {
		this.author=author;
		this.theme=theme;
		this.subject = subject;
		this.questions = new ArrayList<Question>();
	}

	

	/**
	 * Constructor with already existing questions 
	 * @param author	The author of the card
	 * @param theme		The Theme of the card 
	 * @param subject	The subject of the card
	 * @param questions	The list of Questions
	 * */
	public BasicCard(String author, Theme theme, String subject, List<Question> questions) {
		this.author=author;
		this.theme=theme;
		this.subject = subject;

		// new objects because a question can only be accessed by one card
		this.questions = new ArrayList<Question>();
		for (Question q : questions) {
			this.questions.add(q.clone());
		}
	}

	
	/**
	 * Adds a question to the list of questions
	 * @param challenge	The question of the Question Object
	 * @param answer 	The answer of the challenge
	 * @throws AlreadyPresentException	error if the Question is already present
	 * @throws TooManyException		error if there is too many Question
	 * @return true if the Question has been successfully added to the list of questions
	 * */
	public boolean addQuestion(String challenge, String answer) throws AlreadyPresentException, TooManyException {

		// creation of a question
		Question newQuestion = new Question(this.author, this.theme, this.subject, challenge, answer);

		// scanning the list of questions to check if the question already exists
		for (Question q : questions) {
			if (q.equals(newQuestion)) {
				throw new AlreadyPresentException();
			}
		}

		// verification if the number of question is not the maximum
		if (Constants.NB_QUESTIONS_MAX == questions.size()) {
			throw new TooManyException();
		}

		// if everything is ok, adding the question
		questions.add(newQuestion);
		return true;
	}

	
	/**
	 * returns the subject
	 * @return the subject of the BasicCard
	 * */
	public String getSubject() {
		return subject;
	}

	/**
	 * returns the list of Question cloned
	 * @return the list of Question of the BasicCard
	 * */
	public ArrayList<Question> getQuestions() {
		ArrayList<Question> q = new ArrayList<Question>();

		for (Question quest : questions) {
			q.add(quest);
		}
		return q;
	}

	
	/**
	 * removes a question from the list of questions
	 * @param challenge	The question of the Question Object
	 * @param answer 	The answer of the challenge
	 * @throws NotPresentException	error if the Question is not present
	 * @throws TooLittleException	error if there is no question
	 * @return true if the Question has been successfully removed from the list of questions
	 * */
	public boolean removeQuestion(String challenge, String answer) throws NotPresentException, TooLittleException {

		// creation of a question
		Question newQuestion = new Question(this.author, this.theme, this.subject, challenge, answer);

		// verification if the number of question is not 0
		if (0 == questions.size()) {
			throw new TooLittleException();
		}

		// scanning the list of questions to check if the question exists
		boolean x = false;
		for (Question q : questions) {
			if (q.equals(newQuestion)) {
				x = true;
			}
		}

		// if the question does not exist
		if (x == false) {
			throw new NotPresentException();
		}

		// removing the question
		questions.remove(newQuestion);
		return true;
	}

	/**
	 * Checks if two objects are equals.
	 * Here only the subject and the theme are compared
	 * @param obj 	The Object the method compares to
	 * @return True if this is equal to the Object obj
	 * */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BasicCard other = (BasicCard) obj;
		if (!subject.equals(other.subject))
			return false;
		if (theme != other.theme)
			return false;
		if (!author.equals(other.author))
			return false;
		return true;
	}

	
	/**
	 * returns the author
	 * @return the author of the Card
	 * */
	public String getAuthor() {
		return author;
	}


	/**
	 * returns the Theme
	 * @return the Theme of the Card
	 * */
	public Theme getTheme() {
		return theme;
	}

	/**
	 * Converts the BasicCard Object and his fields into a String
	 * @return The String describing the Object
	 * */
	@Override
	public String toString() {
		return "\nBasicCard [author=" + author + ", theme=" + getTheme() + ", subject=" + subject + ", questions="
				+ questions + "]\n";
	}

	
	/**
	 * Transforms a String (Json) into a BasicCard Object
	 * @param json 	The String to convert
	 * @return A new BasicCard described by the String
	 * */
	public BasicCard fromJson(String json) {
		return new Gson().fromJson(json, BasicCard.class);
	}
	
	/**
	 * Transforms a BasicCard Object into a String
	 * @return A Json String describing the BasicCard
	 * */
	public String toJson(){
		return new Gson().toJson(this);
	}

	/**
	 * Returns a BasicCard with the fields having the exact same value as this BasicCard.
	 * @return a BasicCard Cloned
	 * */
	public BasicCard clone() {
		// the clone of the questions is done in the constructor
		return new BasicCard(this.getAuthor(), this.getTheme(), this.subject, questions);
	}
}
