package model;

import application.SceneManager;
import enumerations.Theme;
import javafx.animation.Animation;


/**
 * A SpecialCard which is used at the start of the game.
 * @author Martin*/
public class StartCard extends SpecialCard {

	/**
	 * Gets a random BasicCard from the deck and sets it as the question the player need to answer
	 * @param transitions	A table containing the previous animations which needs to be played before the ones this method creates
	 * */
	@Override
	public void action(Animation[] transitions) {
		
		BasicCard bc = SceneManager.getCurrentGame().drawCard(Theme.getRandomTheme());
		
		//change the ratingAP labels
		SceneManager.getRating().setLbSubject(bc.getSubject());
		SceneManager.getRating().setLbTheme(bc.getTheme());
		SceneManager.getCurrentGame().animationTurn(transitions).play();
	}
}
