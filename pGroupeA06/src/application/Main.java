package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.image.Image;

public class Main extends Application {
	
	public void start(Stage primaryStage) {
		try {
			
			//initialisation of the scene
			SceneManager sc = new SceneManager();
			sc.initialize();
			
			//initialisation of the volume
			sc.volumeInitialization();
			
			
			// Close Application
			EventHandler<ActionEvent> eventQuit = new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {
					//SceneManager.getSceneRoot().setRoot(SceneManager.getStackRating());
					primaryStage.close();
				}
			};
			SceneManager.getRoot().getBtnQuit().setOnAction(eventQuit);

			// Style
			SceneManager.getSceneRoot().getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			//Window appearance
			primaryStage.setTitle("How much are you worth ?");
//			Image i = new Image("/img/icon.png");
			primaryStage.getIcons().add(new Image("/img/icon.png"));
//			System.out.println(i.getUrl());
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
