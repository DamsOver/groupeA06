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
import vue.*;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {

			primaryStage.setTitle("How much are you worth ?");
			primaryStage.getIcons().add(new Image("/img/icon.png"));
			primaryStage.setResizable(false);

			MediaPlayer mediaPlayer = new MediaPlayer(new Media(new File("src/musics/bensound-hipjazz.mp3").toURI().toString()));
			mediaPlayer.play();
			mediaPlayer.setVolume(Constants.INITIAL_VOLUME*Constants.VOLUME_FACTOR);
			mediaPlayer.setStartTime(Duration.seconds(0));
			mediaPlayer.setStopTime(Duration.seconds(160));
			mediaPlayer.setOnEndOfMedia(new Runnable() {
		        @Override
		        public void run() {
		        	mediaPlayer.seek(Duration.ZERO);
		        	mediaPlayer.play();
		        }
		    }); 
			
			HomeGP root = new HomeGP();
			AddCardsGP addCards = new AddCardsGP();
			AdminGP admin = new AdminGP();
			GameGP game = new GameGP();
			game.setId("gameBoard");
			AddPlayersGP addPlayers = new AddPlayersGP();
			OptionsGP options = new OptionsGP();
			LoginAdminGP loginAdmin = new LoginAdminGP();
			
			Scene sceneRoot = new Scene(root, 600, 315);
			Scene sceneAddCards = new Scene(addCards, 600, 315);
			Scene sceneAdmin = new Scene(admin, 600, 315);
			Scene sceneGame = new Scene(game, 900, 506);
			Scene sceneAddPlayers = new Scene(addPlayers, 600, 315);
			Scene sceneOptions = new Scene(options, 600, 315);

			// Event "change scene" with click button
			// addPlayers -> Game
			EventHandler<ActionEvent> eventStartGame = new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {

					primaryStage.setScene(sceneGame);
					primaryStage.show();
				}
			};
			addPlayers.getBtnSubmit().setOnAction(eventStartGame);

			// Home -> AddPlayers
			// Game -> AddPlayers
			EventHandler<ActionEvent> eventAddPlayers = new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {

					primaryStage.setScene(sceneAddPlayers);
					primaryStage.show();
				}
			};
			root.getBtnStartGame().setOnAction(eventAddPlayers);
			game.getBtnBack().setOnAction(eventAddPlayers);

			// Home -> Admin
			// AddCards -> Admin
			EventHandler<ActionEvent> eventAdmin = new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {

					primaryStage.setScene(sceneAdmin);
					primaryStage.show();
				}
			};
			root.getBtnAdmin().setOnAction(eventAdmin);
			addCards.getBtnBack().setOnAction(eventAdmin);
			

			// Admin -> Home
			// AddPlayers -> Home
			// Options -> Home
			EventHandler<ActionEvent> eventHome = new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {
					primaryStage.setScene(sceneRoot);
					primaryStage.show();
				}
			};
			admin.getBtnBack().setOnAction(eventHome);
			addPlayers.getBtnBack().setOnAction(eventHome);
			options.getBtnBack().setOnAction(eventHome);

			// Admin -> AddCards
			EventHandler<ActionEvent> eventAddCards = new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {
					primaryStage.setScene(sceneAddCards);
					primaryStage.show();
				}
			};
			admin.getBtnAddCards().setOnAction(eventAddCards);

			// Home -> Options
			EventHandler<ActionEvent> eventOptions = new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {
					primaryStage.setScene(sceneOptions);
					primaryStage.show();
				}
			};
			root.getBtnOptions().setOnAction(eventOptions);

			// Close Application
			EventHandler<ActionEvent> eventQuit = new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {

					primaryStage.close();
				}
			};
			root.getBtnQuit().setOnAction(eventQuit);
			
			
			// Add the BasicCard
			EventHandler<ActionEvent> eventAddBasicCard = new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {
					
					BasicCard bc =  new BasicCard(addCards.gettxtFAuthor().getText(),Theme(addCards.getCbTheme().getValue().toString()),addCards.gettxtFSubject().getText());
					System.out.println(bc.toString());
					
					//Check if the questions are correct and add them to the deck
					
					//Checking the questions
						//check if they are not empty
							//if they are, error message ="try to add all 4 questions"
						//if they are not try to add them to the card
							//if error during the adding, error message = "exceptions"
						
						//if everything ok 
							//create a card and add the questions
							//add the card
					
				}

				private Theme Theme(String value) {
					// TODO Auto-generated method stub
					return null;
				}
			};
			addCards.getBtnSubmit().setOnAction(eventAddBasicCard);
			
			
			
			
			options.getSlVolume().valueProperty().addListener(new ChangeListener<Number>() {
	            public void changed(ObservableValue<? extends Number> ov,
	                Number old_val, Number new_val) {
	            	mediaPlayer.setVolume((double) new_val*Constants.VOLUME_FACTOR);
	            }
	        });

			// Style
			sceneOptions.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			sceneAddPlayers.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			sceneAddCards.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			sceneGame.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			sceneAdmin.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			sceneRoot.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			// Main Scene
			primaryStage.setScene(sceneRoot);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
		
		
		
	}

}