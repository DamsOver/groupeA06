package model;

import com.google.gson.Gson;

import enumerations.Theme;


/**
 * An object representing a Question
 * @author Martin
 * */
public class Question {

	/**
	 * The author of the Question
	 * */
	private String author;
	
	/**
	 * The Theme of the Question
	 * */
	private Theme theme;
	
	/**
	 * The subject of the Question
	 * */
	private String subject;
	
	/**
	 * The challenge (question) of the Question
	 * */
	private String challenge;
	
	/**
	 * The answer of the Question
	 * */
	private String answer;

	/**
	 * Constructor of a Question
	 * @param author	The author of the Question
	 * @param theme		The Theme of the Question 
	 * @param subject	The subject of the Question
	 * @param challenge	The challenge of the Question
	 * @param answer	The answer of the Question
	 * */
	public Question(String author, Theme theme, String subject, String challenge, String answer) {
		this.author = author;
		this.theme = theme;
		this.subject = subject;
		this.challenge = challenge;
		this.answer = answer;
	}

	/**
	 * returns the challenge
	 * @return the challenge of the Question
	 * */
	public String getChallenge() {
		return challenge;
	}

	/**
	 * returns the answer
	 * @return the answer of the challenge
	 * */
	public String getAnswer() {
		return answer;
	}

	/**
	 * sets the answer of the Question
	 * @param the answer of the challenge
	 * */
	public void setAnswer(String answer) {
		this.answer = answer;
	}

	/**
	 * Transforms a Question Object into a String
	 * @return A Json String describing the Question
	 * */
	public String toJson() {
		return new Gson().toJson(this);
	}

	/**
	 * Transforms a String (Json) into a Question Object
	 * @param json 	The String to convert
	 * @return A new Question described by the String
	 * */
	public Question fromJson(String json) {
		return new Gson().fromJson(json, Question.class);
	}

	/**
	 * Converts the Question Object and his fields into a String
	 * @return The String describing the Object
	 * */
	@Override
	public String toString() {
		return "\nQuestion [author=" + author + ", theme=" + theme + ", subject=" + subject + ", challenge=" + challenge
				+ ", answer=" + answer + "]";
	}


	/**
	 * Checks if two objects are equals.
	 * @param obj 	The Object the method compares to
	 * @return True if this is equal to the Object obj
	 * */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Question other = (Question) obj;
		if (answer == null) {
			if (other.answer != null)
				return false;
		} else if (!answer.equals(other.answer))
			return false;
		if (subject == null) {
			if (other.subject != null)
				return false;
		} else if (!subject.equals(other.subject))
			return false;
		if (theme != other.theme)
			return false;
		return true;
	}

	
	/**
	 * Returns a Question with the fields having the exact same value as this Question.
	 * @return a Question Cloned
	 * */
	public Question clone() {
		return new Question(this.author, this.theme, this.subject, this.challenge, this.answer);
	}

}
