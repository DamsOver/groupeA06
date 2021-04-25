package model;

import application.SceneManager;
import javafx.animation.Animation;


/**
 * A SpecialCard which is used at the end of the game.
 * @author Martin*/
public class FinishCard extends SpecialCard{

	
	/**
	 * Calls the function animationLastTurn() from the GameOperation
	 * @param transitions	A table containing the previous animations which needs to be played before the ones this method creates
	 * */
	@Override
	public void action(Animation[] transitions) {
		SceneManager.getGameOperation().animationLastTurn().play();
	}
}