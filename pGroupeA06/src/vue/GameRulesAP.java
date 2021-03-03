package vue;

import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class GameRulesAP extends AnchorPane {
	
	private Text txtTitle,txtRules;
	
	public GameRulesAP() {
		
		this.getStyleClass().add("pane");
		
		this.getChildren().addAll(getTxtTitle(),getTxtRules());
		
		getTxtTitle().getStyleClass().add("title-style");
		AnchorPane.setTopAnchor(getTxtTitle(), 100.0 );
		AnchorPane.setRightAnchor(getTxtTitle(), 550.0 );
		AnchorPane.setLeftAnchor(getTxtTitle(), 550.0 );
		
		getTxtTitle().getStyleClass().add("txtField");
		AnchorPane.setTopAnchor(getTxtTitle(), 300.0 );
		AnchorPane.setRightAnchor(getTxtTitle(), 100.0 );
		AnchorPane.setLeftAnchor(getTxtTitle(), 100.0 );
		
		
	}
	
	public Text getTxtTitle() {
		if (txtTitle == null) {
			txtTitle = new Text("Game Menu");
		}
		return txtTitle;
	}
	
	public Text getTxtRules() {
		if (txtRules == null) {
			txtRules = new Text("Lorem ipsum dolor sit amet, consectetur adipiscing elit, "
					+ "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. "
					+ "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris "
					+ "nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in "
					+ "reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla "
					+ "pariatur. Excepteur sint occaecat cupidatat non proident, sunt in "
					+ "culpa qui officia deserunt mollit anim id est laborum.");
		}
		return txtRules;
	}
	
}
