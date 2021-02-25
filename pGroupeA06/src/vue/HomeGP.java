package vue;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class HomeGP extends GridPane {

	private Text txtTitle;
	private Button btnStartGame;
	private Button btnAdmin;
	private Button btnQuit;
	private Button btnOption;

	public HomeGP() {
		
		this.setPadding(new Insets(10));
//		this.setGridLinesVisible(true); // Rend visible ligne de séparation
		this.setVgap(10);
		this.setHgap(10);

		int nbCol = 20;
		for (int i = 0; i < nbCol; i++) {
			ColumnConstraints colConstr = new ColumnConstraints();
			colConstr.setPercentWidth(100. / nbCol);
			this.getColumnConstraints().add(colConstr);
		}

		// Line 2
		this.add(getTxtTitle(), 8, 6, 4, 2); // elt, columnIndex, rowIndex, colspan, rowspan
		txtTitle.setText("Game menu");
		GridPane.setHalignment(getTxtTitle(), HPos.CENTER);
		txtTitle.getStyleClass().add("title-style");

		// Line 4
		this.add(getBtnStartGame(), 7, 14, 6, 1);
		GridPane.setHalignment(getBtnStartGame(), HPos.CENTER);
		btnStartGame.getStyleClass().add("btn-style");

		// Line 6
		this.add(getBtnOptions(), 7, 16, 6, 1);
		GridPane.setHalignment(getBtnOptions(), HPos.CENTER);
		btnOption.getStyleClass().add("btn-style");

		// Line 8
		this.add(getBtnAdmin(), 7, 18, 6, 1);
		GridPane.setHalignment(getBtnAdmin(), HPos.CENTER);
		btnAdmin.getStyleClass().add("btn-style");

		// Line 14
		this.add(getBtnQuit(), 17, 30, 3, 1);
		GridPane.setHalignment(getBtnQuit(), HPos.CENTER);
		btnQuit.getStyleClass().add("btn-style");
		btnQuit.getStyleClass().add("btnQuit-style");

	}

	public Text getTxtTitle() {
		if (txtTitle == null) {
			txtTitle = new Text();
		}
		return txtTitle;
	}

	public Button getBtnStartGame() {
		if (btnStartGame == null) {
			btnStartGame = new Button("Start Game");
		}
		return btnStartGame;
	}

	public Button getBtnAdmin() {
		if (btnAdmin == null) {
			btnAdmin = new Button("Admin");
		}
		return btnAdmin;
	}

	public Button getBtnQuit() {
		if (btnQuit == null) {
			btnQuit = new Button("Quit");
		}
		return btnQuit;
	}

	public Button getBtnOptions() {
		if (btnOption == null) {
			btnOption = new Button("Option");
		}
		return btnOption;
	}

}
