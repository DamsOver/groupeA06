package vue;

import application.SceneManager;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class CardsManagementAP extends AnchorPane {
	private Text txtTitle, txtTheme;
	private Button btnBack, btnModify, btnDelete, btnAdd;
	
	public CardsManagementAP() {
		this.getStyleClass().add("pane");
		
		this.getChildren().addAll(getTxtTitle(), getBtnBack());
		
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
		return btnBack;
	}

}


