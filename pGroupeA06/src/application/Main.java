package application;
	
import enumerations.Theme;
import exceptions.AlreadyPresentException;
import exceptions.NotPresentException;
import exceptions.TooLittleException;
import exceptions.TooManyException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import model.BasicCard;
import model.Question;
import vue.AddCards;
import vue.Home;
import javafx.scene.Scene;
import javafx.scene.image.Image;



public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			primaryStage.setTitle("How much are you worth ?");
			primaryStage.getIcons().add(new Image("/icon/icon.png"));
			
			Home root = new Home();	
			AddCards addCards = new AddCards();
			Scene sceneRoot = new Scene(root,600,315);
			Scene sceneAddCards = new Scene(addCards,600,315);
			
			// Event StartGame
			EventHandler<ActionEvent> eventStartGame = new EventHandler<ActionEvent>() { 
	            public void handle(ActionEvent e) 
	            { 
	            	// Start game
	            	// primaryStage.setScene(scene);
	    			// primaryStage.show();
	            } 
	        }; 
			root.getBtnStartGame().setOnAction(eventStartGame); 
			

			
			
			sceneRoot.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(sceneRoot);
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