package model;

import application.SceneManager;
import enumerations.Theme;

public class StartCard extends SpecialCard {

	//constructeur
	
	public StartCard(String author, Theme theme) {
		setTheme(theme);
		setAuthor(author);
		}
	
	@Override
	public void action() {
		SceneManager.getGameOperation().drawCard(Theme.FINISH);
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
