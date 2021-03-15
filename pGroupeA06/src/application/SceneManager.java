package application;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.Media;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.GameOperation;
import util.Constants;
import vue.AddCardsAP;
import vue.AddPlayersAP;
import vue.AdminAP;
import vue.CardsManagementAP;
import vue.GameAP;
import vue.GameRulesAP;
import vue.HomeAP;
import vue.OptionsAP;
import vue.QuestionAP;
import vue.RatingAP;
import vue.SettingsAP;
import vue.TransitionAnimationAP;

public class SceneManager {
	
	private static Scene sceneRoot; 
	
	private static StackPane 	stackOptions,
								stackRoot,
								stackAddCards,
								stackAdmin,
								stackGame,
								stackAddPlayers,
								stackGameRule,
								stackCardsManagement,
								stackTransitionAnimation,
								stackSettings,
								stackAnimation,
								stackRating,
								stackQuestion;
	
	private static List<StackPane> stackPanes;

	private static HomeAP root;
	private static AddCardsAP addCards;
	private static AdminAP admin;
	private static GameAP game;
	private static AddPlayersAP addPlayers;
	private static OptionsAP options;
	private static GameRulesAP gameRule;	
	private static CardsManagementAP cardsManagement;
	private static TransitionAnimationAP ta;
	private static SettingsAP settings;
	private static RatingAP rating;
	private static QuestionAP question;
	
	private static GameOperation go;
	
	public static void initialize() {
		go = new GameOperation();
		
		// AnchorPane Creation
		root = new HomeAP();
		addCards = new AddCardsAP();
		admin = new AdminAP();
		game = new GameAP();
		options = new OptionsAP();
		gameRule = new GameRulesAP();
		cardsManagement = new CardsManagementAP();
		ta = new TransitionAnimationAP();
		settings = new SettingsAP();
		rating = new RatingAP();
		addPlayers = new AddPlayersAP();
		question = new QuestionAP();
		
		// StackPane Creation
		stackRoot = new StackPane(root);
		stackAddCards = new StackPane(addCards);
		stackAdmin = new StackPane(admin);
		stackGame = new StackPane(game);
		stackAddPlayers = new StackPane(addPlayers);
		stackOptions = new StackPane(options);	
		stackGameRule = new StackPane(gameRule);	
		stackCardsManagement = new StackPane(cardsManagement);
		stackTransitionAnimation = new StackPane(ta);
		stackSettings = new StackPane(settings);		
		stackRating = new StackPane(rating);	
		stackQuestion = new StackPane(question);
		
		sceneRoot = new Scene(stackRoot, 1920, 1080); // Original
//		sceneRoot = new Scene(stackGame, 1920, 1080); // Pour les tests
	
		//adding stackPane to the list
		//no.clone() because the equals method is not redefined, so we need the real object
		//we only add the two panes that are important a this point.
		//used in settingsAP
		stackPanes = new ArrayList<StackPane>();
		stackPanes.add(stackQuestion);
		stackPanes.add(stackRating);
	}
	
	public static void volumeInitialization() {
		
		//creation of a MediaPlayer
		MediaPlayer mediaPlayer = new MediaPlayer(
				new Media(ClassLoader.getSystemResource("musics/bensound-hipjazz.wav").toExternalForm()));
		mediaPlayer.play();
		mediaPlayer.setVolume(Constants.INITIAL_VOLUME * Constants.VOLUME_FACTOR);
		mediaPlayer.setStartTime(Duration.seconds(0));
		mediaPlayer.setStopTime(Duration.seconds(160));
		mediaPlayer.setOnEndOfMedia(new Runnable() {
				@Override
				public void run() {
					mediaPlayer.seek(Duration.ZERO);
					mediaPlayer.play();
				}
			});

		//Slider that change the volume
		//Not in the OptionsAP or SettingsAP to make it easier to change
			// in options
		SceneManager.getOptions().getSlVolume().valueProperty().addListener(new ChangeListener<Number>() {
			public void changed(ObservableValue<? extends Number> ov, Number old_val, Number new_val) {
				mediaPlayer.setVolume((double) new_val * Constants.VOLUME_FACTOR);
				SceneManager.getSettings().getSlVolume().setValue((double) new_val);
			}
		});
		
			// in settings
		SceneManager.getSettings().getSlVolume().valueProperty().addListener(new ChangeListener<Number>() {
			public void changed(ObservableValue<? extends Number> ov, Number old_val, Number new_val) {
				mediaPlayer.setVolume((double) new_val * Constants.VOLUME_FACTOR);
				SceneManager.getOptions().getSlVolume().setValue((double) new_val);
			}
		});
	}
		
	//getters AnchorPane
	public static OptionsAP getOptions() {
		return options;
	}
	public static HomeAP getRoot() {
		return root;
	}
	public static TransitionAnimationAP getTransitionAnimation() {
		return ta;
	}
	public static SettingsAP getSettings() {
		return settings;
	}
	public static AddPlayersAP getAddPlayers() {
		return addPlayers;
	}
	public static QuestionAP getQuestion() {
		return question;
	}
	public static RatingAP getRating(){
		return rating;
	}	
	
	//getterStackPanes
	public static List<StackPane> getStackPanes(){
		return stackPanes;
	}
	
	
	//getter GameOperation
	public static GameOperation getGameOperation() {
		return go;
	}
	
	public static Scene getSceneRoot() {
		return sceneRoot;
	}

	public static StackPane getStackOptions() {
		return stackOptions;
	}

	public static StackPane getStackRoot() {
		return stackRoot;
	}

	public static StackPane getStackAddCards() {
		return stackAddCards;
	}

	public static StackPane getStackAdmin() {
		return stackAdmin;
	}

	public static StackPane getStackGame() {
		return stackGame;
	}

	public static StackPane getStackAddPlayers() {
		return stackAddPlayers;
	}

	public static StackPane getStackGameRule() {
		return stackGameRule;
	}
	public static StackPane getStackCardsManager() {
		return stackCardsManagement;
	}
	public static StackPane getStackTransititionAnimation() {
		return stackTransitionAnimation;
	}
	public static StackPane getStackSettings() {
		return stackSettings;
	}
	public static StackPane getStackRating() {
		return stackRating;
	}
	public static StackPane getStackQuestion() {
		return stackQuestion;
	}
	
}
