package vue;

import application.SceneManager;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class GameAP extends AnchorPane {

	private Button btnSettings;

	public GameAP() {
		this.getStyleClass().add("gameBoard");
		this.getChildren().addAll(getBtnSettings());
		
		getBtnSettings().getStyleClass().add("btnSettings");
		AnchorPane.setTopAnchor(getBtnSettings(), 25.0 );
		AnchorPane.setBottomAnchor(getBtnSettings(), 975.0 );
		AnchorPane.setRightAnchor(getBtnSettings(), 25.0 );
		AnchorPane.setLeftAnchor(getBtnSettings(), 1820.0 );
	}

	public Button getBtnSettings() {
		if (btnSettings == null) {
			btnSettings = new Button();
		}
		btnSettings.setOnAction(new EventHandler<ActionEvent>(){
	        public void handle(ActionEvent event) {
	            SceneManager.getSceneRoot().setRoot(SceneManager.getStackAddPlayers());
	            }
			});
		return btnSettings;
	}

}
