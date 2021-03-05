package vue;

import application.SceneManager;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import model.GameOperation;

public class QuestionAP extends AnchorPane{

	private Label lbTurn,lbQuestion, lbCorrectAS;
	private Button btnOK, btnQuestionMark1,btnQuestionMark2,btnQuestionMark3;
	private TextField tfAnswer;
	
	public QuestionAP() {
		this.getStyleClass().add("paneQuestion");
		this.getChildren().addAll(getLbTurn(),
				getBtnQuestionMark1(),
				getBtnQuestionMark2(),
				getBtnQuestionMark3(),
				getLbQuestion(),
				getBtnOK(),
				getTfAnswer(),
				getLbCorrectAS());
		
		// lbTurn
		lbTurn.getStyleClass().add("title3-style");
		AnchorPane.setTopAnchor(getLbTurn(), 50.0);
		AnchorPane.setLeftAnchor(getLbTurn(), 150.0);
		
		//btnQuestionMark1
		btnQuestionMark1.getStyleClass().add("qm1");
		AnchorPane.setTopAnchor(getBtnQuestionMark1(), 150.0);
		AnchorPane.setBottomAnchor(getBtnQuestionMark1(), 500.0);
		AnchorPane.setLeftAnchor(getBtnQuestionMark1(), 800.0);
		AnchorPane.setRightAnchor(getBtnQuestionMark1(), 800.0);
		//btnQuestionMark1.setVisible(false);
		
		//btnQuestionMark2
		btnQuestionMark2.getStyleClass().add("qm2");
		AnchorPane.setTopAnchor(getBtnQuestionMark2(), 150.0);
		AnchorPane.setBottomAnchor(getBtnQuestionMark2(), 500.0);
		AnchorPane.setLeftAnchor(getBtnQuestionMark2(), 800.0);
		AnchorPane.setRightAnchor(getBtnQuestionMark2(), 800.0);
		btnQuestionMark2.setVisible(false);
		
		//btnQuestionMark3
		btnQuestionMark3.getStyleClass().add("qm3");
		AnchorPane.setTopAnchor(getBtnQuestionMark3(), 150.0);
		AnchorPane.setBottomAnchor(getBtnQuestionMark3(), 500.0);
		AnchorPane.setLeftAnchor(getBtnQuestionMark3(), 800.0);
		AnchorPane.setRightAnchor(getBtnQuestionMark3(), 800.0);
		btnQuestionMark3.setVisible(false);
		
		// Question
		lbQuestion.getStyleClass().add("question");
		AnchorPane.setTopAnchor(getLbQuestion(), 650.0);
		AnchorPane.setRightAnchor(getLbQuestion(), 300.0);
		AnchorPane.setLeftAnchor(getLbQuestion(), 300.0);
		 
		// Answer
		tfAnswer.getStyleClass().add("txtField_round");
		AnchorPane.setTopAnchor(getTfAnswer(), 775.0);
		AnchorPane.setRightAnchor(getTfAnswer(), 1200.0);
		AnchorPane.setLeftAnchor(getTfAnswer(), 300.0);
		
		// ok
		btnOK.getStyleClass().add("btn_verysmall");
		AnchorPane.setTopAnchor(getBtnOK(), 775.0);
		AnchorPane.setLeftAnchor(getBtnOK(), 750.0);
		AnchorPane.setRightAnchor(getBtnOK(), 1075.0);
		
		//CorrectAS
		lbCorrectAS.getStyleClass().add("answer");
		AnchorPane.setTopAnchor(getLbCorrectAS(), 775.0);
		AnchorPane.setRightAnchor(getLbCorrectAS(), 300.0);
		AnchorPane.setLeftAnchor(getLbCorrectAS(), 900.0);	
	}

	public Label getLbTurn() {
		if (lbTurn == null) {
			lbTurn = new Label("'s turn");
		}
		return lbTurn;
	}

	public Label getLbQuestion() {
		if (lbQuestion == null) {
			lbQuestion = new Label("Question bateau dire de tester si ca marche ?");
		}
		return lbQuestion;
	}
	
	public void setLbTurn(String name) {
		if (lbTurn != null) {
			lbTurn.setText(name+"'s turn");
		}
	}

	public Button getBtnOK() {
		if(btnOK == null ) {
			btnOK =  new Button("OK");
		}
		return btnOK;
	}

	public Button getBtnQuestionMark1() {
		if (btnQuestionMark1 == null) {
			btnQuestionMark1 = new Button();
		}
		return btnQuestionMark1;
	}
	public Button getBtnQuestionMark2() {
		if (btnQuestionMark2 == null) {
			btnQuestionMark2 = new Button();
		}

		return btnQuestionMark2;
	}
	public Button getBtnQuestionMark3() {
		if (btnQuestionMark3 == null) {
			btnQuestionMark3 = new Button();
		}
		return btnQuestionMark3;
	}

	public TextField getTfAnswer() {
		if(tfAnswer == null) {
			tfAnswer = new TextField();
		}
		return tfAnswer;
	}
	
	public Label getLbCorrectAS() {
		if(lbCorrectAS == null) {
			lbCorrectAS = new Label("The correct answer was :"+" réponse");
		}
		return lbCorrectAS;
	}
	
}
