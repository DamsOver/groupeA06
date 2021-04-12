package model;

import java.util.Random;
import application.SceneManager;
import javafx.animation.Animation;
import javafx.animation.Transition;
import util.Constants;

public class BasicSpecialCard extends SpecialCard{
	@Override
	public void action() {
		int randomNumber = new Random().nextInt(2) + 1;
		Transition p1=null,p2,p3;
		Animation[] a = null,temp=null;
		String message = "";
		int backwards,squares;
		
		
		switch(randomNumber) {//randomNumber
		//switch(3) {//randomNumber
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
					SceneManager.getGameOperation().getPlayerTurn().getSquare(),
					SceneManager.getGameOperation().getPlayerTurn());
			a = new Animation[temp.length+2];
			a[0]=p1;
			a[1]=p2;
			
			for(int i=0;i<temp.length;i++) {
				a[i+2]=temp[i];
			}
			
			SceneManager.getGameOperation().getGame().turnUp();
			//show next turn
			SceneManager.getGameOperation().turnRating(false,a);
			break;
		case 2 :	
			//skip your next turn
			message = "SPECIAL CARD!\nYou skip your turn!";
			p3 = SceneManager.getGameOperation().animation(Constants.ANIMATION_TIME_TURN,SceneManager.getStackGame(), null);
			p2 = SceneManager.getGameOperation().animation(Constants.ANIMATION_TIME_MESSAGE, SceneManager.getStackTransititionAnimation(), message);
			p1 = SceneManager.getGameOperation().animation(Constants.ANIMATION_TIME_TURN, SceneManager.getStackTransititionAnimation(), "It's "+ SceneManager.getGameOperation().getPlayerTurn().getName() +"'s turn!");
			a = new Animation[3];
			a[0]=p1;
			a[1]=p2;
			a[2]=p3;
			
			//show next turn
			SceneManager.getGameOperation().getGame().turnUp();
			SceneManager.getGameOperation().turnRating(false,a);
			break;
			
		case 3 :
			//switch square
			int randomPlayerIndex;
			Player playerA = SceneManager.getGameOperation().getPlayerTurn(),playerB;
			do {
				randomPlayerIndex= new Random().nextInt(SceneManager.getGameOperation().getGame().getPlayers().size());
			}while(randomPlayerIndex == SceneManager.getGameOperation().getGame().getPlayers().indexOf(playerA));
			
			playerB= SceneManager.getGameOperation().getGame().getPlayers().get(randomPlayerIndex);
			
			
			message = "SPECIAL CARD!\nYou and "+playerB.getName()+"\nswitch squares!";

			Animation[] anim= playerA.switchSquares(playerB);
			p3 = SceneManager.getGameOperation().animation(Constants.ANIMATION_TIME_TURN,SceneManager.getStackGame(), null);
			p2 = SceneManager.getGameOperation().animation(Constants.ANIMATION_TIME_MESSAGE, SceneManager.getStackTransititionAnimation(), message);
			p1 = SceneManager.getGameOperation().animation(Constants.ANIMATION_TIME_TURN, SceneManager.getStackTransititionAnimation(), "It's "+ SceneManager.getGameOperation().getPlayerTurn().getName() +"'s turn!");
			a = new Animation[6];
			a[0]=p1;
			a[1]=p2;
			a[2]=p3;
			a[3]=anim[0];
			a[4]=anim[1];
			a[5]=anim[2];
			
			//show next turn
			SceneManager.getGameOperation().getGame().turnUp();
			SceneManager.getGameOperation().turnRating(false,a);
			break;
			
		case 4 :
			break;
			
		}
	}	
}
