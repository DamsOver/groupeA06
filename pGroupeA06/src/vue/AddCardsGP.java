package vue;

import javafx.collections.FXCollections;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;

public class AddCardsGP extends GridPane {
	private Label lblTheme;
	private Label lblAuthor;
	private Label lblSubject;
	private Label lblChallenges;
	private Label lblAnswer;
	private Label lblChallenges1;
	private Label lblChallenges2;
	private Label lblChallenges3;
	private Label lblChallenges4;

	private ComboBox<String> cbTheme;

	private TextField txtFAuthor;
	private TextField txtFSubject;
	private TextField txtFChallenges1;
	private TextField txtFChallenges2;
	private TextField txtFChallenges3;
	private TextField txtFChallenges4;
	private TextField txtFAnswer1;
	private TextField txtFAnswer2;
	private TextField txtFAnswer3;
	private TextField txtFAnswer4;

	private Button btnErase;
	private Button btnSubmit;
	private Button btnBack;

	public AddCardsGP() {

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

		// Line 1
		this.add(getLblTheme(), 0, 0, 2, 1); // elt, columnIndex, rowIndex, colspan, rowspan
		this.add(getCbTheme(), 2, 0, 5, 1);
		cbTheme.setItems(FXCollections.observableArrayList("IMPROBABLE", "PLEASURE", "INFORMATICS", "SCHOOL"));
		GridPane.setHalignment(getCbTheme(), HPos.CENTER);
		cbTheme.getSelectionModel().selectFirst();
		this.add(getLblAuthor(), 7, 0, 3, 1);
		this.add(gettxtFAuthor(), 9, 0, 11, 1);

		// Line 2
		this.add(getLblSubject(), 0, 1, 2, 1);
		this.add(gettxtFSubject(), 2, 1, 18, 1);

		// Line 4
		this.add(getLblChallenges(), 0, 3, 3, 1);
		this.add(getLblAnswer(), 13, 3, 3, 1);

		// Line 5
		this.add(getLblChallenges1(), 0, 4, 3, 1);
		this.add(gettxtFChallenges1(), 3, 4, 10, 1);
		this.add(gettxtFAnswer1(), 13, 4, 7, 1);

		// Line 6
		this.add(getLblChallenges2(), 0, 5, 3, 1);
		this.add(gettxtFChallenges2(), 3, 5, 10, 1);
		this.add(gettxtFAnswer2(), 13, 5, 7, 1);

		// Line 7
		this.add(getLblChallenges3(), 0, 6, 3, 1);
		this.add(gettxtFChallenges3(), 3, 6, 10, 1);
		this.add(gettxtFAnswer3(), 13, 6, 7, 1);

		// Line 8
		this.add(getLblChallenges4(), 0, 7, 3, 1);
		this.add(gettxtFChallenges4(), 3, 7, 10, 1);
		this.add(gettxtFAnswer4(), 13, 7, 7, 1);

		// Line 10
		this.add(getBtnErase(), 0, 8, 4, 2);
		btnErase.getStyleClass().add("btn-style");
		
		this.add(getBtnSubmit(), 3, 8, 4, 2);
		btnSubmit.getStyleClass().add("btn-style");
		
		this.add(getBtnBack(), 18, 8, 4, 2);
		btnBack.getStyleClass().add("btn-style");

	}

	public Label getLblTheme() {
		if (lblTheme == null) {
			lblTheme = new Label("Theme : ");
		}
		return lblTheme;
	}

	public Label getLblAuthor() {
		if (lblAuthor == null) {
			lblAuthor = new Label("Author : ");
		}
		return lblAuthor;
	}

	public Label getLblSubject() {
		if (lblSubject == null) {
			lblSubject = new Label("Subject : ");
		}
		return lblSubject;
	}

	public Label getLblChallenges() {
		if (lblChallenges == null) {
			lblChallenges = new Label("Challenges : ");
		}
		return lblChallenges;
	}

	public Label getLblAnswer() {
		if (lblAnswer == null) {
			lblAnswer = new Label("Answers : ");
		}
		return lblAnswer;
	}

	public Label getLblChallenges1() {
		if (lblChallenges1 == null) {
			lblChallenges1 = new Label("1 : ");
		}
		return lblChallenges1;
	}

	public Label getLblChallenges2() {
		if (lblChallenges2 == null) {
			lblChallenges2 = new Label("2 : ");
		}
		return lblChallenges2;
	}

	public Label getLblChallenges3() {
		if (lblChallenges3 == null) {
			lblChallenges3 = new Label("3 : ");
		}
		return lblChallenges3;
	}

	public Label getLblChallenges4() {
		if (lblChallenges4 == null) {
			lblChallenges4 = new Label("4 : ");
		}
		return lblChallenges4;
	}

	public ComboBox<String> getCbTheme() {
		if (cbTheme == null) {
			cbTheme = new ComboBox<String>();
		}
		return cbTheme;
	}

	public TextField gettxtFAuthor() {
		if (txtFAuthor == null) {
			txtFAuthor = new TextField();
		}
		return txtFAuthor;
	}

	public TextField gettxtFSubject() {
		if (txtFSubject == null) {
			txtFSubject = new TextField();
		}
		return txtFSubject;
	}

	public TextField gettxtFChallenges1() {
		if (txtFChallenges1 == null) {
			txtFChallenges1 = new TextField();
		}
		return txtFChallenges1;
	}

	public TextField gettxtFChallenges2() {
		if (txtFChallenges2 == null) {
			txtFChallenges2 = new TextField();
		}
		return txtFChallenges2;
	}

	public TextField gettxtFChallenges3() {
		if (txtFChallenges3 == null) {
			txtFChallenges3 = new TextField();
		}
		return txtFChallenges3;
	}

	public TextField gettxtFChallenges4() {
		if (txtFChallenges4 == null) {
			txtFChallenges4 = new TextField();
		}
		return txtFChallenges4;
	}

	public TextField gettxtFAnswer1() {
		if (txtFAnswer1 == null) {
			txtFAnswer1 = new TextField();
		}
		return txtFAnswer1;
	}

	public TextField gettxtFAnswer2() {
		if (txtFAnswer2 == null) {
			txtFAnswer2 = new TextField();
		}
		return txtFAnswer2;
	}

	public TextField gettxtFAnswer3() {
		if (txtFAnswer3 == null) {
			txtFAnswer3 = new TextField();
		}
		return txtFAnswer3;
	}

	public TextField gettxtFAnswer4() {
		if (txtFAnswer4 == null) {
			txtFAnswer4 = new TextField();
		}
		return txtFAnswer4;
	}

	public Button getBtnErase() {
		if (btnErase == null) {
			btnErase = new Button("Erase");
		}
		return btnErase;
	}

	public Button getBtnSubmit() {
		if (btnSubmit == null) {
			btnSubmit = new Button("Submit");
		}
		return btnSubmit;
	}

	public Button getBtnBack() {
		if (btnBack == null) {
			btnBack = new Button("Back");
		}
		return btnBack;
	}
}
