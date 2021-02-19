package vue;

import javafx.collections.FXCollections;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class AddCards extends GridPane{
	private Label lblTheme;
	private Label lblAuthor;
	private Label lblSubject;
	private Label lblChallenges;
	private Label lblAnswer;
	private Label lblChallenges1;
	private Label lblChallenges2;
	private Label lblChallenges3;
	private Label lblChallenges4;
	
	private ComboBox cbTheme;
	
	private TextField txtAuthor;
	private TextField txtSubject;
	private TextField txtChallenges1;
	private TextField txtChallenges2;
	private TextField txtChallenges3;
	private TextField txtChallenges4;
	private TextField txtAnswer1;
	private TextField txtAnswer2;
	private TextField txtAnswer3;
	private TextField txtAnswer4;
	
	private Button btnErase;
	private Button btnSubmit;

	public AddCards()  {
		this.setPadding(new Insets(10));
//		this.setGridLinesVisible(true); // Rend visible ligne de séparation
		this.setVgap(10);
		this.setHgap(10);
		
		int nbCol=20;
		for(int i=0;i<nbCol;i++) {
			ColumnConstraints colConstr= new ColumnConstraints();
			colConstr.setPercentWidth(100./nbCol);
			this.getColumnConstraints().add(colConstr);
		}
		
		// Line 1
		this.add(getLblTheme(), 0, 0, 2, 1); // elt, columnIndex, rowIndex, colspan, rowspan
		this.add(getCbTheme(), 2, 0, 5, 1);
		cbTheme.setItems(FXCollections.observableArrayList("IMPROBABLE", "PLEASURE", "INFORMATICS", "SCHOOL"));
		GridPane.setHalignment(getCbTheme(), HPos.CENTER);
		cbTheme.getSelectionModel().selectFirst();
		this.add(getLblAuthor(), 7, 0, 3, 1);
		this.add(getTxtAuthor(), 9, 0, 11, 1);
		
		// Line 2
		this.add(getLblSubject(), 0, 1, 2, 1);
		this.add(getTxtSubject(), 2, 1, 18, 1);
		
		// Line 4
		this.add(getLblChallenges(), 0, 3, 3, 1);
		this.add(getLblAnswer(), 13, 3, 3, 1);
		
		// Line 5
		this.add(getLblChallenges1(), 0, 4, 3, 1);
		this.add(getTxtChallenges1(), 3, 4, 10, 1);
		this.add(getTxtAnswer1(), 13, 4, 7, 1);
		
		// Line 6
		this.add(getLblChallenges2(), 0, 5, 3, 1);
		this.add(getTxtChallenges2(), 3, 5, 10, 1);
		this.add(getTxtAnswer2(), 13, 5, 7, 1);
		
		// Line 7
		this.add(getLblChallenges3(), 0, 6, 3, 1);
		this.add(getTxtChallenges3(), 3, 6, 10, 1);
		this.add(getTxtAnswer3(), 13, 6, 7, 1);
		
		// Line 8
		this.add(getLblChallenges4(), 0, 7, 3, 1);
		this.add(getTxtChallenges4(), 3, 7, 10, 1);
		this.add(getTxtAnswer4(), 13, 7, 7, 1);
		
		// Line 10
		this.add(getBtnErase(), 0, 9, 2, 1);
		this.add(getBtnSubmit(), 2, 9, 3, 1);
		

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
	
	public ComboBox getCbTheme() {
		if (cbTheme == null) {
			cbTheme = new ComboBox();
		}
		return cbTheme;
	}
	
	public TextField getTxtAuthor() {
		if (txtAuthor == null) {
			txtAuthor = new TextField();
		}
		return txtAuthor;
	}
	
	public TextField getTxtSubject() {
		if (txtSubject == null) {
			txtSubject = new TextField();
		}
		return txtSubject;
	}
	
	public TextField getTxtChallenges1() {
		if (txtChallenges1 == null) {
			txtChallenges1 = new TextField();
		}
		return txtChallenges1;
	}
	
	public TextField getTxtChallenges2() {
		if (txtChallenges2 == null) {
			txtChallenges2 = new TextField();
		}
		return txtChallenges2;
	}
	
	public TextField getTxtChallenges3() {
		if (txtChallenges3 == null) {
			txtChallenges3 = new TextField();
		}
		return txtChallenges3;
	}
	
	public TextField getTxtChallenges4() {
		if (txtChallenges4 == null) {
			txtChallenges4 = new TextField();
		}
		return txtChallenges4;
	}
	
	public TextField getTxtAnswer1() {
		if (txtAnswer1 == null) {
			txtAnswer1 = new TextField();
		}
		return txtAnswer1;
	}
	
	public TextField getTxtAnswer2() {
		if (txtAnswer2 == null) {
			txtAnswer2 = new TextField();
		}
		return txtAnswer2;
	}
	
	public TextField getTxtAnswer3() {
		if (txtAnswer3 == null) {
			txtAnswer3 = new TextField();
		}
		return txtAnswer3;
	}
	
	public TextField getTxtAnswer4() {
		if (txtAnswer4 == null) {
			txtAnswer4 = new TextField();
		}
		return txtAnswer4;
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
}
