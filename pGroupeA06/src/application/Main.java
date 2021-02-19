package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import vue.AddCards;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import icon.*;



public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			AddCards root = new AddCards();
			primaryStage.setTitle("How much are you worth ?");
			primaryStage.getIcons().add(new Image("/icon/icon.png"));
			
			Scene scene = new Scene(root,600,315);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}