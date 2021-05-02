package vue;

import application.SceneManager;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import model.Question;
import util.Constants;

public class QuestionAP extends AnchorPane {

	private Label lbTurn, lbCorrectAS, lblTimer,lbQuestion;
	
	private Button btnOK, btnQuestionMark;
	private TextField tfAnswer;

	private String answer;

	private IntegerProperty timeSeconds = new SimpleIntegerProperty(Constants.TIMER_START);
	private Timeline timeline;

	private EventHandler<ActionEvent> clickBtn;
	

	public QuestionAP() {
		this.getStyleClass().add("paneQuestion");
		this.getChildren().addAll(getLbTurn(), getBtnQuestionMark(), getLbQuestion(), getBtnOK(), getTfAnswer(),
				getLbCorrectAS(), getLblTimer());

		// lbTurn
		lbTurn.getStyleClass().add("title3-style");
		AnchorPane.setTopAnchor(getLbTurn(), 50.0);
		AnchorPane.setLeftAnchor(getLbTurn(), 150.0);

		// btnQuestionMark1
		btnQuestionMark.getStyleClass().add("qm1");
		enableQuestionMark(1);
		AnchorPane.setTopAnchor(getBtnQuestionMark(), 150.0);
		AnchorPane.setBottomAnchor(getBtnQuestionMark(), 500.0);
		AnchorPane.setLeftAnchor(getBtnQuestionMark(), 800.0);
		AnchorPane.setRightAnchor(getBtnQuestionMark(), 800.0);

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

		// CorrectAS
		lbCorrectAS.getStyleClass().add("answer");
		AnchorPane.setTopAnchor(getLbCorrectAS(), 775.0);
		AnchorPane.setRightAnchor(getLbCorrectAS(), 300.0);
		AnchorPane.setLeftAnchor(getLbCorrectAS(), 900.0);

		// timer
		getLblTimer().getStyleClass().add("timer");
		AnchorPane.setTopAnchor(getLblTimer(), 40.);
		AnchorPane.setRightAnchor(getLblTimer(), 40.);
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
			lbQuestion = new Label();
		}
		return lbQuestion;
	}

	public void setLbQuestion(Question q) {
		if (lbQuestion == null) {
			lbQuestion = new Label(q.getChallenge());
		} else {
			lbQuestion.setText(q.getChallenge());
		}
	}

	public void setLbTurn(String name) {
		if (lbTurn != null) {
			lbTurn.setText(name + "'s turn");
		}
	}

	public Button getBtnOK() {
		if (btnOK == null) {
			btnOK = new Button("OK");
		}
		btnOK.setOnAction(getClickBtn());
		return btnOK;
	}

	public EventHandler<ActionEvent> getClickBtn() {
		if (clickBtn == null) {
			clickBtn = new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {

					setAnswer();

					// verification
					SceneManager.getCurrentGame().answerVerification();
					timeline.stop();
					getBtnOK().setDisable(true);

				}
			};
		}
		getTfAnswer().clear();
		return clickBtn;
	}

	public void enableBtnOK(boolean choice) {
		btnOK.setVisible(choice);
	}

	public Button getBtnQuestionMark() {
		if (btnQuestionMark == null) {
			btnQuestionMark = new Button();
		}
		return btnQuestionMark;
	}

	public TextField getTfAnswer() {
		if (tfAnswer == null) {
			tfAnswer = new TextField();

		}	
		return tfAnswer;
	}
	
	public String getAnswer() {
		if (tfAnswer == null) {
			return null;
		}
		return answer;
	}

	public void setAnswer() {
		if (tfAnswer == null) {
			answer = null;
		} else {
			answer = tfAnswer.getText();
		}
	}

	public void setLbAnswer(Question q) {
		if (lbCorrectAS == null) {
			lbCorrectAS = new Label();
		}
		lbCorrectAS.setText(q.getAnswer());
	}

	public void enableLbAnswer(boolean activated) {
		if (lbCorrectAS == null) {
			lbCorrectAS = new Label();
		}
		if (activated) {
			lbCorrectAS.setVisible(true);
		} else {
			lbCorrectAS.setVisible(false);
		}
	}

	public void enableQuestionMark(int choice) {
		String path = "/img/interrogation_" + choice + ".png";
		String style = "-fx-background-image: url(\"" + path + "\");";
		btnQuestionMark.setStyle(style);
	}

	public Label getLbCorrectAS() {
		if (lbCorrectAS == null) {
			lbCorrectAS = new Label("The correct answer was :" + " réponse");
		}
		return lbCorrectAS;
	}

	public Label getLblTimer() {
		if (lblTimer == null) {
			lblTimer = new Label("" + Constants.TIMER_START);
			getLblTimer().setMaxWidth(Double.MAX_VALUE);
			getLblTimer().setAlignment(Pos.CENTER);
		}
		return lblTimer;
	}

	public void goTimer() {
		if (timeline != null) {
			timeline.stop();
		}
		timeSeconds.set(Constants.TIMER_START);
		lblTimer.setText("" + timeSeconds.get());
		timeline = new Timeline(0);
		timeline.setCycleCount(Constants.TIMER_START);
		timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				timeSeconds.set(timeSeconds.get() - 1);
				// update timerLabel
				lblTimer.setText("" + timeSeconds.get());
				if (timeSeconds.get() <= Constants.TIMER_LIMIT) {
					getLblTimer().setTextFill(Color.RED);
				}
			}
		}));
		timeline.playFromStart();
		timeline.setOnFinished(getClickBtn());
	}

}
