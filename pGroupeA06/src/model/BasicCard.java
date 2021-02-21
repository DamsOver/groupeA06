package model;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import enumerations.Theme;
import exceptions.AlreadyPresentException;
import exceptions.NotPresentException;
import exceptions.TooLittleException;
import exceptions.TooManyException;

public class BasicCard {
	
	public final static int NB_QUESTIONS_MAX = 4;
	private String author;
	private Theme theme;
	private String subject;
	private List<Question> questions;
	
	
	//constructor
	public BasicCard(String author, Theme theme, String subject) {
		this.author = author;
		this.theme = theme;
		this.subject = subject;
		this.questions = new ArrayList<Question>();
	}
	
	//constructor
	public BasicCard(String author, Theme theme, String subject,List<Question>questions) {
		this.author = author;
		this.theme = theme;
		this.subject = subject;
		
		//new objects because a question can only be accessed by one card
		this.questions = new ArrayList<Question>();
		for(Question q : questions) {
			this.questions.add(q.clone());
		}
	}
	
	//to add a question
	public boolean addQuestion(String challenge, String answer)throws AlreadyPresentException,TooManyException {
		
		//creation of a question
		Question newQuestion = new Question(this.author,this.theme,this.subject,challenge,answer);
		
		//scanning the list of questions to check if the question already exists
		for(Question q : questions) {
			if(q.equals(newQuestion)) {
				throw new AlreadyPresentException();
			}
		}
	
		//verification if the number of question is not the maximum
		if(NB_QUESTIONS_MAX==questions.size()) {
			throw new TooManyException();
		}
		
		//if everything is ok, adding the question
		questions.add(newQuestion);
		return true;
	}
	
	//to remove a question
	public boolean removeQuestion(String challenge, String answer)throws NotPresentException,TooLittleException {
		
		//creation of a question
		Question newQuestion = new Question(this.author,this.theme,this.subject,challenge,answer);
		
		//verification if the number of question is not 0
		if(0==questions.size()) {
			throw new TooLittleException();
		}
		
		//scanning the list of questions to check if the question exists
		boolean x = false;
		for(Question q : questions) {
			if(q.equals(newQuestion)) {
				x=true;
			}
		}
		
		//if the question does not exist
		if(x==false) {
			throw new NotPresentException();
		}
		
		//removing the question
		questions.remove(newQuestion);
		return true;
	}
	
	

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
		return true;
	}

	@Override
	public String toString() {
		return "BasicCard [author=" + author + ", theme=" + theme + ", subject=" + subject + ", questions=" + questions
				+ "]\n";
	}

	public String toJson() {
		return new Gson().toJson(this);
	}
	
	public BasicCard fromJson(String json) {
		return new Gson().fromJson(json,BasicCard.class);
	}	
	
	public BasicCard clone() {
		//the clone of the questions is done in the constructor
		return new BasicCard(this.author,this.theme,this.subject,questions);
	}
}
