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
	
	/**Activates the algorithm of the specialCard, divided in 3 steps : prelude, animCard and show
	 * @param transitions a table containing the previous animations*/
	public void action(Animation[] transitions) {
		prelude();
		Animation[] a = animCard(transitions);
		show(a);
	};
	
	/**Changes the message of the Animation
	 * @param message The message needed to be shown
	 * @param duree	the duration of the pause
	 * @return the animation*/
	public Transition message(String message, int duree) {
		
		//creation of a new PauseTransition
		PauseTransition pauseTransition = new PauseTransition(Duration.millis(duree));
		pauseTransition.setOnFinished(e -> {
			//setting the text
			SceneManager.getTransitionAnimation().setTxtAnimation(message);
			//setting the rootPane
			SceneManager.getSceneRoot().setRoot(SceneManager.getStackTransititionAnimation());
		});
		return pauseTransition;
	}
	
	/**
	 *Creates a specific animation for each individual SpecialCard
	 *@param first the table containing the previous animations needed to be played before the one the SpecialCard creates
	 *@return The animation created for the SpecialCard
	 * */
	public abstract Animation[] animCard(Animation[]first);
	
	
	/**
	 * Creates the steps needed before the creation of the animation
	 * */
	public abstract void prelude();
	
	/**
	 * Chooses the way the animation will be send/displayed
	 * @param a table containing the animation created in animCard*/
	public abstract void show(Animation[] a);
		
}
