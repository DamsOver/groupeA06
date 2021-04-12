package model;

import application.SceneManager;

public class FinishCard extends SpecialCard{

	@Override
	public void action() {
		SceneManager.getGameOperation().animationLastTurn().play();
	}
}