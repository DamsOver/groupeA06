package model;

import java.util.ArrayList;
import java.util.List;

import application.SceneManager;
import enumerations.CharAnswerRemoval;
import exceptions.AlreadyPresentException;
import javafx.animation.PauseTransition;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import util.Constants;

public class GameOperation {
	private static Game game;
	private BasicCard bc;
	private ArrayList<BasicCard> oldCards;
	
	public GameOperation() {
		this.game= new Game();
		oldCards = new ArrayList<BasicCard>();
	}
	
	public static void addPlayers(List<String> playerNames) {
		//adding the players to the list of players from the Game Class
		int i = 0;
		for(String s : playerNames) {
			try {
				game.addPlayer(s, i);
			} catch (AlreadyPresentException e) {
				e.printStackTrace();
			}
			i++;
		}
	}
	
	
	public void turnRating(boolean first) {
		
		//getting the current turn
		int turn = game.getTurn();
		
		//getting the player that will play the turn
		Player p = getPlayerTurn();
		
		//drawing a card
		bc = drawCard(p.getSquare());
		
		//change the ratingAP labels
		SceneManager.getRating().setLbSubject(bc.getSubject());
		SceneManager.getRating().setLbTheme(bc.getTheme());
		
		//displaying animations
		if(first) {
			//first turn
			PauseTransition p2= SceneManager.getGameOperation().animationTurn();
    		PauseTransition pause1 = SceneManager.getGameOperation().animation(Constants.ANIMATION_TIME_START,SceneManager.getStackGame(),null,p2);	  
    		SceneManager.getTransitionAnimation().setTxtAnimation("The game starts!");
            SceneManager.getSceneRoot().setRoot(SceneManager.getStackTransititionAnimation());
    		pause1.play();
		}
		else {
			//not the first turn
			animationTurn().play();
		}
	}
	
	
	public void turnQuestion() 	{
		
		//getting the rating 
		int rating = SceneManager.getRating().getRating();	

		//getting the question
		Question q = bc.getQuestions().get(rating-1);
		
		//setting the player's name
		SceneManager.getQuestion().setLbTurn(SceneManager.getGameOperation().getPlayerTurn().getName());
		
		//setting the question to the QuestionsAP
		SceneManager.getQuestion().setLbQuestion(q);
		
		//setting the answer to the QuestionAP
		SceneManager.getQuestion().setLbAnswer(q);
		
		//enabling the ok button
		SceneManager.getQuestion().enableBtnOK(true);
		
		//disabling the answer
		SceneManager.getQuestion().enableLbAnswer(false);
		
		//enabling only the white question mark
		SceneManager.getQuestion().enableQuestionMark(1);
		
		//setting the StackQuestion
		SceneManager.getSceneRoot().setRoot(SceneManager.getStackQuestion());
		SceneManager.getQuestion().goTimer();
	}
	
	public void answerVerification() {
		//getting the rating 
		int rating = SceneManager.getRating().getRating();	
		
		//getting the current turn
		int turn = game.getTurn();
		
		//getting the player that will play the turn
		Player p = getPlayerTurn();
		
		//verification of the answer
		if(questionVerificationAlgorithm()) {
			//the answer was correct
			
			//enabling only the Green question mark
			SceneManager.getQuestion().enableQuestionMark(3);
			
			
			
			//the player moves 
			//need an implementation of the movement
			p.going(game.movePlayer(rating,p.getSquare()));
			
		}
		else {
			//the anwser was wrong
			//enabling only the Red question mark
			SceneManager.getQuestion().enableQuestionMark(2);
			//disabling the answer
			SceneManager.getQuestion().enableLbAnswer(true);
		}
		
		//next turn
		game.turnUp();
		
		//add the card to the old deck
		oldCards.add(bc);
		
		
		//animation nextTurn
		turnRating(false);
	}
	
	public boolean questionVerificationAlgorithm() {
		int rating = SceneManager.getRating().getRating();	
		Question q = bc.getQuestions().get(rating-1);
		String answer = q.getAnswer();
		String playerAnswer = SceneManager.getQuestion().getAnswer();
		boolean modification = true,integer1 = true , integer2 = true;
		
		
		//lowercase
		answer=answer.toLowerCase();
		playerAnswer = playerAnswer.toLowerCase();
		
		//the, a, an, and , in  suppression
		while(modification) {
			modification = false;
			
			//parcouring the list of words to remove
			for(String c : CharAnswerRemoval.getChar()) {
				
				//answer
				//If its the first word
				while(answer.contains(c+" ")&&answer.substring(0,c.length()).equals(c)) {
					StringBuffer sb = new StringBuffer(answer);
					answer=sb.replace(0,c.length()+1,"").toString();
					modification = true;
				}
				//if the word is in the answer
				while(answer.contains(" "+c+" ")) {
					int index = answer.indexOf(" "+c+" ");
					StringBuffer sb = new StringBuffer(answer);
					answer=sb.replace(index,index + c.length()+1,"").toString();
					modification = true;
				}
			
				//playerAnswer
				while((playerAnswer.contains(c+" ")&&playerAnswer.substring(0,c.length()).equals(c))) {
					StringBuffer sb = new StringBuffer(playerAnswer);
					playerAnswer=sb.replace(0,c.length()+1,"").toString();
					modification = true;
				}
				//if the word is in the PlayerAnswer
				while(playerAnswer.contains(" "+c+" ")) {
					int index = playerAnswer.indexOf(" "+c+" ");
					StringBuffer sb = new StringBuffer(playerAnswer);
					playerAnswer=sb.replace(index,index + c.length()+1,"").toString();
					modification = true;
				}
			}
		}
		
		while(answer.contains(" ")) {
			int index = answer.indexOf(" ");
			StringBuffer sb = new StringBuffer(answer);
			answer=sb.replace(index,index +1,"").toString();
		}
		
		//removing spaces
		while(playerAnswer.contains(" ")) {
			int index = playerAnswer.indexOf(" ");
			StringBuffer sb = new StringBuffer(playerAnswer);
			playerAnswer=sb.replace(index,index +1,"").toString();
		}
		
		//removing slashs
		while(playerAnswer.contains("/")) {
			int index = playerAnswer.indexOf("/");
			StringBuffer sb = new StringBuffer(playerAnswer);
			playerAnswer=sb.replace(index,index +1,"").toString();
		}
		
		//verifying if it's a number
		for(int i = 0;i<playerAnswer.length();i++) {
			if(Character.isDigit(playerAnswer.charAt(i))||playerAnswer.charAt(i)=='.'||playerAnswer.charAt(i)==','){}
			else {
				integer1=false;
			}
		}
		for(int i = 0;i<answer.length();i++) {
			if(Character.isDigit(answer.charAt(i))||answer.charAt(i)=='.'||answer.charAt(i)==','){}
			else {
				integer2=false;
			}
		}
		
		//if both of them are integers
		if(integer1&&integer2) {
			
			//replacing ,
			while(playerAnswer.contains(",")) {
				int index = playerAnswer.indexOf(",");
				StringBuffer sb = new StringBuffer(playerAnswer);
				playerAnswer=sb.replace(index,index +1,".").toString();
			}
			while(answer.contains(",")) {
				int index = answer.indexOf(",");
				StringBuffer sb = new StringBuffer(answer);
				answer=sb.replace(index,index +1,".").toString();
			}
			
			
			double a = Double.valueOf(answer);
			double pa = Double.valueOf(playerAnswer);
			double errorMax= Constants.NUMBER_PERCENTAGE_ERROR_ANSWER*0.01*a;
			
			if(((a+errorMax)>pa)&&((a-errorMax)<pa)) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			//same size
			if(answer.length()>playerAnswer.length()) {
				for(int i=0;i<answer.length()-playerAnswer.length();i++) {
					playerAnswer=playerAnswer+" ";
				}
			}
			if(answer.length()<playerAnswer.length()) {
				for(int i=0;i<playerAnswer.length()-answer.length();i++) {
					answer=answer+" ";
				}
			}
			
			System.out.println(playerAnswer.length());
			System.out.println(answer.length());
			
			//error margin
			int errorSize= (int)(Constants.STRING_PERCENTAGE_ERROR_ANSWER*playerAnswer.length()*0.01)+1;
			int actualError = 0;
			
			//verifying the strings
			for(int i = 0;i<answer.length();i++) {
				if(answer.charAt(i)!=playerAnswer.charAt(i)){
					actualError++;
				}
			}
			
			if(errorSize>=actualError) {
				return true;
			}
			else {
				return false;
			}
		}
	}
	
	
	public PauseTransition animationTurn() {
		
		SceneManager.getRating().setLbTurn(SceneManager.getGameOperation().getPlayerTurn().getName());
		PauseTransition pause3 = SceneManager.getGameOperation().animation(Constants.ANIMATION_TIME_RATING,SceneManager.getStackRating(),null,null);
		PauseTransition pause2 = SceneManager.getGameOperation().animation(Constants.ANIMATION_TIME_TURN,SceneManager.getStackTransititionAnimation(),
				"It's "+ SceneManager.getGameOperation().getPlayerTurn().getName() +"'s turn!",pause3);
		
		return pause2;
	}
	
	public BasicCard drawCard(Square sq) {
		boolean alreadyPresent = false;
		//check if there is a card that has the same theme than the square
		for(BasicCard b :game.getDeck().getBasicCards() ) {
			if (b.getTheme().equals(sq.getTheme())){
				//check if the card was not already used in this game
				alreadyPresent = false;
				for(BasicCard b2 : oldCards) {
					if(b2.equals(b)) {
						alreadyPresent =true;
					}
				}
				if(!alreadyPresent) {
					return b;
				}
			}	
		}
		if(bc==null) {
				System.out.println("no more questions");
				Deck q = new Deck();
				bc=q.getBasicCards().get(0);
			}
		return bc;
	}
	
	public BasicCard getBasicCard() {
		return bc.clone();
	}
	
	
	public Player getPlayerTurn() {
		return game.getPlayers().get(game.getTurn()%game.getPlayers().size());
	}
	
	//begin from the last animation
	public PauseTransition animation(Integer pauses, Pane scene, String txtAnimation, PauseTransition pt) {
		
		PauseTransition pauseTransition = new PauseTransition(Duration.millis(pauses));
		pauseTransition.setOnFinished(
                e -> {	 
                		//If it is a transitionAnimation, we have to set a new text to him, contained in txtAnimation
                		if(scene==SceneManager.getStackTransititionAnimation()) {
                			SceneManager.getTransitionAnimation().setTxtAnimation(txtAnimation);
                		}
                		SceneManager.getSceneRoot().setRoot(scene);
	                	if(pt!=null) {
	                		pt.play();
	            		}
                	}              
                );
		return pauseTransition;
	}
	
	public static Game getGame() {
		return game.clone();
	}
}
