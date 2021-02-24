package vue;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import util.Constants;

public class OptionsGP extends GridPane {

	private Label lblVolume;
	private Slider slVolume;
	private Text txtTitle;
	private Button btnBack;

	public OptionsGP() {

		this.setPadding(new Insets(10));
//		this.setGridLinesVisible(true); // Rend visible ligne de sÚparation
		this.setVgap(10);
		this.setHgap(10);

		int nbCol = 20;
		for (int i = 0; i < nbCol; i++) {
			ColumnConstraints colConstr = new ColumnConstraints();
			colConstr.setPercentWidth(100. / nbCol);
			this.getColumnConstraints().add(colConstr);
		}

		// Line 2
		this.add(getTxtTitle(), 8, 3, 4, 1); // elt, columnIndex, rowIndex, colspan, rowspan
		txtTitle.setText("Options");
		GridPane.setHalignment(getTxtTitle(), HPos.CENTER);
		txtTitle.getStyleClass().add("title-style");

		// Line 3
		this.add(getLblVolume(), 2, 9, 5, 1);
		this.add(getSlVolume(), 6, 9, 8, 1);
		lblVolume.getStyleClass().add("h1");
		slVolume.setValue(Constants.INITIAL_VOLUME);
		slVolume.setMajorTickUnit(50);
		slVolume.setMinorTickCount(5);
		slVolume.setBlockIncrement(1);
		slVolume.getStyleClass().add("slider-style");

		// Line 20
		this.add(getBtnBack(), 15, 50, 4, 4);
		btnBack.getStyleClass().add("btn-style");
		GridPane.setHalignment(getBtnBack(), HPos.CENTER);

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

	public Label getLblVolume() {
		if (lblVolume == null) {
			lblVolume = new Label("Volume : ");
		}
		return lblVolume;
	}

	public Slider getSlVolume() {
		if (slVolume == null) {
			slVolume = new Slider();
		}
		return slVolume;
	}

}
