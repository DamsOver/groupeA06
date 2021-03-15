package vue;

import application.SceneManager;
import enumerations.Theme;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import model.GameOperation;
import model.Question;
import util.Constants;

public class QuestionAP extends AnchorPane{

	private Label lbTurn, lbQuestion, lbCorrectAS, lblTimer;
	private Button btnOK, btnQuestionMark1,btnQuestionMark2,btnQuestionMark3;
	private TextField tfAnswer;
	
	private String answer;
	
	private IntegerProperty timeSeconds = new SimpleIntegerProperty(Constants.TIMER_START);
	private Timeline timeline;
	
	private EventHandler<ActionEvent> clickBtn;
	
	public QuestionAP() {
		this.getStyleClass().add("paneQuestion");
		this.getChildren().addAll(getLbTurn(),
				getBtnQuestionMark1(),
				getBtnQuestionMark2(),
				getBtnQuestionMark3(),
				getLbQuestion(),
				getBtnOK(),
				getTfAnswer(),
				getLbCorrectAS(),
				getLblTimer());
		
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
		AnchorPane.setTopAnchor(getLbQuestion(), 600.0);
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
		
		//timer
		getLblTimer().getStyleClass().add("timer");
		AnchorPane.setTopAnchor(getLblTimer(), 50.);
		AnchorPane.setRightAnchor(getLblTimer(), 50.);
		AnchorPane.setBottomAnchor(getLblTimer(), 900.);
		AnchorPane.setLeftAnchor(getLblTimer(), 1720.);
	}

	public Label getLbTurn() {
		if (lbTurn == null) {
			lbTurn = new Label("'s turn");
		}
		return lbTurn;
	}

	public Label getLbQuestion() {
		if (lbQuestion == null) {
			lbQuestion = new Label("Question bateau ");
		}
		return lbQuestion;
	}
	
	public void setLbQuestion(Question q) {
		if (lbQuestion == null) {
			lbQuestion= new Label(q.getChallenge());
		}
		else {
			lbQuestion.setText(q.getChallenge());
		}
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
		btnOK.setOnAction(getClickBtn());
		return btnOK;
	}
	
	
	public void enableBtnOK(boolean choice) {
		btnOK.setVisible(choice);
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
	
	public String getAnswer() {
		if(tfAnswer == null) {
			return null;
		}
		return answer;
	}
	public void setAnswer() {
		if(tfAnswer == null) {
			answer = null;
		}
		else {
			answer = tfAnswer.getText();
		}
	}
	
	public void setLbAnswer(Question q) {
		if(lbCorrectAS == null) {
			lbCorrectAS = new Label();
		}
		lbCorrectAS.setText(q.getAnswer());
	}
	
	public void enableLbAnswer(boolean activated) {
		if(lbCorrectAS == null) {
			lbCorrectAS = new Label();
		}
		if(activated) {
			lbCorrectAS.setVisible(true);
		}
		else {
			lbCorrectAS.setVisible(false);
		}
	}
	
	public void enableQuestionMark(int choice) {
		if(choice==1) {
			btnQuestionMark1.setVisible(true);
			btnQuestionMark2.setVisible(false);
			btnQuestionMark3.setVisible(false);
		}
		else if(choice==2){
			btnQuestionMark1.setVisible(false);
			btnQuestionMark2.setVisible(true);
			btnQuestionMark3.setVisible(false);
		}
		else if(choice==3) {
			btnQuestionMark1.setVisible(false);
			btnQuestionMark2.setVisible(false);
			btnQuestionMark3.setVisible(true);
		}
		
	}
	
	
	public Label getLbCorrectAS() {
		if(lbCorrectAS == null) {
			lbCorrectAS = new Label("The correct answer was :"+" réponse");
		}
		return lbCorrectAS;
	}
	
	public Label getLblTimer() {
		if(lblTimer == null) {
			lblTimer = new Label(""+Constants.TIMER_START);
		}
		return lblTimer;
	}
	
	public void goTimer() {
		if(timeline != null) {
			timeline.stop();
		}
		timeSeconds.set(Constants.TIMER_START);
		lblTimer.setText(""+timeSeconds.get());
		timeline = new Timeline(0);
		timeline.setCycleCount(Constants.TIMER_START);
        timeline.getKeyFrames().add(
                new KeyFrame(Duration.seconds(1),
                  new EventHandler<ActionEvent>() {
					public void handle(ActionEvent e) {
						// TODO Auto-generated method stub
						timeSeconds.set(timeSeconds.get()-1);
                        // update timerLabel
                        lblTimer.setText(""+timeSeconds.get());
                        if(timeSeconds.get() <= Constants.TIMER_LIMIT) {
                        	getLblTimer().setTextFill(Color.RED);
                        }
					}
                }));
		timeline.playFromStart();
		timeline.setOnFinished(getClickBtn());
	}
	
	public EventHandler<ActionEvent> getClickBtn() {
		if(clickBtn == null) {
			clickBtn = new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					setAnswer();
		        	SceneManager.getGameOperation().answerVerification();
		        	timeline.stop();
				}
			};
		}
		getTfAnswer().clear();
		return clickBtn;
	}
}	

