package model;

import application.SceneManager;
import enumerations.Theme;
import javafx.animation.Animation;
import javafx.animation.SequentialTransition;
import util.Constants;


/**
 * A SpecialCard which is used at the start of the game.
 * @author Martin*/
public class StartCard extends SpecialCard {


	/** Creates an animation for the StartCard
	 * @param before 	The animations before
	 * @return A table containing SequentialTransitions of the turn*/
	public Animation[] animCard(Animation[] first) {
		Animation[] tab = new Animation[(first==null)?3:first.length+3];
		Animation[] tabTemp = new Animation[3];
		SceneManager.getRating().setLbTurn(SceneManager.getCurrentGame().getPlayerTurn().getName());
		tabTemp[2]= SceneManager.getCurrentGame().animation(Constants.ANIMATION_TIME_RATING,
				SceneManager.getStackRating(), null);
		tabTemp[1] =  message("It's " + SceneManager.getCurrentGame().getPlayerTurn().getName() + "'s first turn!", Constants.ANIMATION_TIME_TURN);
		tabTemp[0] = SceneManager.getCurrentGame().animation(Constants.ANIMATION_TIME_START,
				SceneManager.getStackGame(), null);
		if(first!=null) {
			for(int i = 0;i<first.length;i++) {
				tab[i]=first[i];
			}
			
			for(int i = first.length;i<first.length+3;i++) {
				tab[i]=tabTemp[i-first.length];
			}
			
			return tab;
		}
		else {
			
			return tabTemp;
		}
	}

	@Override
	public void prelude() {
		BasicCard bc = SceneManager.getCurrentGame().drawCard(Theme.getRandomTheme());
		//change the ratingAP labels
		SceneManager.getRating().setLbSubject(bc.getSubject());
		SceneManager.getRating().setLbTheme(bc.getTheme());
		
	}

	@Override
	public void show(Animation[] a) {
		SequentialTransition st = new SequentialTransition(a);
		st.play();
	}
	
		
		
		
		
		
		
		
}
