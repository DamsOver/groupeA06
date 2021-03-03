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

public class AdminAP extends AnchorPane {

	private Text txtTitle;
	private Button btnBack;
	private Button btnUnlock;

	public AdminAP() {
		
		this.getStyleClass().add("pane");
		this.getChildren().addAll(getTxtTitle(), getBtnBack(),getBtnUnlock());
		
		// title
		txtTitle.getStyleClass().add("title-style");
		AnchorPane.setTopAnchor(getTxtTitle(), 100.0);
		AnchorPane.setRightAnchor(getTxtTitle(), 700.0);
		AnchorPane.setLeftAnchor(getTxtTitle(), 700.0);
		
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
		
//		this.getStyleClass().add("pane");
//		this.setPadding(new Insets(10));
////		this.setGridLinesVisible(true); // Rend visible ligne de séparation
//		this.setVgap(10);
//		this.setHgap(10);
//
//		int nbCol = 20;
//		for (int i = 0; i < nbCol; i++) {
//			ColumnConstraints colConstr = new ColumnConstraints();
//			colConstr.setPercentWidth(100. / nbCol);
//			this.getColumnConstraints().add(colConstr);
//		}
//
//		// Line 2
//		this.add(getTxtTitle(), 8, 1, 4, 1); // elt, columnIndex, rowIndex, colspan, rowspan
//		txtTitle.setText("Admin");
//		GridPane.setHalignment(getTxtTitle(), HPos.CENTER);
//		txtTitle.getStyleClass().add("title-style");
//
//		// Line 4
//		this.add(getBtnAddCards(), 7, 3, 6, 1);
//		GridPane.setHalignment(getBtnAddCards(), HPos.CENTER);
//		addCards.getStyleClass().add("btn-style");
//
//		// Line 20
//		this.add(getBtnBack(), 18, 15, 4, 3);
//		btnBack.getStyleClass().add("btn-style");

	}

	public Text getTxtTitle() {
		if (txtTitle == null) {
			txtTitle = new Text("Admin");
		}
		return txtTitle;
	}

	public Button getBtnBack() {
		if (btnBack == null) {
			btnBack = new Button("Back");
		}
		btnBack.setOnAction(new EventHandler<ActionEvent>(){
	        public void handle(ActionEvent event) {
	            SceneManager.getSceneRoot().setRoot(SceneManager.getStackOptions());
	        }
		});
		return btnBack;
	}

	public Button getBtnUnlock() {
		if (btnUnlock == null) {
			btnUnlock = new Button("Unlock");
		}
		return btnUnlock;
	}

}
