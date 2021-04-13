package application;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.Media;
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
	private static MediaPlayer mediaPlayerCorrect;
	private static MediaPlayer mediaPlayerInCorrect;

	private static StackPane stackOptions, stackRoot, stackAddCards, stackAdmin, stackGame, stackAddPlayers,
			stackGameRule, stackCardsManagement, stackTransitionAnimation, stackSettings, stackRating,
			stackQuestion;

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
	

	public void initialize() {
		
		go=new GameOperation();
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
//		sceneRoot = new Scene(stackRating, 1920, 1080); // Pour les tests

	}

	public void volumeInitialization() {

		// creation of a mediaPlayerCorrect
		mediaPlayerCorrect = new MediaPlayer(
				new Media(ClassLoader.getSystemResource(Constants.CORRECT_ANSWER).toExternalForm()));
		mediaPlayerCorrect.setVolume(Constants.INITIAL_VOLUME_EFFECTS * Constants.VOLUME_EFFECTS_FACTOR);
		mediaPlayerCorrect.setStartTime(Duration.seconds(0));
		mediaPlayerCorrect.setStopTime(Duration.seconds(2));

		// creation of a mediaPlayerInCorrect
		mediaPlayerInCorrect = new MediaPlayer(
				new Media(ClassLoader.getSystemResource(Constants.INCORRECT_ANSWER).toExternalForm()));
		mediaPlayerInCorrect.setVolume(Constants.INITIAL_VOLUME_EFFECTS * Constants.VOLUME_EFFECTS_FACTOR * 3.5);
		mediaPlayerInCorrect.setStartTime(Duration.seconds(0));
		mediaPlayerInCorrect.setStopTime(Duration.seconds(2));

		// creation of a MediaPlayer
		MediaPlayer mediaPlayer = new MediaPlayer(
				new Media(ClassLoader.getSystemResource(Constants.MUSIC_1_PATH).toExternalForm()));
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

		// Slider that change the volume
		// Not in the OptionsAP or SettingsAP to make it easier to change
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
		
		// Slider that change the volume Effects Correct
		// Not in the OptionsAP or SettingsAP to make it easier to change
		// in options
		SceneManager.getOptions().getSlVolumeEffects().valueProperty().addListener(new ChangeListener<Number>() {
			public void changed(ObservableValue<? extends Number> ov, Number old_val, Number new_val) {
				mediaPlayerCorrect.setVolume((double) new_val * Constants.VOLUME_EFFECTS_FACTOR);
				SceneManager.getSettings().getSlVolumeEffects().setValue((double) new_val);
			}
		});

		// in settings
		SceneManager.getSettings().getSlVolumeEffects().valueProperty().addListener(new ChangeListener<Number>() {
			public void changed(ObservableValue<? extends Number> ov, Number old_val, Number new_val) {
				mediaPlayerCorrect.setVolume((double) new_val * Constants.VOLUME_EFFECTS_FACTOR);
				SceneManager.getOptions().getSlVolumeEffects().setValue((double) new_val);
			}
		});
		
		// Slider that change the volume Effects InCorrect
		// Not in the OptionsAP or SettingsAP to make it easier to change
		// in options
		SceneManager.getOptions().getSlVolumeEffects().valueProperty().addListener(new ChangeListener<Number>() {
			public void changed(ObservableValue<? extends Number> ov, Number old_val, Number new_val) {
				mediaPlayerInCorrect.setVolume((double) new_val * Constants.VOLUME_EFFECTS_FACTOR);
				SceneManager.getSettings().getSlVolumeEffects().setValue((double) new_val);
			}
		});

		// in settings
		SceneManager.getSettings().getSlVolumeEffects().valueProperty().addListener(new ChangeListener<Number>() {
			public void changed(ObservableValue<? extends Number> ov, Number old_val, Number new_val) {
				mediaPlayerInCorrect.setVolume((double) new_val * Constants.VOLUME_EFFECTS_FACTOR);
				SceneManager.getOptions().getSlVolumeEffects().setValue((double) new_val);
			}
		});
		
	}

	public static MediaPlayer getMediaPlayerCorrect() {
		return mediaPlayerCorrect;
	}

	public static MediaPlayer getMediaPlayerInCorrect() {
		return mediaPlayerInCorrect;
	}

	// a remplacer par getCHildren
	// getters AnchorPane
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

	public static RatingAP getRating() {
		return rating;
	}

	public static AddCardsAP getAddCards() {
		return addCards;
	}

	public static GameAP getGame() {
		return game;
	}
	
	public static CardsManagementAP getCardsManagement() {
		return cardsManagement;
	}

	// getter GameOperation
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
