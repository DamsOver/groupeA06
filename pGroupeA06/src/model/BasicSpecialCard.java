package model;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import application.SceneManager;
import javafx.animation.Animation;
import javafx.animation.PauseTransition;
import javafx.animation.Transition;
import util.Constants;

public class BasicSpecialCard extends SpecialCard{
	@Override
	public void action() {
		int randomNumber = new Random().nextInt(1) + 1;
		Transition p1=null,p2,p3;
		Animation[] a = null,temp=null;
		String message = "";
		int backwards,squares;
		
		
		switch(1) {//randomNumber
		case 1 :
			//move the player forward or backwards 1,2 or 3 squares on the board
			backwards= new Random().nextInt(2); //2
			squares = new Random().nextInt(2)+1; //3
			
		
			//display the message
			message=(backwards==0)?"SPECIAL CARD!\n You move "+squares+"\nsquares forward!":"SPECIAL CARD!\nYou move "+squares+"\nsquares backwards!";
			p2 = SceneManager.getGameOperation().animation(Constants.ANIMATION_TIME_MESSAGE, SceneManager.getStackTransititionAnimation(), message);
			p1 = SceneManager.getGameOperation().animation(Constants.ANIMATION_TIME_TURN, SceneManager.getStackTransititionAnimation(), "It's "+ GameOperation.getPlayerTurn().getName() +"'s turn!");
			
			squares=(backwards==0)?squares:-squares;
			temp=GameOperation.getGame().movePlayer(squares,
					GameOperation.getPlayerTurn().getSquare(),
					GameOperation.getPlayerTurn());
			a = new Animation[temp.length+2];
			a[0]=p1;
			a[1]=p2;
			
			for(int i=0;i<temp.length;i++) {
				a[i+2]=temp[i];
			}
			
			GameOperation.getGame().turnUp();
			//show next turn
			SceneManager.getGameOperation().turnRating(false,a);
			break;
		case 2 :	
			
			//skip your next turn
			message = "SPECIAL CARD!\nYou skip your turn!";
			p3 = SceneManager.getGameOperation().animation(Constants.ANIMATION_TIME_TURN,SceneManager.getStackGame(), null);
			p2 = SceneManager.getGameOperation().animation(Constants.ANIMATION_TIME_MESSAGE, SceneManager.getStackTransititionAnimation(), message);
			p1 = SceneManager.getGameOperation().animation(Constants.ANIMATION_TIME_TURN, SceneManager.getStackTransititionAnimation(), "It's "+ GameOperation.getPlayerTurn().getName() +"'s turn!");
			a = new Animation[3];
			a[0]=p1;
			a[1]=p2;
			a[2]=p3;
			
			//show next turn
			GameOperation.getGame().turnUp();
			SceneManager.getGameOperation().turnRating(false,a);
			break;
			
		case 3 :
			break;
			
		case 4 :
			break;
			
		}
	}	
}
