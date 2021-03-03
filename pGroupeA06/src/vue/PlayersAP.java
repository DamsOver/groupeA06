package vue;

import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.scene.text.Text;

public class PlayersAP extends AnchorPane{
	
	private Text txtPlayer;
	private TextField txtFdPlayer;
	
	public PlayersAP() {
		this.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
		this.getStyleClass().add("addpane");
		this.getChildren().addAll(getTxtPlayer(), getTxtFdPlayer());
		//this.computePrefWidth(600.);
		//this.computePrefHeight(200.);
		txtPlayer.getStyleClass().add("txtField");
		this.setLeftAnchor(getTxtPlayer(), 50.); 
		this.setTopAnchor(getTxtPlayer(),  50.);
		this.setRightAnchor(getTxtPlayer(), 50.);
		
		this.setTopAnchor(getTxtFdPlayer(), 50.);
		this.setLeftAnchor(getTxtFdPlayer(), 200. );
		this.setRightAnchor(getTxtFdPlayer(), 50.);
		
	
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
