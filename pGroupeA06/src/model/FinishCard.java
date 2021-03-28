package model;

import application.SceneManager;
import enumerations.Theme;

public class FinishCard extends SpecialCard{

	@Override
	public void action() {
		//draw a card
		BasicCard bc = SceneManager.getGameOperation().drawCard(Theme.getRandomTheme());
		SceneManager.getGameOperation().setQuestion(bc.getQuestions().get(3));
	}
	
}