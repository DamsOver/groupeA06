package model;

import application.SceneManager;
import javafx.animation.Animation;
import javafx.animation.PauseTransition;
import javafx.animation.Transition;
import javafx.util.Duration;


/**
 * An abstract Class which is used in the DP Template method.
 * @author Martin*/
public abstract class SpecialCard {
	
	/**activates the animation of the specialCard
	 * @param transitions a table containing the previous animations*/
	public abstract void action(Animation[] transitions);
	
	/**Changes the message of the Animation
	 * @param message The message needed to be shown
	 * @param duree	the duration of the pause
	 * @return the animation*/
	public Transition message(String message, int duree) {
		PauseTransition pauseTransition = new PauseTransition(Duration.millis(duree));
		pauseTransition.setOnFinished(e -> {
			SceneManager.getTransitionAnimation().setTxtAnimation(message);
			SceneManager.getSceneRoot().setRoot(SceneManager.getStackTransititionAnimation());
		});
		return pauseTransition;
	}
	
	public abstract Animation[] animCard(Animation[]first);
		
}
