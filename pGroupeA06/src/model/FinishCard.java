package model;

import application.SceneManager;
import enumerations.Theme;

public class FinishCard extends SpecialCard{

	@Override
	public void action() {
		BasicCard bc = SceneManager.getGameOperation().drawCard(Theme.getRandomTheme());
		SceneManager.getGameOperation().LastTurn();
	}
	
}
