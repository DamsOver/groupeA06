package model;

import application.SceneManager;
import enumerations.Theme;

public class FinishCard extends SpecialCard{

	@Override
	public void action() {
		SceneManager.getGameOperation().animationLastTurn().play();
	}
	
}