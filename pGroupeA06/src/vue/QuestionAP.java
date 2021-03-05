package vue;

import application.SceneManager;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class QuestionAP extends AnchorPane{

	private Label lbTurn,lbQuestion;
	private Button btnOK, btnQuestionMark1,btnQuestionMark2,btnQuestionMark3;
	private TextField tfAnswer;
	
	public QuestionAP() {
		this.getStyleClass().add("paneQuestion");
		this.getChildren().addAll(getLbTurn());
		
		// lbTurn
		lbTurn.getStyleClass().add("title3-style");
		AnchorPane.setTopAnchor(getLbTurn(), 50.0);
		AnchorPane.setLeftAnchor(getLbTurn(), 150.0);
		
		
		
		
	}

	public Label getLbTurn() {
		if (lbTurn == null) {
			lbTurn = new Label("It's "+ SceneManager.getAddPlayers().getPlayerNames().get(0)+"'s turn");
		}
		return lbTurn;
	}

	public Label getLbQuestion() {
		return lbQuestion;
	}

	public Button getBtnOK() {
		return btnOK;
	}

	public Button getBtnQuestionMark1() {
		return btnQuestionMark1;
	}

	public TextField getTfAnswer() {
		return tfAnswer;
	}
	
}
