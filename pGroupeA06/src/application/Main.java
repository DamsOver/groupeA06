package application;
	
import enumerations.Theme;
import exceptions.AlreadyPresentException;
import exceptions.NotPresentException;
import exceptions.TooLittleException;
import exceptions.TooManyException;
import javafx.application.Application;
import javafx.stage.Stage;
import model.BasicCard;
import model.Question;
import vue.AddCards;
import javafx.scene.Scene;
import javafx.scene.image.Image;



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
		BasicCard bc;
		bc = new BasicCard("Martin",Theme.IMPROBABLE,"Nature");
		try {
			bc.addQuestion("What is the only flying mammal?", "The bat");
		} catch (AlreadyPresentException | TooManyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(bc.toString());
	}

}