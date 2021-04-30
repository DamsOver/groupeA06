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
					//move the player forward or backwards 1,2 or 3 squares on the board
					backwards= new Random().nextInt(2); //2
					squares = new Random().nextInt(2)+1; //3

					//display the message
					message=(backwards==0)?"SPECIAL CARD!\n You move "+squares+"\nsquares forward!":"SPECIAL CARD!\nYou move "+squares+"\nsquares backwards!";
					p2 = message(message, Constants.ANIMATION_TIME_MESSAGE);
					p1 = SceneManager.getCurrentGame().animation(Constants.ANIMATION_TIME_TURN, SceneManager.getStackTransititionAnimation(), "It's "+ SceneManager.getCurrentGame().getPlayerTurn().getName() +"'s turn!");
					
					squares=(backwards==0)?squares:-squares;
					temp=SceneManager.getCurrentGame().movePlayer(squares,
							SceneManager.getCurrentGame().getPlayerTurn());
					a = new Animation[first.length+temp.length+2];
					
					for(int i=0;i<first.length;i++) {
						a[i]=first[i];
					}
					
					a[first.length+0]=p1;
					a[first.length+1]=p2;
					
					for(int i=0;i<temp.length;i++) {
						a[i+2+first.length]=temp[i];
					}
					return a;
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
					
					return a;
				}
		return null;
	}

	@Override
	public void prelude() {
		
	}

	@Override
	public void show(Animation[] a) {
		SceneManager.getCurrentGame().turnUp();
		SceneManager.getCurrentGame().turnRating(false,a);
	}	
}
