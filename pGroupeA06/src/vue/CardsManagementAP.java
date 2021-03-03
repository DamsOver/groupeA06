package vue;

import application.SceneManager;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class CardsManagementAP extends AnchorPane {
	private Text txtTitle, txtTheme;
	private Button btnBack, btnModify, btnDelete, btnAdd;
	
	private ComboBox<String> cbTheme;

	public CardsManagementAP() {
		this.getStyleClass().add("pane");

		this.getChildren().addAll(getTxtTitle(), getBtnBack(), getTxtTheme(), getCbTheme());

		// title
		txtTitle.getStyleClass().add("title-style");
		AnchorPane.setTopAnchor(getTxtTitle(), 100.0);
		AnchorPane.setLeftAnchor(getTxtTitle(), 300.0);

		// Theme
		txtTheme.getStyleClass().add("basicText");
		AnchorPane.setTopAnchor(getTxtTheme(), 450.0);
		AnchorPane.setLeftAnchor(getTxtTheme(), 200.0);
		
		// cbbTheme
		cbTheme.getStyleClass().add("cbbox");
		AnchorPane.setTopAnchor(getCbTheme(), 450.0);
		AnchorPane.setLeftAnchor(getCbTheme(), 370.0);
		cbTheme.setItems(FXCollections.observableArrayList("IMPROBABLE", "PLEASURE", "INFORMATICS", "SCHOOL"));
		cbTheme.getSelectionModel().selectFirst();
		
		// BtnBack
		btnBack.getStyleClass().add("btn-style");
		AnchorPane.setTopAnchor(getBtnBack(), 900.0);
		AnchorPane.setLeftAnchor(getBtnBack(), 1600.0);
		
		
	}

	public Text getTxtTitle() {
		if (txtTitle == null) {
			txtTitle = new Text("Cards Management");
		}
		return txtTitle;
	}

	public Button getBtnBack() {
		if (btnBack == null) {
			btnBack = new Button("Back");
		}
		btnBack.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				SceneManager.getSceneRoot().setRoot(SceneManager.getStackAdmin());
			}
		});
		return btnBack;
	}

	public Text getTxtTheme() {
		if (txtTheme == null) {
			txtTheme = new Text("Theme : ");
		}
		return txtTheme;
	}
	
	public ComboBox getCbTheme() {
		if (cbTheme == null) {
			cbTheme = new ComboBox();
		}
		return cbTheme;
	}

	public Button getBtnModify() {
		return btnModify;
	}

	public Button getBtnDelete() {
		return btnDelete;
	}

	public Button getBtnAdd() {
		return btnAdd;
	}

}
