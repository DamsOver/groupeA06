package vue;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
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
	
	private ChoiceBox cbTheme;
	
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
		this.setGridLinesVisible(true); // Rend visible ligne de séparation
		this.setVgap(10);
		this.setHgap(10);
		
		int nbCol=5;
		for(int i=0;i<nbCol;i++) {
			ColumnConstraints colConstr= new ColumnConstraints();
			colConstr.setPercentWidth(100./nbCol);
			this.getColumnConstraints().add(colConstr);
		}
	
		this.add(getLblTheme(), 0, 0, 1, 1);
		this.add(getCbTheme(), 2, 0, 1, 1);
		
//		this.add(getLblLogin(), 0, 0, 1, 1);
//		this.add(getTxtLogin(), 1, 0, 4, 1);
//		this.add(getLblPassword(), 0, 1, 1, 1);
//		this.add(getPwdPassword(), 1, 1, 4, 1);		
//		this.add(getBtnOK(), 4, 2, 1, 1);		
//		GridPane.setHalignment(getBtnOK(), HPos.RIGHT);
		

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
			lblAnswer = new Label("Answer : ");
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
	
	public ChoiceBox getCbTheme() {
		if (cbTheme == null) {
			cbTheme = new ChoiceBox();
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
