package vue;

import application.SceneManager;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.text.Text;
import util.Constants;

public class OptionsAP extends AnchorPane {

	private Slider slVolume;
	private Text txtTitle, txtVolume;
	private Button btnBack,btnCards;

	public OptionsAP() {

		
		this.getStyleClass().add("pane");
		this.getChildren().addAll(getTxtTitle(), getBtnBack(), getTxtVolume(), getSlVolume(),getBtnCards());

		// title
		txtTitle.getStyleClass().add("title-style");
		AnchorPane.setTopAnchor(getTxtTitle(), 100.0);
		AnchorPane.setRightAnchor(getTxtTitle(), 700.0);
		AnchorPane.setLeftAnchor(getTxtTitle(), 700.0);

		// BtnBack
		btnBack.getStyleClass().add("btn-style");
		AnchorPane.setTopAnchor(getBtnBack(), 900.0);
		AnchorPane.setRightAnchor(getBtnBack(), 50.0);
		AnchorPane.setLeftAnchor(getBtnBack(), 1600.0);

		// SlVolume
		slVolume.setValue(Constants.INITIAL_VOLUME);
		slVolume.getStyleClass().add("slider-style");
		AnchorPane.setTopAnchor(getSlVolume(), 410.0);
		AnchorPane.setRightAnchor(getSlVolume(), 550.0);
		AnchorPane.setLeftAnchor(getSlVolume(), 600.0);

		// TxtVolume
		txtVolume.getStyleClass().add("h1");
		AnchorPane.setTopAnchor(getTxtVolume(), 400.0);
		AnchorPane.setRightAnchor(getTxtVolume(), 1400.0);
		AnchorPane.setLeftAnchor(getTxtVolume(), 200.0);	
		
		// BtnCards
		btnCards.getStyleClass().add("btn-style");
		AnchorPane.setTopAnchor(getBtnCards(),625.0);
		AnchorPane.setRightAnchor(getBtnCards(), 1050.0);
		AnchorPane.setLeftAnchor(getBtnCards(), 200.0);

	}

	public Text getTxtTitle() {
		if (txtTitle == null) {
			txtTitle = new Text("Options");
		}
		return txtTitle;
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
	
	public Button getBtnCards() {
		if (btnCards == null) {
			btnCards = new Button("Card Management");
		}
		btnCards.setOnAction(new EventHandler<ActionEvent>(){
	        public void handle(ActionEvent event) {
	            SceneManager.getSceneRoot().setRoot(SceneManager.getStackAdmin());
	            }
			});
		return btnCards;
	}

	public Text getTxtVolume() {
		if (txtVolume == null) {
			txtVolume = new Text("Volume : ");
		}
		return txtVolume;
	}

	public Slider getSlVolume() {
		if (slVolume == null) {
			slVolume = new Slider();
		}
		return slVolume;
	}

}
