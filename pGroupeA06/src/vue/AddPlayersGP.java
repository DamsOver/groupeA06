package vue;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class AddPlayersGP extends GridPane {

	private Text txtTitle;

	private Label lblPlayer1;
	private Label lblPlayer2;

	private TextField txtFPlayer1;
	private TextField txtFPlayer2;

	private Button btnBack;
	private Button btnSubmit;

	public AddPlayersGP() {

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
		this.add(getTxtTitle(), 8, 1, 4, 1); // elt, columnIndex, rowIndex, colspan, rowspan
		txtTitle.setText("Add Players");
		GridPane.setHalignment(getTxtTitle(), HPos.CENTER);
		txtTitle.getStyleClass().add("title-style");

		// Line 4
		this.add(getLblPlayer1(), 1, 3, 3, 1);
		this.add(getTxtFPlayer1(), 4, 3, 8, 1);

		// Line 6
		this.add(getLblPlayer2(), 1, 5, 3, 1);
		this.add(getTxtFPlayer2(), 4, 5, 8, 1);

		// Line 20
		this.add(getBtnBack(), 18, 14, 4, 4);
		btnBack.getStyleClass().add("btn-style");
		GridPane.setHalignment(getBtnBack(), HPos.CENTER);
		this.add(getBtnSubmit(), 0, 14, 4, 4);
		GridPane.setHalignment(getBtnSubmit(), HPos.CENTER);
		btnSubmit.getStyleClass().add("btn-style");

	}

	public Text getTxtTitle() {
		if (txtTitle == null) {
			txtTitle = new Text();
		}
		return txtTitle;
	}

	public Button getBtnBack() {
		if (btnBack == null) {
			btnBack = new Button("Back");
		}
		return btnBack;
	}

	public Button getBtnSubmit() {
		if (btnSubmit == null) {
			btnSubmit = new Button("Submit");
		}
		return btnSubmit;
	}

	public Label getLblPlayer1() {
		if (lblPlayer1 == null) {
			lblPlayer1 = new Label("Player 1 : ");
		}
		return lblPlayer1;
	}

	public Label getLblPlayer2() {
		if (lblPlayer2 == null) {
			lblPlayer2 = new Label("Player 2 : ");
		}
		return lblPlayer2;
	}

	public TextField getTxtFPlayer1() {
		if (txtFPlayer1 == null) {
			txtFPlayer1 = new TextField();
		}
		return txtFPlayer1;
	}

	public TextField getTxtFPlayer2() {
		if (txtFPlayer2 == null) {
			txtFPlayer2 = new TextField();
		}
		return txtFPlayer2;
	}

}
