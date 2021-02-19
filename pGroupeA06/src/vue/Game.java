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

public class Game extends GridPane {
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

	public AddCards() {
		
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
		
	}

	public Label getLblTheme() {
		if (lblTheme == null) {
			lblTheme = new Label("Theme : ");
		}
		return lblTheme;
	}


}
