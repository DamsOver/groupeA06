package model;

import java.util.Random;

import application.SceneManager;
import javafx.animation.PauseTransition;
import util.Constants;

public class BasicSpecialCard extends SpecialCard{
	@Override
	public void action() {
		int randomNumber = new Random().nextInt(1) + 1;
		
		switch(1) {//randomNumber
		case 1 :
			//move the player forward or backwards 1,2 or 3 squares on the board
			int backwards = new Random().nextInt(2); //2
			int squares = new Random().nextInt(2)+1; //3
			String message = "";
			
			if(backwards==0) {
				//show the message
				message = "You move "+squares+"\nsquares forward!";
				
				PauseTransition p3 = SceneManager.getGameOperation().animation(Constants.ANIMATION_TIME_TURN, SceneManager.getStackGame(), null, null);
				PauseTransition p2 = SceneManager.getGameOperation().animation(Constants.ANIMATION_TIME_RATING, SceneManager.getStackTransititionAnimation(), message, p3);
				PauseTransition p1 = SceneManager.getGameOperation().animation(Constants.ANIMATION_TIME_TURN, SceneManager.getStackTransititionAnimation(), "It's "+ GameOperation.getPlayerTurn().getName() +"'s turn!", p2);
				p1.play();
				
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//show the pion moving
				GameOperation.getGame().movePlayer(squares,
						GameOperation.getPlayerTurn().getSquare(),
						GameOperation.getPlayerTurn());
					
			}
			else {
				//show the message
				message = "You move "+squares+"\nsquares backwards!";
				PauseTransition p3 = SceneManager.getGameOperation().animation(Constants.ANIMATION_TIME_TURN, SceneManager.getStackGame(), null, null);
				PauseTransition p2 = SceneManager.getGameOperation().animation(Constants.ANIMATION_TIME_RATING, SceneManager.getStackTransititionAnimation(), message, p3);
				PauseTransition p1 = SceneManager.getGameOperation().animation(Constants.ANIMATION_TIME_TURN, SceneManager.getStackTransititionAnimation(), "It's "+ GameOperation.getPlayerTurn().getName() +"'s turn!", p2);
				p1.play();
				
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				//show the pion moving
				GameOperation.getGame().movePlayer(-squares,
						GameOperation.getPlayerTurn().getSquare(),
						GameOperation.getPlayerTurn());
						
			}
			//show next turn
			SceneManager.getGameOperation().turnRating(false);
			break;
			
		case 2 :
			//skip your next turn
			message = "You skip your turn!";
			PauseTransition p3 = SceneManager.getGameOperation().animation(Constants.ANIMATION_TIME_TURN, SceneManager.getStackGame(), null, null);
			PauseTransition p2 = SceneManager.getGameOperation().animation(Constants.ANIMATION_TIME_RATING, SceneManager.getStackTransititionAnimation(), message, p3);
			PauseTransition p1 = SceneManager.getGameOperation().animation(Constants.ANIMATION_TIME_TURN, SceneManager.getStackTransititionAnimation(), "It's "+ GameOperation.getPlayerTurn().getName() +"'s turn!", p2);
			p1.play();
			
			//show next turn
			SceneManager.getGameOperation().turnRating(false);
			break;
			
		case 3 :
			break;
			
		case 4 :
			break;
			
		}
	}
}
