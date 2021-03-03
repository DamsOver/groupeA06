package vue;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class PlayersAP extends VBox{
	
	private Text txtPlayer;
	private TextField txtFdPlayer;
	
	public PlayersAP() {
		this.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
		this.getStyleClass().add("addpane");
		this.getChildren().addAll(getTxtPlayer(), getTxtFdPlayer());
		txtPlayer.getStyleClass().add("txtField");
	}
	
	public Text getTxtPlayer() {
		if(txtPlayer == null) {
			txtPlayer = new Text("Player");
		}
		return txtPlayer;
	}
	
	public void setTxtPlayer(int numPl) {
		this.getTxtPlayer().setText("Player "+numPl+" :");
	}
	public TextField getTxtFdPlayer() {
		if(txtFdPlayer == null) {
			txtFdPlayer = new TextField();
		}
		return txtFdPlayer;
	}
	
}
