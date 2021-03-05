package model;



import java.util.Timer;
import java.util.TimerTask;

import application.SceneManager;
import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.application.Platform;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class GameOperation {

	public static void skipMilliseconds(int milliseconds,StackPane firstPane, StackPane nextPane ) {
		/*
		SceneManager.getSceneRoot().setRoot(firstPane);
		
		FadeTransition ft = new FadeTransition(Duration.millis(1000),firstPane);
	     ft.setFromValue(1.0f);  
         ft.setToValue(0.5f);  
         ft.setCycleCount(2);  
         ft.setAutoReverse(true);  
		FadeTransition ft2 = new FadeTransition(Duration.millis(500),firstPane);
		ft2.setFromValue(1.0f);  
        ft2.setToValue(0.5f);  
        ft2.setCycleCount(2);  
        ft2.setAutoReverse(true); 
		
		SequentialTransition st = new SequentialTransition (ft,new PauseTransition(Duration.millis(500)),ft2);
		
		st.play();
		*/
		
		SceneManager.transition(firstPane,nextPane, milliseconds);
		
		//SceneManager.getSceneRoot().setRoot(nextPane);
		/*
		SceneManager.getSceneRoot().setRoot(firstPane);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
              @Override
              public void run() {
                  Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                    	SceneManager.getSceneRoot().setRoot(nextPane);                                  
                    }
                });
              }
            }, milliseconds);   */
	}
	
	
	
	
	
}
