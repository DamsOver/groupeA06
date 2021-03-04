package application;

import java.io.File;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.Media;
import javafx.stage.Stage;
import javafx.util.Duration;
import util.Constants;
import vue.AddCardsAP;
import vue.AddPlayersAP;
import vue.AdminAP;
import vue.CardsManagementAP;
import vue.GameAP;
import vue.GameRulesAP;
import vue.HomeAP;
import vue.OptionsAP;
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
								stackSettings;
	

	private static HomeAP root;
	private static OptionsAP options;
	private static TransitionAnimationAP ta;
	private static SettingsAP settings;
	
	public static void initialize() {
		
		
		//AnchorPane Creation
		root = new HomeAP();
		options=new OptionsAP();
		ta = new TransitionAnimationAP();
		settings = new SettingsAP();
		
		//StackPane Creation
		stackRoot = new StackPane(root);
		stackAddCards = new StackPane(new AddCardsAP());
		stackAdmin = new StackPane(new AdminAP());
		stackGame = new StackPane(new GameAP());
		stackAddPlayers = new StackPane(new AddPlayersAP());
		stackOptions = new StackPane(options);
		stackGameRule = new StackPane(new GameRulesAP());
		stackCardsManagement = new StackPane(new CardsManagementAP());
		stackTransitionAnimation = new StackPane(ta);
		stackSettings = new StackPane(settings);
		sceneRoot = new Scene(stackRoot, 1920, 1080);
		
		
	}
	
	public static void volumeInitialization() {
		
		//creation of a MediaPlayer
		MediaPlayer mediaPlayer = new MediaPlayer(
				new Media(new File("src/musics/bensound-hipjazz.mp3").toURI().toString()));
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

		//Slider change the volume
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
	
}
