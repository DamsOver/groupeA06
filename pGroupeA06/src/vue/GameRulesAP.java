package vue;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import application.SceneManager;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import util.Constants;

public class GameRulesAP extends AnchorPane {
	
	private Text txtTitle,txtRules;
	private ScrollPane sp;
	private Button btnBack;
	
	public GameRulesAP() {
		
		this.getStyleClass().add("pane");
		
		this.getChildren().addAll(getTxtTitle(),getSP(),getBtnBack());
		
		
		getTxtTitle().getStyleClass().add("title-style");
		AnchorPane.setTopAnchor(getTxtTitle(), 100.0 );
		AnchorPane.setRightAnchor(getTxtTitle(), 550.0 );
		AnchorPane.setLeftAnchor(getTxtTitle(), 550.0 );
		
		getSP().getStyleClass().add("scroll-pane");
		AnchorPane.setTopAnchor(getSP(), 300.0 );
		AnchorPane.setRightAnchor(getSP(), 150.0 );
		AnchorPane.setLeftAnchor(getSP(), 150.0 );
		AnchorPane.setBottomAnchor(getSP(), 250.0 );
		
		getTxtRules().getStyleClass().add("txtAddPlayer");
		
		// BtnBack
		btnBack.getStyleClass().add("btn-style");
		AnchorPane.setTopAnchor(getBtnBack(), 900.0);
		AnchorPane.setRightAnchor(getBtnBack(), 50.0);
		AnchorPane.setLeftAnchor(getBtnBack(), 1600.0);
		
		
		
	}
	
	public Text getTxtTitle() {
		if (txtTitle == null) {
			txtTitle = new Text("Game Rules");
		}
		return txtTitle;
	}
	
	public Text getTxtRules() {
		if (txtRules == null) {
		/*	try {
				BufferedReader rule = new BufferedReader(new FileReader("./text/GameRule.txt"));
				StringBuilder allText = new StringBuilder();
				txtRules = new Text(rule.readLine());
				rule.close();
			}
			catch(IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}	*/
			txtRules = new Text("\"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."
					+ "\"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\""
					+ "\"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\"");
		}
		txtRules.setWrappingWidth(1600);
		txtRules.setTextAlignment(TextAlignment.JUSTIFY);
		return txtRules;
	}
	
	public ScrollPane getSP() {
		if (sp == null) {
			sp = new ScrollPane();
		}
		sp.setContent(getTxtRules());
		return sp;
	}
	
	public Button getBtnBack() {
		if (btnBack == null) {
			btnBack = new Button("Back");
		}
		btnBack.setOnAction(new EventHandler<ActionEvent>(){
	        public void handle(ActionEvent event) {
	            SceneManager.getSceneRoot().setRoot(SceneManager.getStackRoot());
	            }
			});
		return btnBack;
	}
	
}
