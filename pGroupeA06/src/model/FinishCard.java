package model;

import application.SceneManager;
import enumerations.Theme;
import javafx.animation.Animation;
import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.util.Duration;
import util.Constants;


/**
 * A SpecialCard which is used at the end of the game.
 * @author Martin*/
public class FinishCard extends SpecialCard{


	/** Creates an animation for the last turn
	 * @return A table containing Animation of the whole turn*/
	@Override
	public Animation[] animCard(Animation[] first) {
		Animation[] tab = new Animation[(first==null)?4:first.length+4];
		Animation[] tabTemp = new Animation[4];
		
		//SceneManager.getSceneRoot().setRoot(SceneManager.getStackGame());
		SceneManager.getRating().setLbTurn(SceneManager.getCurrentGame().getPlayerTurn().getName());
		
		PauseTransition pauseTransition = new PauseTransition(Duration.millis(Constants.ANIMATION_TIME_TURN));
		pauseTransition.setOnFinished(e -> {
			BasicCard tempBasicCard = SceneManager.getCurrentGame().drawCard(Theme.getRandomTheme());
			SceneManager.getCurrentGame().setQuestion(tempBasicCard.getQuestions().get(3));
			SceneManager.getQuestion().getBtnOK().setDisable(false);
			SceneManager.getSceneRoot().setRoot(SceneManager.getStackQuestion());
		});
		
		tabTemp[3]= pauseTransition;
		tabTemp[2] = message("You have to answer\ncorrectly to this\ndifficult question to win",Constants.ANIMATION_TIME_TURN);
		tabTemp[1] = message("It's " + SceneManager.getCurrentGame().getPlayerTurn().getName() + "'s \nlast turn!",Constants.ANIMATION_TIME_TURN);
		tabTemp[0] = SceneManager.getCurrentGame().animation(Constants.ANIMATION_TIME_START,
				SceneManager.getStackGame(), null);
		if(first!=null) {
			for(int i = 0;i<first.length;i++) {
				tab[i]=first[i];
			}
			
			for(int i = first.length;i<first.length+4;i++) {
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
		
	}


	@Override
	public void show(Animation[] a) {
		SequentialTransition st = new SequentialTransition(a);
		st.play();
		
	}
}