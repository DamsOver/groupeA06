package application;

import java.io.File;

import enumerations.Theme;
import exceptions.*;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.*;
import util.Constants;
import util.UnlockAdmin;
import vue.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Main extends Application {
	
	public void start(Stage primaryStage) {
		try {
			
			//Music
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
			
			
			//initialisation of the scene
			SceneManager.initialize();
			
			
			// Close Application
			EventHandler<ActionEvent> eventQuit = new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {
					primaryStage.close();
				}
			};
			SceneManager.getRoot().getBtnQuit().setOnAction(eventQuit);


			//Volume
			SceneManager.getOptions().getSlVolume().valueProperty().addListener(new ChangeListener<Number>() {
				public void changed(ObservableValue<? extends Number> ov, Number old_val, Number new_val) {
					mediaPlayer.setVolume((double) new_val * Constants.VOLUME_FACTOR);
				}
			});


			// Style
			SceneManager.getSceneRoot().getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			//Window appearance
			primaryStage.setTitle("How much are you worth ?");
			primaryStage.getIcons().add(new Image("/img/icon.png"));
			primaryStage.setResizable(false);
			
			// Main Scene set Scene
			primaryStage.setScene(SceneManager.getSceneRoot());
			primaryStage.setFullScreen(true);
			primaryStage.show();
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public static void main(String[] args) {
		launch(args);
	}
}




//// Add the BasicCard
//EventHandler<ActionEvent> eventAddBasicCard = new EventHandler<ActionEvent>() {
//	public void handle(ActionEvent e) {
//
//		// Check if the questions are correct and add them to the deck
//
//		// Checking the questions
//		// check if they are not empty
//		// if they are, error message ="try to add all 4 questions"
//		// if they are not try to add them to the card
//		// if error during the adding, error message = "exceptions"
//
//		// if everything ok
//		// create a card and add the questions
//		// add the card
//
//	}
//};
//addCards.getBtnSubmit().setOnAction(eventAddBasicCard);


//// Password validate
//EventHandler<ActionEvent> eventValidateLogin = new EventHandler<ActionEvent>() {
//	public void handle(ActionEvent e) {
//		String response = loginAdmin.getPwfAdmin().getText();
//		PasswordAdmin pw = new PasswordAdmin(response);
//		loginAdmin.setTxtMessage(pw.getMessage());
//		if (pw.getValidation()) {
////			primaryStage.setScene(sceneAdmin);
////			primaryStage.show();
//		} else {
//			// loginAdmin.getTxtMessage().setSelectionFill(Color.rgb(210, 39, 30));
//		}
//		loginAdmin.getPwfAdmin().clear();
//	}
//};