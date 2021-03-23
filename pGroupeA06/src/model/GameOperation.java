package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import application.SceneManager;
import enumerations.CharAnswerRemoval;
import enumerations.Theme;
import exceptions.AlreadyPresentException;
import exceptions.NotPresentException;
import exceptions.TooLittleException;
import javafx.animation.Animation;
import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Transition;
import javafx.animation.TranslateTransition;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import util.Constants;
import util.StringUtils;

public class GameOperation {
	private static Game game;
	private BasicCard bc;
	private Deck oldCards;
	private MediaPlayer mediaPlayerCorrect;
	private MediaPlayer mediaPlayerInCorrect;

	public GameOperation() {
		mediaPlayerCorrect = new MediaPlayer(
				new Media(ClassLoader.getSystemResource("musics/CorrectAnswer.wav").toExternalForm()));
		mediaPlayerCorrect.setVolume(0.4);
		mediaPlayerCorrect.setStartTime(Duration.seconds(0));
		mediaPlayerCorrect.setStopTime(Duration.seconds(2));

		mediaPlayerInCorrect = new MediaPlayer(
				new Media(ClassLoader.getSystemResource("musics/InCorrectAnswer.wav").toExternalForm()));
		mediaPlayerInCorrect.setVolume(1);
		mediaPlayerInCorrect.setStartTime(Duration.seconds(0));
		mediaPlayerInCorrect.setStopTime(Duration.seconds(2));

		this.game = new Game();
		oldCards = new Deck();

	}

	public static void addPlayers(List<String> playerNames) {
		// adding the players to the list of players from the Game Class
		int i = 0;
		for (String s : playerNames) {
			try {
				game.addPlayer(s, i);
			} catch (AlreadyPresentException e) {
				e.printStackTrace();
			}
			i++;
		}
	}

	public void turnRating(boolean first,Animation[] transitions) {
		
		// getting the current turn
		int turn = game.getTurn();

		// getting the player that will play the turn
		Player p = getPlayerTurn();

		if (first) {
			StartCard sc = new StartCard();
			sc.action();
			Transition p2 = SceneManager.getGameOperation().animationTurn(null);
			Transition p1 = SceneManager.getGameOperation().animation(Constants.ANIMATION_TIME_START,
					SceneManager.getStackGame(), null);
			SceneManager.getTransitionAnimation().setTxtAnimation("The game starts!");
			SceneManager.getSceneRoot().setRoot(SceneManager.getStackTransititionAnimation());

			SequentialTransition initialTransition = new SequentialTransition(p1,p2);
			initialTransition.play();
			
		} else {
			// verify if it's a special theme
			switch (p.getSquare().getTheme()) {
			case START:
				StartCard sc = new StartCard();
				sc.action();
				animationTurn(transitions).play();
				break;
			case FINISH:
				FinishCard fc = new FinishCard();
				fc.action();
				animationTurn(transitions).play();
				break;
			case SPECIAL:
				BasicSpecialCard bsc = new BasicSpecialCard();
				bsc.action();
				break;
			default:
				//on recoit la transition précédente
				//on appelle une fct qui va jouer toute la transition
				
				
				// drawing a card
				bc = drawCard(p.getSquare().getTheme());

				// change the ratingAP labels
				SceneManager.getRating().setLbSubject(bc.getSubject());
				SceneManager.getRating().setLbTheme(bc.getTheme());
				animationTurn(transitions).play();
				break;
			}
		}
	}

	public void turnQuestion() {

		// getting the rating
		int rating = SceneManager.getRating().getRating();

		// getting the question
		Question q = bc.getQuestions().get(rating - 1);

		// setting the question
		setQuestion(q);

	}

	public void setQuestion(Question q) {
		// QUESTION SIZE?????
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

		Question newQuestion = new Question(bc.getAuthor(), bc.getTheme(), bc.getSubject(), str.toString(),
				q.getAnswer());

		// setting the player's name
		SceneManager.getQuestion().setLbTurn(SceneManager.getGameOperation().getPlayerTurn().getName());

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

	public void answerVerification() {
		
		Animation[] tab = null;
		Animation[] tempTab = null;
		// getting the rating
		int rating = SceneManager.getRating().getRating();

		// getting the current turn
		int turn = game.getTurn();

		// getting the player that will play the turn
		Player p = getPlayerTurn();

		// verification of the answer
		if (questionVerificationAlgorithm()) {
			// the answer was correct

			mediaPlayerCorrect.play();
			mediaPlayerCorrect.seek(Duration.ZERO);
			// enabling only the Green question mark
			SceneManager.getQuestion().enableQuestionMark(3);
			
			tempTab=game.movePlayer(rating, p.getSquare(), p);
			tab = new Animation[tempTab.length+1];
			tab[0]=SceneManager.getGameOperation().animation(Constants.ANIMATION_TIME_ANSWER,
					SceneManager.getStackQuestion(), null);
			for(int i = 0;i<tempTab.length;i++) {
				tab[i+1]=tempTab[i];
			}
			
			/*
			 * //if the player is further than the last card of the board :
			 * if(game.movePlayer(rating,p.getSquare())==null) {
			 * System.out.println("player " + p.getName() + " wins!"); } //the player moves
			 * //need an implementation of the movement
			 */
		} else {
			// the anwser was wrong

			mediaPlayerInCorrect.play();
			mediaPlayerInCorrect.seek(Duration.ZERO);
			// enabling only the Red question mark
			SceneManager.getQuestion().enableQuestionMark(2);
			// disabling the answer
			SceneManager.getQuestion().enableLbAnswer(true);
			tab = new Animation[1];
			tab[0]=SceneManager.getGameOperation().animation(Constants.ANIMATION_TIME_ANSWER,
					SceneManager.getStackQuestion(), null);
		}

		// next turn
		game.turnUp();

		// add the card to the old deck
		try {
			oldCards.addBasicCard(bc);
		} catch (AlreadyPresentException e) {
			e.printStackTrace();
		}

		// animation nextTurn
		turnRating(false,tab);
	}

	public boolean questionVerificationAlgorithm() {
		int rating = SceneManager.getRating().getRating();
		Question q = bc.getQuestions().get(rating - 1);
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

	public SequentialTransition animationTurn(Animation[] before) {
		//first, player before moves
		//then, message it's player's turn
		//then turn rating or .. depends on the square
		Animation[] tab = new Animation[(before==null)?3:before.length+3];
		Animation[] tabTemp = new Animation[3];
		
		SceneManager.getRating().setLbTurn(GameOperation.getPlayerTurn().getName());
		tabTemp[2]= SceneManager.getGameOperation().animation(Constants.ANIMATION_TIME_RATING,
				SceneManager.getStackRating(), null);
		tabTemp[1] = SceneManager.getGameOperation().animation(Constants.ANIMATION_TIME_TURN,
				SceneManager.getStackTransititionAnimation(),
				"It's " + GameOperation.getPlayerTurn().getName() + "'s turn!");
		tabTemp[0] = SceneManager.getGameOperation().animation(Constants.ANIMATION_TIME_START,
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

	public Transition LastTurn() {
		SceneManager.getRating().setLbTurn(GameOperation.getPlayerTurn().getName());
		Transition pause3 = SceneManager.getGameOperation().animation(Constants.ANIMATION_TIME_RATING,
				SceneManager.getStackQuestion(), null);
		Transition pause2 = SceneManager.getGameOperation().animation(Constants.ANIMATION_TIME_TURN,
				SceneManager.getStackTransititionAnimation(),
				"Last Turn for " + GameOperation.getPlayerTurn().getName() + "!");
		Transition pause1 = SceneManager.getGameOperation().animation(Constants.ANIMATION_TIME_START,
				SceneManager.getStackGame(), null);
		return pause1;
	}

	public BasicCard drawCard(Theme th) {
		boolean alreadyPresent = false;
		bc = null;
		ArrayList<BasicCard> potentialCards = new ArrayList<BasicCard>();
		// check if there is a card that has the same theme than the square

		for (BasicCard b : game.getDeck().getBasicCards()) {
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
			bc = potentialCards.get(randomNumber);
		}
		return bc;
	}

	public BasicCard getBasicCard() {
		return bc.clone();
	}

	public static Player getPlayerTurn() {
		return game.getPlayers().get(game.getTurn() % game.getPlayers().size());
	}

	// begin from the last animation
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

	public static Game getGame() {
		return game.clone();
	}
}