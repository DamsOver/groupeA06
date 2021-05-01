package model;

import java.util.Random;
import application.SceneManager;
import javafx.animation.Animation;
import javafx.animation.Transition;
import util.Constants;

/**
 * A Basic SpecialCard, which is not used only in one place on the board.
 * The type of action depends on a random number
 * @author Martin*/
public class BasicSpecialCard extends SpecialCard{
	

	/**
	 *Creates a specific animation for the BasicSpecialCard
	 *@param first the table containing the previous animations needed to be played before the ones the BasicSpecialCard creates
	 *@return The animation created
	 * */
	@Override
	public Animation[] animCard(Animation[] first) {
		
		//create a random number between 1 and 2.99999
		int randomNumber = new Random().nextInt(2) + 1;
		Transition p1=null,p2,p3;
		Animation[] a = null,temp=null;
		String message = "";
		int backwards,squares;
		
		
		switch(randomNumber) {
		case 1 :
			//move the player forward or backwards 1 or 2 squares on the board
			backwards= new Random().nextInt(2); //2
			squares = new Random().nextInt(2)+1; //3

			//display the message
			message=(backwards==0)?"SPECIAL CARD!\n You move "+squares+"\nsquares forward!":"SPECIAL CARD!\nYou move "+squares+"\nsquares backwards!";
			p2 = message(message, Constants.ANIMATION_TIME_MESSAGE);
			p1 = SceneManager.getCurrentGame().animation(Constants.ANIMATION_TIME_TURN, SceneManager.getStackTransititionAnimation(), "It's "+ SceneManager.getCurrentGame().getPlayerTurn().getName() +"'s turn!");
			
			squares=(backwards==0)?squares:-squares;
			
			//get the animation of the player moving
			temp=SceneManager.getCurrentGame().movePlayer(squares,SceneManager.getCurrentGame().getPlayerTurn());
			a = new Animation[first.length+temp.length+2];
			
			//reput the previous animation in the new table
			for(int i=0;i<first.length;i++) {
				a[i]=first[i];
			}
			
			//add the messages
			a[first.length+0]=p1;
			a[first.length+1]=p2;
			
			//add the movement of the player
			for(int i=0;i<temp.length;i++) {
				a[i+2+first.length]=temp[i];
			}
			break;
			
		case 2 :	
			
			//skip your next turn
			message = "SPECIAL CARD!\nYou skip your turn!";
			p3 = SceneManager.getCurrentGame().animation(Constants.ANIMATION_TIME_TURN,SceneManager.getStackGame(), null);
			p2 = message(message, Constants.ANIMATION_TIME_MESSAGE);
			p1 = SceneManager.getCurrentGame().animation(Constants.ANIMATION_TIME_TURN, SceneManager.getStackTransititionAnimation(), "It's "+ SceneManager.getCurrentGame().getPlayerTurn().getName() +"'s turn!");
			a = new Animation[first.length+3];
			
			for(int i=0;i<first.length;i++) {
				a[i]=first[i];
			}
			
			a[first.length+0]=p1;
			a[first.length+1]=p2;
			a[first.length+2]=p3;
			
			break;
		}
		return a;
	}

	/**
	 * No need of an implementation for BasicSpecialCard
	 * */
	@Override
	public void prelude() {
		
	}

	/**
	 * Chooses the way the animation will be send/displayed
	 * @param a table containing the animation created in animCard*/
	@Override
	public void show(Animation[] a) {
		SceneManager.getCurrentGame().turnUp();
		SceneManager.getCurrentGame().turnRating(false,a);
	}	
}
