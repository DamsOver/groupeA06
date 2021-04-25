package model;

import java.util.Random;
import application.SceneManager;
import javafx.animation.Animation;
import javafx.animation.Transition;
import util.Constants;

/**
 * A Basic SpecialCard, which is not used only once in the board.
 * The type of action depends on a random number
 * @author Martin*/

public class BasicSpecialCard extends SpecialCard{
	
	/**
	 * Chooses an action thanks to a random number and create an animation linked to the action
	 * @param transitions	A table containing the previous animations which needs to be played before the ones this method creates
	 * */
	@Override
	public void action(Animation[] transitions) {
		
		//create a random number between 1 and 2.99999
		int randomNumber = new Random().nextInt(2) + 1;
		Transition p1=null,p2,p3;
		Animation[] a = null,temp=null;
		String message = "";
		int backwards,squares;
		
		
		switch(randomNumber) {
		case 1 :
			//move the player forward or backwards 1,2 or 3 squares on the board
			backwards= new Random().nextInt(2); //2
			squares = new Random().nextInt(2)+1; //3

			//display the message
			message=(backwards==0)?"SPECIAL CARD!\n You move "+squares+"\nsquares forward!":"SPECIAL CARD!\nYou move "+squares+"\nsquares backwards!";
			p2 = SceneManager.getGameOperation().animation(Constants.ANIMATION_TIME_MESSAGE, SceneManager.getStackTransititionAnimation(), message);
			p1 = SceneManager.getGameOperation().animation(Constants.ANIMATION_TIME_TURN, SceneManager.getStackTransititionAnimation(), "It's "+ SceneManager.getGameOperation().getPlayerTurn().getName() +"'s turn!");
			
			squares=(backwards==0)?squares:-squares;
			temp=SceneManager.getGameOperation().getGame().movePlayer(squares,
					SceneManager.getGameOperation().getPlayerTurn());
			a = new Animation[transitions.length+temp.length+2];
			
			for(int i=0;i<transitions.length;i++) {
				a[i]=transitions[i];
			}
			
			a[transitions.length+0]=p1;
			a[transitions.length+1]=p2;
			
			for(int i=0;i<temp.length;i++) {
				a[i+2+transitions.length]=temp[i];
			}
			
			//next turn
			SceneManager.getGameOperation().getGame().turnUp();
			
			//shows next turn
			SceneManager.getGameOperation().turnRating(false,a);
			break;
		case 2 :	
			//skip your next turn
			message = "SPECIAL CARD!\nYou skip your turn!";
			p3 = SceneManager.getGameOperation().animation(Constants.ANIMATION_TIME_TURN,SceneManager.getStackGame(), null);
			p2 = SceneManager.getGameOperation().animation(Constants.ANIMATION_TIME_MESSAGE, SceneManager.getStackTransititionAnimation(), message);
			p1 = SceneManager.getGameOperation().animation(Constants.ANIMATION_TIME_TURN, SceneManager.getStackTransititionAnimation(), "It's "+ SceneManager.getGameOperation().getPlayerTurn().getName() +"'s turn!");
			a = new Animation[transitions.length+3];
			
			for(int i=0;i<transitions.length;i++) {
				a[i]=transitions[i];
			}
			
			a[transitions.length+0]=p1;a[transitions.length+1]=p2;a[transitions.length+2]=p3;
			
			//show next turn
			SceneManager.getGameOperation().getGame().turnUp();
			SceneManager.getGameOperation().turnRating(false,a);
			break;
		}
	}	
}
