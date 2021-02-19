package model;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import enumerations.Theme;
import exceptions.AlreadyPresentException;
import exceptions.NotPresentException;
import exceptions.TooLittleException;
import exceptions.TooManyException;
import util.DifficultyComparator;

public class BasicCard {
	
	public final static int NB_QUESTIONS_MAX = 4;
	private String author;
	private Theme theme;
	private String subject;
	private List<Question> questions;
	
	
	public BasicCard(String author, Theme theme, String subject) {
		this.author = author;
		this.theme = theme;
		this.subject = subject;
		this.questions = new ArrayList<Question>();
	}
	
	public void addQuestion(String challenge, String answer,int difficulty)throws AlreadyPresentException,TooManyException {
		Question newQuestion = new Question(this.author,this.theme,this.subject,challenge,answer,difficulty);
		
		for(Question q : questions) {
			if(q.equals(newQuestion)) {
				throw new AlreadyPresentException();
			}
		}
		if(NB_QUESTIONS_MAX==questions.size()) {
			throw new TooManyException();
		}
		questions.add(newQuestion);
		
		//on retrie la carte
		try {
			sortByDifficulty();
		} catch (TooLittleException e) {
			e.printStackTrace();
		}
		
	}
	
	public void removeQuestion(String challenge, String answer,int difficulty)throws NotPresentException,TooLittleException {
		Question newQuestion = new Question(this.author,this.theme,this.subject,challenge,answer,difficulty);
		if(0==questions.size()) {
			throw new TooLittleException();
		}
		
		boolean x = false;
		for(Question q : questions) {
			if(q.equals(newQuestion)) {
				x=true;
			}
		}
		if(x==false) {
			throw new NotPresentException();
		}
		
		questions.remove(newQuestion);
	}
	
	public void sortByDifficulty()  throws TooLittleException{
		if(0==questions.size()) {
			throw new TooLittleException();
		}
		questions.sort(new DifficultyComparator());
	}
	
	@Override
	public String toString() {
		return "BasicCard [author=" + author + ", theme=" + theme + ", subject=" + subject + ", questions=" + questions
				+ "]";
	}

	public String toJson() {
		return new Gson().toJson(this);
	}
	
	public BasicCard fromJson(String json) {
		return new Gson().fromJson(json,BasicCard.class);
	}	
}
