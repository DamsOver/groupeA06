package vue;

import enumerations.Theme;
import javafx.collections.FXCollections;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class RatingAP extends AnchorPane{
	private Text txtTitle, txtTheme, txtSubject;
	private Button btnGo;
	private ComboBox<String> cbbRating;
	
	public RatingAP() {
		this.getStyleClass().add("pane");
		this.getChildren().addAll(getTxtTitle(),getCbbRating(),getTxtTheme(),getTxtSubject(),getBtnGo());
		
		// title
		txtTitle.getStyleClass().add("title2-style");
		AnchorPane.setTopAnchor(getTxtTitle(), 150.0);
		AnchorPane.setRightAnchor(getTxtTitle(), 250.0);
		AnchorPane.setLeftAnchor(getTxtTitle(), 350.0);
		
		// Theme
		txtTheme.getStyleClass().add("cbbox");
		AnchorPane.setTopAnchor(getTxtTheme(), 550.0);
		AnchorPane.setRightAnchor(getTxtTheme(), 1000.0);
		AnchorPane.setLeftAnchor(getTxtTheme(), 200.0);
		
		// Subject
		txtSubject.getStyleClass().add("theme-subject");
		AnchorPane.setTopAnchor(getTxtSubject(), 550.0);
		AnchorPane.setRightAnchor(getTxtSubject(), 200.0);
		AnchorPane.setLeftAnchor(getTxtSubject(), 1000.0);
		
		// BtnGo
		btnGo.getStyleClass().add("btn-style");
		AnchorPane.setTopAnchor(getBtnGo(), 900.0);
		AnchorPane.setRightAnchor(getBtnGo(), 50.0);
		AnchorPane.setLeftAnchor(getBtnGo(), 1650.0);
		
		// CbbRating
		cbbRating.getStyleClass().add("cbbox");
		AnchorPane.setTopAnchor(getCbbRating(), 400.0);
		AnchorPane.setLeftAnchor(getCbbRating(), 900.0);
		cbbRating.setItems(FXCollections.observableArrayList("1", "2", "3", "4"));
		cbbRating.getSelectionModel().selectFirst();
		
		
		
	}
	
	
	public Text getTxtTitle() {
		if (txtTitle == null) {
			txtTitle = new Text("How much are you worth?");
		}
		return txtTitle;
	}
	
	public Text getTxtTheme() {
		if (txtTheme == null) {
			txtTheme = new Text("Theme : " + Theme.IMPROBABLE.getTheme().toUpperCase());
		}
		return txtTheme;
	}
	
	public Text getTxtSubject() {
		if (txtSubject == null) {
			txtSubject = new Text("Subject : " + "test");
		}
		return txtSubject;
	}
	
	
	public Button getBtnGo() {
		if (btnGo == null) {
			btnGo = new Button("Go");
		}
		return btnGo;
	}
	public ComboBox getCbbRating() {
		if (cbbRating == null) {
			cbbRating = new ComboBox();
		}
		return cbbRating;
	}
	
	
}
