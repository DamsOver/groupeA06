package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import application.SceneManager;
import enumerations.CharAnswerRemoval;
import enumerations.PlayerColors;
import enumerations.Theme;
import exceptions.AlreadyPresentException;
import exceptions.NotPresentException;
import exceptions.TooLittleException;
import javafx.animation.Animation;
import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Transition;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import util.Constants;
import util.StringUtils;


/**
 * A representation of a game.
 * This class was initially intended to be saved in a Json file and used to save the progression of the game
 * This class is in charge of the players, the deck, the board, and of the animations.
 * @author Martin
 * */
public class Game {
	
	
	/**The list of the Player */
	private List<Player> players;
	
	/**The board used in the Game*/
	private Board board;
	
	/**The integer indicating the turn of the game*/
	private int turn;
	
	/**The Deck used in the Game*/
	private Deck deck;
	
	/**The current Card used to set the questions */
	private BasicCard currentBC;
	
	/**The deck containing all the used cards*/
	private Deck oldCards;
	

	/** Constructor of a Game*/
	public Game() {
		board = new Board().fromJson();
		this.players = new ArrayList<Player>();
		this.turn = 0;
		this.deck = new Deck().fromJson();
		oldCards = new Deck();
	}

	/**
	 * Adds a Player to the list of players
	 * @param name		The name of the Player
	 * @param number 	The number of the Player
	 * @throws AlreadyPresentException error if the player is already present
	 * @return true if the Player has been successfully added to the list of questions
	 * */
	public boolean addPlayer(String name, int number) throws AlreadyPresentException {
		if (number < 0 || number > 7) {
			return false;
		} else {
			if (players.size() == 0) {
				players.add(new Player(name, number));
				return true;
			} else {
				// scanning the list of players to check if the color has already been
				// attributed
				for (Player p : players) {
					if (p.getColor().equals(PlayerColors.getColor(number))) {
						throw new AlreadyPresentException(2.0);
					}
				}
				players.add(new Player(name, number));
				return true;
			}
		}
		
	}

	/** Adds the players to the list of players from the Class Game
	 * @param playerNames 	The List of the names*/
	public void addPlayers(List<String> playerNames) {
		
		int i = 0;
		for (String s : playerNames) {
			try {
				this.addPlayer(s, i);
			} catch (AlreadyPresentException e) {
				e.printStackTrace();
			}
			i++;
		}
	}
	
	
	/**
	 * Calls the setSquare method from Player, which returns an animation of the player movement
	 * @param next The number of square you need to move
	 * @param p 	The Player that need to move
	 * @return A table containing the Animation of the movement of the player*/
	public Animation[] movePlayer(int next, Player p) {

		int tmp;
		int indexPlayer = players.indexOf(p);
		int playerSquare=board.getSquares().indexOf(p.getSquare());
		
		tmp = playerSquare + next;
		
		if(tmp>=board.getSquares().size()) {
			tmp=board.getSquares().size()-1;
		}
		
		return p.setSquare(board.getSquares().get(tmp), indexPlayer, board.getSquares().get(playerSquare));
	}

	/**
	 * returns the Board
	 * @return the Board of the game
	 * */
	public Board getBoard() {
		return this.board;
	}

	/**Add 1 to the turn of the game*/
	public void turnUp() {
		this.turn++;
	}

	/**
	 * returns the Deck
	 * @return the Deck of the Game*/
	public Deck getDeck() {
		// not cloned to be able to remove the used cards
		return deck.clone();
	}

	/**
	 * returns the turn
	 * @return the current Turn*/
	public int getTurn() {
		return this.turn;
	}

	/**
	 * Returns a Game with the fields having the exact same value as this Game.
	 * @return a Game Cloned
	 * */
	public Game clone() {
		Game g = new Game();
		for (Player p : players) {
			g.getPlayers().add(p.clone());
		}
		g.turn = this.turn;
		g.deck = this.deck.clone();
		return g;
	}

	/**
	 * return a new List containing Player's clones
	 * @return the list of Players*/
	public List<Player> getPlayers() {
		List<Player> p = new ArrayList<Player>();
		for (Player pl : players) {
			p.add(pl);
		}
		return p;
	}
	
	/**
	 * sets the visibility of the players playing the game to true*/
	public void setPlayerVisible() {
		for(int i = Constants.NB_PLAYER-1; i>=players.size();i--) {
			SceneManager.getGame().getListImageView().get(i).setVisible(false);
		}
	}
	
	/** Decides what animation to play and what action to make depending on the square and the first turn
	 * @param first 		True if it's the first turn
	 * @param transitions 	The table of previous Animations*/
	public void turnRating(boolean first,Animation[] transitions) {

		// getting the player that will play the turn
		Player p = getPlayerTurn();

		if (first) {
			
			Transition p1 = SceneManager.getCurrentGame().animation(Constants.ANIMATION_TIME_START,SceneManager.getStackGame(), null);
			SceneManager.getTransitionAnimation().setTxtAnimation("The game starts!");
			SceneManager.getSceneRoot().setRoot(SceneManager.getStackTransititionAnimation());
			transitions = new Animation[1];
			transitions[0]=p1;
			
			SpecialCard sc = new StartCard();
			sc.action(transitions);
			
		} else {
			// verify if it's a special theme
			switch (p.getSquare().getTheme()) {
			
			case START:
				SpecialCard sc = new StartCard();
				sc.action(transitions);
				break;
				
			case FINISH:
				SpecialCard fc = new FinishCard();
				fc.action(transitions);
				break;
				
			case SPECIAL:
				SpecialCard bsc = new BasicSpecialCard();
				bsc.action(transitions);
				break;
				
			default:	
				
				// drawing a card
				currentBC = drawCard(p.getSquare().getTheme());

				// change the ratingAP labels
				SceneManager.getRating().setLbSubject(currentBC.getSubject());
				SceneManager.getRating().setLbTheme(currentBC.getTheme());
				animationTurn(transitions).play();
				break;
			}
		}
	}
	
	/**
	 * Sets the question and the answer and enable the ok button
	 * */
	public void turnQuestion() {

		// getting the rating
		int rating = SceneManager.getRating().getRating();

		// getting the question
		Question q = currentBC.getQuestions().get(rating - 1);

		// setting the question
		setQuestion(q);
		SceneManager.getQuestion().getBtnOK().setDisable(false);;

	}

	/**sets the question and the answer to the QuestionView
	 * @param q	The question to set*/
	public void setQuestion(Question q) {
		
		String question = q.getChallenge();
		StringBuffer str = new StringBuffer();

		List<String> strings = new ArrayList<String>();
		int index = 0;
		while (index < q.getChallenge().length()) {
			strings.add(question.substring(index, Math.min(index + Constants.SIZE_MAX_QUESTION, question.length())));
			index += Constants.SIZE_MAX_QUESTION;
		}

		for (String s : strings) {
			str.append(s);
			str.append("\n");
		}

		Question newQuestion = new Question(currentBC.getAuthor(), currentBC.getTheme(), currentBC.getSubject(), str.toString(),
				q.getAnswer());

		// setting the player's name
		SceneManager.getQuestion().setLbTurn(SceneManager.getCurrentGame().getPlayerTurn().getName());

		// setting the question to the QuestionsAP
		SceneManager.getQuestion().setLbQuestion(newQuestion);

		// setting the answer to the QuestionAP
		SceneManager.getQuestion().setLbAnswer(q);

		// enabling the ok button
		SceneManager.getQuestion().enableBtnOK(true);

		// disabling the answer
		SceneManager.getQuestion().enableLbAnswer(false);

		// enabling only the white question mark
		SceneManager.getQuestion().enableQuestionMark(1);

		// setting the StackQuestion
		SceneManager.getSceneRoot().setRoot(SceneManager.getStackQuestion());
		SceneManager.getQuestion().goTimer();
	}

	/**
	 * Checks if the answer of the player was correct and sets animations for the next Turn
	 * */
	public void answerVerification() {
		
		Animation[] tab = null;
		Animation[] tempTab = null;
		// getting the rating
		int rating = SceneManager.getRating().getRating();

		// getting the player that will play the turn
		Player p = getPlayerTurn();
		
		// verification of the answer
		if (questionVerificationAlgorithm(p.getSquare().getTheme()==Theme.FINISH)) {
			
			// the answer was correct

			SceneManager.getMediaPlayerCorrect().play();
			SceneManager.getMediaPlayerCorrect().seek(Duration.ZERO);

			// enabling only the Green question mark
			SceneManager.getQuestion().enableQuestionMark(3);
			
			if(p.getSquare().getTheme()==Theme.FINISH){
				lastTurn().play();
				SceneManager.newGame();
				return;
			}
			else {
				tempTab=this.movePlayer(rating, p);
				tab = new Animation[tempTab.length+1];
				tab[0]=SceneManager.getCurrentGame().animation(Constants.ANIMATION_TIME_ANSWER,
						SceneManager.getStackQuestion(), null);
				for(int i = 0;i<tempTab.length;i++) {
					tab[i+1]=tempTab[i];
				}
			}
			
		} else {
			// the anwser was wrong

			SceneManager.getMediaPlayerInCorrect().play();
			SceneManager.getMediaPlayerInCorrect().seek(Duration.ZERO);
			// enabling only the Red question mark
			SceneManager.getQuestion().enableQuestionMark(2);
			// disabling the answer
			SceneManager.getQuestion().enableLbAnswer(true);
			tab = new Animation[1];
			tab[0]=SceneManager.getCurrentGame().animation(Constants.ANIMATION_TIME_ANSWER,
					SceneManager.getStackQuestion(), null);
		}

		// next turn
		this.turnUp();

		// add the card to the old deck
		try {
			oldCards.addBasicCard(currentBC);
		} catch (AlreadyPresentException e) {
			e.printStackTrace();
		}
		// animation nextTurn
		turnRating(false,tab);
	}

	/** Checks the difference between the answer of the player and the real answer. A small percentage of error is admitted
	 * @param last If it's true, the last Question of the BasicCard if the one that was asked
	 * @return True if there's no significant difference*/
	public boolean questionVerificationAlgorithm(boolean last) {
		int rating = (last)?4:SceneManager.getRating().getRating();
		Question q = currentBC.getQuestions().get(rating - 1);
		String answer = (q.getAnswer() != null) ? q.getAnswer() : "";
		String playerAnswer = (SceneManager.getQuestion().getAnswer() != null) ? SceneManager.getQuestion().getAnswer()
				: "";
		boolean modification = true, integer1 = true, integer2 = true;

		// lowercase
		answer = answer.toLowerCase();
		playerAnswer = playerAnswer.toLowerCase();
		
		// the, a, an, and , in suppression
		while (modification) {
			modification = false;

			// parcouring the list of words to remove
			for (String c : CharAnswerRemoval.getChar()) {

				// answer
				// If its the first word
				while (answer.contains(c + " ") && answer.substring(0, c.length()).equals(c)) {
					StringBuffer sb = new StringBuffer(answer);
					answer = sb.replace(0, c.length() + 1, "").toString();
					modification = true;
				}
				// if the word is in the answer
				while (answer.contains(" " + c + " ")) {
					int index = answer.indexOf(" " + c + " ");
					StringBuffer sb = new StringBuffer(answer);
					answer = sb.replace(index, index + c.length() + 1, "").toString();
					modification = true;
				}

				// playerAnswer
				while ((playerAnswer.contains(c + " ") && playerAnswer.substring(0, c.length()).equals(c))) {
					StringBuffer sb = new StringBuffer(playerAnswer);
					playerAnswer = sb.replace(0, c.length() + 1, "").toString();
					modification = true;
				}
				// if the word is in the PlayerAnswer
				while (playerAnswer.contains(" " + c + " ")) {
					int index = playerAnswer.indexOf(" " + c + " ");
					StringBuffer sb = new StringBuffer(playerAnswer);
					playerAnswer = sb.replace(index, index + c.length() + 1, "").toString();
					modification = true;
				}
			}
		}

		// removing spaces
		while (answer.contains(" ")) {
			int index = answer.indexOf(" ");
			StringBuffer sb = new StringBuffer(answer);
			answer = sb.replace(index, index + 1, "").toString();
		}
		while (playerAnswer.contains(" ")) {
			int index = playerAnswer.indexOf(" ");
			StringBuffer sb = new StringBuffer(playerAnswer);
			playerAnswer = sb.replace(index, index + 1, "").toString();
		}

		// removing slashs
		while (playerAnswer.contains("/")) {
			int index = playerAnswer.indexOf("/");
			StringBuffer sb = new StringBuffer(playerAnswer);
			playerAnswer = sb.replace(index, index + 1, "").toString();
		}
		
		while (answer.contains("/")) {
			int index = answer.indexOf("/");
			StringBuffer sb = new StringBuffer(answer);
			answer = sb.replace(index, index + 1, "").toString();
		}
		
		if (playerAnswer.equals("")) {
			return false;
		}

		// verifying if it's a number
		for (int i = 0; i < playerAnswer.length(); i++) {
			if (Character.isDigit(playerAnswer.charAt(i)) || playerAnswer.charAt(i) == '.'
					|| playerAnswer.charAt(i) == ',') {
			} else {
				integer1 = false;
			}
		}
		for (int i = 0; i < answer.length(); i++) {
			if (Character.isDigit(answer.charAt(i)) || answer.charAt(i) == '.' || answer.charAt(i) == ',') {
			} else {
				integer2 = false;
			}
		}

		// if both of them are integers
		if (integer1 && integer2) {

			// replacing ','
			while (playerAnswer.contains(",")) {
				int index = playerAnswer.indexOf(",");
				StringBuffer sb = new StringBuffer(playerAnswer);
				playerAnswer = sb.replace(index, index + 1, ".").toString();
			}
			while (answer.contains(",")) {
				int index = answer.indexOf(",");
				StringBuffer sb = new StringBuffer(answer);
				answer = sb.replace(index, index + 1, ".").toString();
			}

			double a = Double.valueOf(answer);
			double pa = Double.valueOf(playerAnswer);
			double errorMax = Constants.NUMBER_PERCENTAGE_ERROR_ANSWER * 0.01 * a;

			if (((a + errorMax) > pa) && ((a - errorMax) < pa)) {
				return true;
			} else {
				return false;
			}
		} else {
			// same size
			if (answer.length() > playerAnswer.length()) {
				for (int i = 0; i <= answer.length() - playerAnswer.length(); i++) {
					playerAnswer = playerAnswer + " ";
				}
			}
			if (answer.length() < playerAnswer.length()) {
				for (int i = 0; i <= playerAnswer.length() - answer.length(); i++) {
					answer = answer + " ";
				}
			}

			// error margin
			int errorSize = (int) (Constants.STRING_PERCENTAGE_ERROR_ANSWER * playerAnswer.length() * 0.01);
			String comparaison = StringUtils.diff(answer, playerAnswer);

			// verifying the strings
			if (errorSize >= comparaison.length()) {
				return true;
			} else {
				return false;
			}
		}
	}
	
	/** Creates an animation for a turn
	 * @param before 	The animations that needs to be played before the one this method adds
	 * @return A table containing SequentialTransitions of the whole turn*/
	public SequentialTransition animationTurn(Animation[] before) {
		//first, player before moves
		//then, message it's player's turn
		//then turn rating or .. depends on the square
		Animation[] tab = new Animation[(before==null)?3:before.length+3];
		Animation[] tabTemp = new Animation[3];
		
		SceneManager.getRating().setLbTurn(this.getPlayerTurn().getName());
		tabTemp[2]= SceneManager.getCurrentGame().animation(Constants.ANIMATION_TIME_RATING,
				SceneManager.getStackRating(), null);
		tabTemp[1] = SceneManager.getCurrentGame().animation(Constants.ANIMATION_TIME_TURN,
				SceneManager.getStackTransititionAnimation(),
				"It's " + this.getPlayerTurn().getName() + "'s turn!");
		tabTemp[0] = SceneManager.getCurrentGame().animation(Constants.ANIMATION_TIME_START,
				SceneManager.getStackGame(), null);
		
		
		if(before!=null) {
			for(int i = 0;i<before.length;i++) {
				tab[i]=before[i];
			}
			
			for(int i = before.length;i<before.length+3;i++) {
				tab[i]=tabTemp[i-before.length];
			}
			
			return new SequentialTransition (tab);
		}
		else {
			
			return new SequentialTransition (tabTemp);
		}
	}
	
	/** Creates an animation for the last turn
	 * @return A table containing SequentialTransitions of the whole turn*/
	public SequentialTransition animationLastTurn(Animation[] tempTransitions) {
		Animation[] tab = new Animation[(tempTransitions==null)?4:tempTransitions.length+4];
		Animation[] tabTemp = new Animation[4];
		
		//SceneManager.getSceneRoot().setRoot(SceneManager.getStackGame());
		SceneManager.getRating().setLbTurn(this.getPlayerTurn().getName());
		
		PauseTransition pauseTransition = new PauseTransition(Duration.millis(Constants.ANIMATION_TIME_TURN));
		pauseTransition.setOnFinished(e -> {
			BasicCard tempBasicCard = SceneManager.getCurrentGame().drawCard(Theme.getRandomTheme());
			SceneManager.getCurrentGame().setQuestion(tempBasicCard.getQuestions().get(3));
			SceneManager.getQuestion().getBtnOK().setDisable(false);
			SceneManager.getSceneRoot().setRoot(SceneManager.getStackQuestion());
		});
		
		tabTemp[3]= pauseTransition;
		tabTemp[2] = SceneManager.getCurrentGame().animation(Constants.ANIMATION_TIME_TURN,
				SceneManager.getStackTransititionAnimation(),
				"You have to answer\ncorrectly to this\ndifficult question to win");
		tabTemp[1] = SceneManager.getCurrentGame().animation(Constants.ANIMATION_TIME_TURN,
				SceneManager.getStackTransititionAnimation(),
				"It's " + this.getPlayerTurn().getName() + "'s \nlast turn!");
		tabTemp[0] = SceneManager.getCurrentGame().animation(Constants.ANIMATION_TIME_START,
				SceneManager.getStackGame(), null);
		if(tempTransitions!=null) {
			for(int i = 0;i<tempTransitions.length;i++) {
				tab[i]=tempTransitions[i];
			}
			
			for(int i = tempTransitions.length;i<tempTransitions.length+4;i++) {
				tab[i]=tabTemp[i-tempTransitions.length];
			}
			
			return new SequentialTransition (tab);
		}
		else {
			
			return new SequentialTransition (tabTemp);
		}
	}
	
	/**creates the animations of a player victory
	 * @return The SequentialTransition corresponding to the last animation*/
	public SequentialTransition lastTurn() {
		Animation[] tabTemp = new Animation[2];
		tabTemp[1] = SceneManager.getCurrentGame().animation(Constants.ANIMATION_TIME_TURN,
				SceneManager.getStackRoot(), null);
		tabTemp[0] = SceneManager.getCurrentGame().animation(Constants.ANIMATION_TIME_TURN,
				SceneManager.getStackTransititionAnimation(),
				this.getPlayerTurn().getName() + " won!");

		return new SequentialTransition (tabTemp);
	}

	/**draws a card from the deck and check if it's a correct one
	 * @param th 	The theme that the BasicCard drawed should have
	 * @return The BasicCard drawed*/
	public BasicCard drawCard(Theme th) {
		boolean alreadyPresent = false;
		currentBC = null;
		ArrayList<BasicCard> potentialCards = new ArrayList<BasicCard>();
		// check if there is a card that has the same theme than the square

		for (BasicCard b : this.getDeck().getBasicCards()) {
			if (b.getTheme().equals(th)) {
				// check if the card was not already used in this game
				alreadyPresent = false;
				for (BasicCard b2 : oldCards.getBasicCards()) {
					if (b2.equals(b)) {
						alreadyPresent = true;
					}
				}
				if (!alreadyPresent) {
					potentialCards.add(b);
				}
			}
		}
		if (potentialCards.size() == 0) {
			System.out.println("no more questions");
			// remove all the questions with the same theme in the deck of oldCards
			for (BasicCard b : oldCards.getBasicCards()) {
				if (b.getTheme().equals(th)) {
					try {
						oldCards.removeBasicCard(b);
					} catch (TooLittleException | NotPresentException e) {
						e.printStackTrace();
					}
				}
			}
			return drawCard(th);
		} else {
			int randomNumber = new Random().nextInt(potentialCards.size());
			currentBC = potentialCards.get(randomNumber);
		}
		return currentBC;
	}

	/**
	 * returns the current BasicCard
	 * @return current BasicCard*/
	public BasicCard getBasicCard() {
		return currentBC.clone();
	}

	/**
	 * gets the Player that has to play the turn
	 * @return the player that has to play*/
	public Player getPlayerTurn() {
		return this.getPlayers().get(this.getTurn() % this.getPlayers().size());
	}

	/**Produces a Transition used for all the animations of the turns
	 * @param pauses 	the duration of the pause
	 * @param scene		The next Scene that needs to be shown
	 * @param txtAnimation	The Text to display
	 * @return the animation */
	public Transition animation(Integer pauses, Pane scene, String txtAnimation) {

		PauseTransition pauseTransition = new PauseTransition(Duration.millis(pauses));
		pauseTransition.setOnFinished(e -> {
			// If it is a transitionAnimation, we have to set a new text to him, contained
			// in txtAnimation
			if (scene == SceneManager.getStackTransititionAnimation()) {
				SceneManager.getTransitionAnimation().setTxtAnimation(txtAnimation);
			}
			SceneManager.getSceneRoot().setRoot(scene);
		});
		return pauseTransition;
	}
	
	
	
	
}