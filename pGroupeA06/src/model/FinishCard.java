package model;

import application.SceneManager;
import javafx.animation.Animation;

public class FinishCard extends SpecialCard{

	@Override
	public void action(Animation[] transitions) {
		SceneManager.getGameOperation().animationLastTurn().play();
	}
}