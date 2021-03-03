package model;



import java.util.Timer;
import java.util.TimerTask;

import application.SceneManager;
import javafx.application.Platform;
import javafx.scene.layout.StackPane;

public class GameOperation {

	public static void skipMilliseconds(int milliseconds,StackPane firstPane, StackPane nextPane ) {
		
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
            }, milliseconds);   
	}
	
	
	
	
	
}
