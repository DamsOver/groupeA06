package vue;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class AddPlayers extends GridPane {
	
	private Text txtTitle;
	private Button btnBack;
	private Button btnSubmit;
	
	public AddPlayers() {
		
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
								
		// Line 20
		this.add(getBtnBack(), 18, 19, 4, 4);
		btnBack.getStyleClass().add("btn-style");
		GridPane.setHalignment(getBtnBack(), HPos.CENTER);
		this.add(getBtnSubmit(), 0, 19, 4, 4);
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
	
}
