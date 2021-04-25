package model;

import javafx.animation.Animation;


/**
 * An abstract Class which is used in the DP Template method.
 * @author Martin*/
public abstract class SpecialCard {
	
	/**activates the animation of the specialCard
	 * @param transitions a table containing the previous animations*/
	public abstract void action(Animation[] transitions);
		
}
