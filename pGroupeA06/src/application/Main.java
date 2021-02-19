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
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			AddCards root = new AddCards();

			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
		
	/**QUESTION**/
		//test Json Question
			Question q = new Question("Martin",Theme.IMPROBABLE,"Nature","What is the only flying mammal?","The bat",2);
			System.out.println("Test JSON Question");
			System.out.println(q.toJson());
			Question q2 = new Question();
			System.out.println(q2.fromJson(q.toJson()));
		
		
	/**BASICCARD**/
		BasicCard bc = new BasicCard("Martin",Theme.IMPROBABLE,"Nature");
		//test removeQuestion
			System.out.println("Test removeQuestion");	
			//tooLittleException
			try {
				bc.removeQuestion("What is the only flying mammal?","The bat",2);
			} catch (NotPresentException | TooLittleException e) {
				System.err.println(e.getMessage());
			}
			
			//normal
			try {
				bc.addQuestion("What is the only flying mammal?", "The bat",2);
			} catch (AlreadyPresentException | TooManyException e) {
				System.err.println(e.getMessage());
			}
		
			try {
				bc.removeQuestion("What is the only flying mammal?","The bat",2);
			} catch (NotPresentException | TooLittleException e) {
				System.err.println(e.getMessage());
			}
			
		
		//test addQuestion	
			System.out.println("\nTest addQuestion");	
			//normal
			try {
				bc.addQuestion("What is the only flying mammal?", "The bat",2);
			} catch (AlreadyPresentException | TooManyException e) {
				System.err.println(e.getMessage());
			}
			
			//AlreadyPresentException
			try {
				bc.addQuestion("What is the only flying mammal?", "The bat",2);
			} catch (AlreadyPresentException | TooManyException e) {
				System.err.println(e.getMessage());
			}
			try {
				bc.addQuestion("What is the only flying mammal?", "The ba",3);
			} catch (AlreadyPresentException | TooManyException e) {
				System.err.println(e.getMessage());
			}
			try {
				bc.addQuestion("What is the only flying mammal?", "The b",1);
			} catch (AlreadyPresentException | TooManyException e) {
				System.err.println(e.getMessage());
			}
			try {
				bc.addQuestion("What is the only flying mammal?", "The ",4);
			} catch (AlreadyPresentException | TooManyException e) {
				System.err.println(e.getMessage());
			}
			//TooManyException
			try {
				bc.addQuestion("What is the only flying mammal?", "The",2);
			} catch (AlreadyPresentException | TooManyException e) {
				System.err.println(e.getMessage());
			}
			
		//test sortByDifficulty
			System.out.println("\nTest sortByDifficulty");	
			System.out.println(bc);
			try {
				bc.sortByDifficulty();
			} catch (TooLittleException e) {
				System.err.println(e.getMessage());
			}
			System.out.println(bc);
			
		
		//test Json BasicCard
		
		
		
		
	}

}