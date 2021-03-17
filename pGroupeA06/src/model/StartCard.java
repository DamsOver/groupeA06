package model;

import application.SceneManager;
import enumerations.Theme;
import javafx.animation.PauseTransition;
import util.Constants;

public class StartCard extends SpecialCard {

	//constructeur
	
	public StartCard(String author, Theme theme) {
		setTheme(theme);
		setAuthor(author);
		}
	
	@Override
	public void action() {
		BasicCard bc = SceneManager.getGameOperation().drawCard(Theme.getRandomTheme());
		//change the ratingAP labels
		SceneManager.getRating().setLbSubject(bc.getSubject());
		SceneManager.getRating().setLbTheme(bc.getTheme());
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BasicCard fromJson(String json) {
		// TODO Auto-generated method stub
		return null;
	}
}
