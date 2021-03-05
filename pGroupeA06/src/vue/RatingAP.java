package vue;

import application.SceneManager;
import enumerations.Theme;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import model.GameOperation;

public class RatingAP extends AnchorPane{
	private Text txtTitle,txtAnswer;
	private Label lbTheme,lbSubject,lbTurn;
	private Button btnGo;
	private ComboBox<String> cbbRating;
	
	public RatingAP() {
		this.getStyleClass().add("paneQuestion");
		this.getChildren().addAll(getTxtTitle(),getLbTurn(),getCbbRating(),getLbTheme(),getLbSubject(),getBtnGo(),getTxtAnswer());
		
		// title
		txtTitle.getStyleClass().add("title2-style");
		AnchorPane.setTopAnchor(getTxtTitle(), 100.0);
		AnchorPane.setLeftAnchor(getTxtTitle(), 550.0);
		
		// lbTurn
		lbTurn.getStyleClass().add("title3-style");
		AnchorPane.setTopAnchor(getLbTurn(), 50.0);
		AnchorPane.setLeftAnchor(getLbTurn(), 150.0);
		
		// Theme
		lbTheme.getStyleClass().add("theme-subject");
		AnchorPane.setTopAnchor(getLbTheme(), 330.0);
		AnchorPane.setRightAnchor(getLbTheme(), 500.0);
		AnchorPane.setLeftAnchor(getLbTheme(), 500.0);
		
		// Subject
		lbSubject.getStyleClass().add("theme-subject");
		AnchorPane.setTopAnchor(getLbSubject(), 500.0);
		AnchorPane.setRightAnchor(getLbSubject(), 500.0);
		AnchorPane.setLeftAnchor(getLbSubject(), 500.0);
		
		// CbbRating
		cbbRating.getStyleClass().add("cbbox");
		AnchorPane.setTopAnchor(getCbbRating(), 730.0);
		AnchorPane.setLeftAnchor(getCbbRating(), 1075.0);
		cbbRating.setItems(FXCollections.observableArrayList("1", "2", "3", "4"));
		cbbRating.getSelectionModel().selectFirst();
		
		// txtAnswer
		txtAnswer.getStyleClass().add("h1");
		AnchorPane.setTopAnchor(getTxtAnswer(), 720.0);
		AnchorPane.setLeftAnchor(getTxtAnswer(), 650.0);
		
		// BtnGo
		btnGo.getStyleClass().add("btn-style");
		AnchorPane.setTopAnchor(getBtnGo(), 900.0);
		AnchorPane.setRightAnchor(getBtnGo(), 50.0);
		AnchorPane.setLeftAnchor(getBtnGo(), 1650.0);
		
	}
	
	
	public Text getTxtTitle() {
		if (txtTitle == null) {
			txtTitle = new Text("Rate yourself!");
		}
		return txtTitle;
	}
	
	public Label getLbTurn() {
		if (lbTurn == null) {
			lbTurn = new Label("'s turn");
		}
		return lbTurn;
	}
	
	public Label getLbTheme() {
		if (lbTheme == null) {
			lbTheme = new Label("Theme : " + Theme.IMPROBABLE.getTheme().toUpperCase());
		}
		return lbTheme;
	}
	
	public Label getLbSubject() {
		if (lbSubject == null) {
			lbSubject = new Label("Subject : " + "test");
		}
		return lbSubject;
	}
	
	
	public Button getBtnGo() {
		if (btnGo == null) {
			btnGo = new Button("Go");
		}
		btnGo.setOnAction(new EventHandler<ActionEvent>(){
	        public void handle(ActionEvent event) {
	        	SceneManager.getSceneRoot().setRoot(SceneManager.getStackQuestion());
	        	SceneManager.getQuestion().setLbTurn(GameOperation.getGame().getPlayers().get(0).getName());
	           }
			});
		
		return btnGo;
	}
	public ComboBox getCbbRating() {
		if (cbbRating == null) {
			cbbRating = new ComboBox();
		}
		return cbbRating;
	}
	
	public Text getTxtAnswer() {
		if (txtAnswer == null) {
			txtAnswer = new Text("Your rating : ");
		}
		return txtAnswer;
	}
	
}
