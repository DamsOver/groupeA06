package vue;

import java.util.ArrayList;
import java.util.List;

import application.SceneManager;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import model.BasicCard;
import model.Deck;
import model.Game;

public class AddCardsAP extends AnchorPane {
	private final int NB_QUESTION = 4;

	private static Game game;
	private static Deck deck;
	
	private Text txtTitle;

	private Text txtTheme;
	private Label lblAuthor;
	private Label lblSubject;
	private ComboBox<String> cbTheme;
//	private TextField txtFAuthor;
	private ComboBox<String> txtFAuthor;
	private TextField txtFSubject;

	private Label lblChallenges;
	private Label lblAnswer;

	private ArrayList<Label> lblEachChallenges;
	private ArrayList<TextField> txtFEachChallenges;
	private ArrayList<Label>	lblEachAnswers;
	private ArrayList<TextField> txtFEachAnswers;
	/*private Label lblChallenges1;
	private Label lblChallenges2;
	private Label lblChallenges3;
	private Label lblChallenges4;
	private TextField txtFChallenges1;
	private TextField txtFChallenges2;
	private TextField txtFChallenges3;
	private TextField txtFChallenges4;

	private Label lblAnswer1;
	private Label lblAnswer2;
	private Label lblAnswer3;
	private Label lblAnswer4;
	private TextField txtFAnswer1;
	private TextField txtFAnswer2;
	private TextField txtFAnswer3;
	private TextField txtFAnswer4;*/

	private Button btnErase;
	private Button btnSubmit;
	private Button btnBack;

	public AddCardsAP() {

		this.getStyleClass().add("pane");
		this.getChildren().addAll(getTxtTitle(), getBtnBack(), getBtnErase(), getBtnSubmit(), getTxtTheme(),
				getCbTheme(), getLblAuthor(), getTxtFAuthor(), getLblSubject(), getTxtFSubject(), getLblChallenges(), getLblAnswer()/*,
				getLblChallenges1(), getLblChallenges2(), getLblChallenges3(), getLblChallenges4(),
				getTxtFChallenges1(), getTxtFChallenges2(), getTxtFChallenges3(), getTxtFChallenges4(),
				getTxtFAnswer1(), getTxtFAnswer2(), getTxtFAnswer3(), getTxtFAnswer4(), getLblAnswer1(),
				getLblAnswer2(), getLblAnswer3(), getLblAnswer4()*/);
		this.getChildren().addAll(getLblEachAnswers());
		this.getChildren().addAll(getLblEachChallenges());
		this.getChildren().addAll(getTxtFEachAnswers()); 
		this.getChildren().addAll(getTxtFEachChallenges());

		// Title
		txtTitle.getStyleClass().add("title-style");
		AnchorPane.setTopAnchor(getTxtTitle(), 80.0);
		AnchorPane.setRightAnchor(getTxtTitle(), 600.0);
		AnchorPane.setLeftAnchor(getTxtTitle(), 600.0);

		// txtTheme
		txtTheme.getStyleClass().add("basicText");
		AnchorPane.setTopAnchor(getTxtTheme(), 330.0);
		AnchorPane.setLeftAnchor(getTxtTheme(), 100.0);

		// cbTheme
		cbTheme.getStyleClass().add("cbbox");
		AnchorPane.setTopAnchor(getCbTheme(), 325.0);
		AnchorPane.setLeftAnchor(getCbTheme(), 280.0);
		cbTheme.setItems(FXCollections.observableArrayList("IMPROBABLE", "PLEASURE", "INFORMATICS", "SCHOOL"));
		cbTheme.getSelectionModel().selectFirst();

		// lblAuthor
		lblAuthor.getStyleClass().add("basicText");
		AnchorPane.setTopAnchor(getLblAuthor(), 330.0);
		AnchorPane.setLeftAnchor(getLblAuthor(), 600.0);

		// txtFAuthor
		txtFAuthor.getStyleClass().add("txtField");
		AnchorPane.setTopAnchor(getTxtFAuthor(), 330.0);
		AnchorPane.setLeftAnchor(getTxtFAuthor(), 760.0);
		AnchorPane.setRightAnchor(getTxtFAuthor(), 800.0);

		// lblSubject
		lblSubject.getStyleClass().add("basicText");
		AnchorPane.setTopAnchor(getLblSubject(), 330.0);
		AnchorPane.setLeftAnchor(getLblSubject(), 1200.0);

		// txtFSubject
		txtFSubject.getStyleClass().add("txtField");
		AnchorPane.setTopAnchor(getTxtFSubject(), 330.0);
		AnchorPane.setLeftAnchor(getTxtFSubject(), 1380.0);
		AnchorPane.setRightAnchor(getTxtFSubject(), 150.0);

		// lblChallenges
		lblChallenges.getStyleClass().add("basicText");
		AnchorPane.setTopAnchor(getLblChallenges(), 430.0);
		AnchorPane.setLeftAnchor(getLblChallenges(), 100.0);
		
		// lblanswer
		lblAnswer.getStyleClass().add("basicText");
		AnchorPane.setTopAnchor(getLblAnswer(), 430.0);
		AnchorPane.setLeftAnchor(getLblAnswer(), 1000.0);
		
		toForm();
/*
		// lblChallenges1
		lblChallenges1.getStyleClass().add("basicText");
		AnchorPane.setTopAnchor(getLblChallenges1(), 510.0);
		AnchorPane.setLeftAnchor(getLblChallenges1(), 140.0);

		// lblChallenges2
		lblChallenges2.getStyleClass().add("basicText");
		AnchorPane.setTopAnchor(getLblChallenges2(), 600.0);
		AnchorPane.setLeftAnchor(getLblChallenges2(), 140.0);

		// lblChallenges3
		lblChallenges3.getStyleClass().add("basicText");
		AnchorPane.setTopAnchor(getLblChallenges3(), 690.0);
		AnchorPane.setLeftAnchor(getLblChallenges3(), 140.0);

		// lblChallenges4
		lblChallenges4.getStyleClass().add("basicText");
		AnchorPane.setTopAnchor(getLblChallenges4(), 780.0);
		AnchorPane.setLeftAnchor(getLblChallenges4(), 140.0);

		// txtFChallenges1
		txtFChallenges1.getStyleClass().add("txtField");
		AnchorPane.setTopAnchor(getTxtFChallenges1(), 510.0);
		AnchorPane.setLeftAnchor(getTxtFChallenges1(), 220.0);
		AnchorPane.setRightAnchor(getTxtFChallenges1(), 1100.0);

		// txtFChallenges2
		txtFChallenges2.getStyleClass().add("txtField");
		AnchorPane.setTopAnchor(getTxtFChallenges2(), 600.0);
		AnchorPane.setLeftAnchor(getTxtFChallenges2(), 220.0);
		AnchorPane.setRightAnchor(getTxtFChallenges2(), 1100.0);

		// txtFChallenges3
		txtFChallenges3.getStyleClass().add("txtField");
		AnchorPane.setTopAnchor(getTxtFChallenges3(), 690.0);
		AnchorPane.setLeftAnchor(getTxtFChallenges3(), 220.0);
		AnchorPane.setRightAnchor(getTxtFChallenges3(), 1100.0);

		// txtFChallenges4
		txtFChallenges4.getStyleClass().add("txtField");
		AnchorPane.setTopAnchor(getTxtFChallenges4(), 780.0);
		AnchorPane.setLeftAnchor(getTxtFChallenges4(), 220.0);
		AnchorPane.setRightAnchor(getTxtFChallenges4(), 1100.0);

		// lblAnswer1
		lblAnswer1.getStyleClass().add("basicText");
		AnchorPane.setTopAnchor(getLblAnswer1(), 510.0);
		AnchorPane.setLeftAnchor(getLblAnswer1(), 1040.0);

		// lblAnswer2
		lblAnswer2.getStyleClass().add("basicText");
		AnchorPane.setTopAnchor(getLblAnswer2(), 600.0);
		AnchorPane.setLeftAnchor(getLblAnswer2(), 1040.0);

		// lblAnswer3
		lblAnswer3.getStyleClass().add("basicText");
		AnchorPane.setTopAnchor(getLblAnswer3(), 690.0);
		AnchorPane.setLeftAnchor(getLblAnswer3(), 1040.0);

		// lblChallenges4
		lblAnswer4.getStyleClass().add("basicText");
		AnchorPane.setTopAnchor(getLblAnswer4(), 780.0);
		AnchorPane.setLeftAnchor(getLblAnswer4(), 1040.0);

		// txtFAnswer1
		txtFAnswer1.getStyleClass().add("txtField");
		AnchorPane.setTopAnchor(getTxtFAnswer1(), 510.0);
		AnchorPane.setLeftAnchor(getTxtFAnswer1(), 1120.0);
		AnchorPane.setRightAnchor(getTxtFAnswer1(), 100.0);

		// txtFAnswer2
		txtFAnswer2.getStyleClass().add("txtField");
		AnchorPane.setTopAnchor(getTxtFAnswer2(), 600.0);
		AnchorPane.setLeftAnchor(getTxtFAnswer2(), 1120.0);
		AnchorPane.setRightAnchor(getTxtFAnswer2(), 100.0);

		// txtFAnswer3
		txtFAnswer3.getStyleClass().add("txtField");
		AnchorPane.setTopAnchor(getTxtFAnswer3(), 690.0);
		AnchorPane.setLeftAnchor(getTxtFAnswer3(), 1120.0);
		AnchorPane.setRightAnchor(getTxtFAnswer3(), 100.0);

		// txtFAnswer4
		txtFAnswer4.getStyleClass().add("txtField");
		AnchorPane.setTopAnchor(getTxtFAnswer4(), 780.0);
		AnchorPane.setLeftAnchor(getTxtFAnswer4(), 1120.0);
		AnchorPane.setRightAnchor(getTxtFAnswer4(), 100.0);
*/
		// BtnErase
		btnSubmit.getStyleClass().add("btn-style");
		AnchorPane.setTopAnchor(getBtnSubmit(), 900.0);
		AnchorPane.setLeftAnchor(getBtnSubmit(), 400.0);

		// BtnErase
		btnErase.getStyleClass().add("btn-style");
		AnchorPane.setTopAnchor(getBtnErase(), 900.0);
		AnchorPane.setLeftAnchor(getBtnErase(), 100.0);

		// BtnBack
		btnBack.getStyleClass().add("btn-style");
		AnchorPane.setTopAnchor(getBtnBack(), 900.0);
		AnchorPane.setRightAnchor(getBtnBack(), 100.0);

	}

	public Text getTxtTitle() {
		if (txtTitle == null) {
			txtTitle = new Text("Add Cards");
		}
		return txtTitle;
	}

	public Text getTxtTheme() {
		if (txtTheme == null) {
			txtTheme = new Text("Theme : ");
		}
		return txtTheme;
	}

	public ComboBox<String> getCbTheme() {
		if (cbTheme == null) {
			cbTheme = new ComboBox<String>();
		}
		return cbTheme;
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

	public ArrayList<Label> getLblEachAnswers(){
		if(lblEachAnswers == null) {
			lblEachAnswers = new ArrayList<>();
			/*for(int i= 0; i<= NB_QUESTION; i++) {
				lblEachAnswers.add(new Label((i+1)+" : "));
			}*/
			setEachLabel(lblEachAnswers);
		}
		return lblEachAnswers;
	}
	public ArrayList<Label> getLblEachChallenges() {
		if (lblEachChallenges == null) {
			lblEachChallenges = new ArrayList<>();
			/*for(int i= 0; i<= NB_QUESTION; i++) {
				lblEachChallenges.add(new Label((i+1)+" : "));
			}*/
			setEachLabel(lblEachChallenges);
		}
		return lblEachChallenges;
	}
	
	public void setEachLabel(ArrayList<Label> list) {
		for(int i= 0; i<= NB_QUESTION; i++) {
			list.add(new Label((i+1)+" : "));
		}
	}
/*	public Label getLblAnswer1() {
		if (lblAnswer1 == null) {
			lblAnswer1 = new Label("1 : ");
		}
		return lblAnswer1;
	}

	public Label getLblAnswer2() {
		if (lblAnswer2 == null) {
			lblAnswer2 = new Label("2 : ");
		}
		return lblAnswer2;
	}

	public Label getLblAnswer3() {
		if (lblAnswer3 == null) {
			lblAnswer3 = new Label("3 : ");
		}
		return lblAnswer3;
	}

	public Label getLblAnswer4() {
		if (lblAnswer4 == null) {
			lblAnswer4 = new Label("4 : ");
		}
		return lblAnswer4;
	}
*/
	public Label getLblChallenges() {
		if (lblChallenges == null) {
			lblChallenges = new Label("Challenges : ");
		}
		return lblChallenges;
	}

	public Label getLblAnswer() {
		if (lblAnswer == null) {
			lblAnswer = new Label("Answers : ");
		}
		return lblAnswer;
	}
	
	public ArrayList<TextField> getTxtFEachAnswers() {
		if (txtFEachAnswers == null) {
			txtFEachAnswers = new ArrayList<>();
			setEachTextField(txtFEachAnswers);
			/*for(int i= 0; i<= NB_QUESTION; i++){
				txtFEachAnswers.add(new TextField());
			}*/
		}
		return txtFEachAnswers;
	}
	
	public ArrayList<TextField> getTxtFEachChallenges() {
		if (txtFEachChallenges == null) {
			txtFEachChallenges = new ArrayList<>();
			setEachTextField(txtFEachChallenges);
		}
		return txtFEachChallenges;
	}
	
	public void setEachTextField(ArrayList<TextField> list) {
		for(int i= 0; i<= NB_QUESTION; i++){
			list.add(new TextField());
		}
	}
	
/*
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
*/
	/*public TextField getTxtFAuthor() {
		if (txtFAuthor == null) {
			txtFAuthor = new TextField();
		}
		return txtFAuthor;
	}*/

	public ComboBox<String> getTxtFAuthor() {
		if (txtFAuthor == null) {
			txtFAuthor = new ComboBox<String>();
			txtFAuthor.setEditable(true);
			game = new Game();
			deck = game.getDeck();
			for(BasicCard bc : deck.getBasicCards()) {
				if(!txtFAuthor.getItems().contains(bc.getAuthor())) {
					txtFAuthor.getItems().add(bc.getAuthor());
				}
			}
		}
		return txtFAuthor;
	}

	public TextField getTxtFSubject() {
		if (txtFSubject == null) {
			txtFSubject = new TextField();
		}
		return txtFSubject;
	}
/*
	public TextField getTxtFChallenges1() {
		if (txtFChallenges1 == null) {
			txtFChallenges1 = new TextField();
		}
		return txtFChallenges1;
	}

	public TextField getTxtFChallenges2() {
		if (txtFChallenges2 == null) {
			txtFChallenges2 = new TextField();
		}
		return txtFChallenges2;
	}

	public TextField getTxtFChallenges3() {
		if (txtFChallenges3 == null) {
			txtFChallenges3 = new TextField();
		}
		return txtFChallenges3;
	}

	public TextField getTxtFChallenges4() {
		if (txtFChallenges4 == null) {
			txtFChallenges4 = new TextField();
		}
		return txtFChallenges4;
	}

	public TextField getTxtFAnswer1() {
		if (txtFAnswer1 == null) {
			txtFAnswer1 = new TextField();
		}
		return txtFAnswer1;
	}

	public TextField getTxtFAnswer2() {
		if (txtFAnswer2 == null) {
			txtFAnswer2 = new TextField();
		}
		return txtFAnswer2;
	}

	public TextField getTxtFAnswer3() {
		if (txtFAnswer3 == null) {
			txtFAnswer3 = new TextField();
		}
		return txtFAnswer3;
	}

	public TextField getTxtFAnswer4() {
		if (txtFAnswer4 == null) {
			txtFAnswer4 = new TextField();
		}
		return txtFAnswer4;
	}
*/
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

	public Button getBtnBack() {
		if (btnBack == null) {
			btnBack = new Button("Back");
		}
		btnBack.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				SceneManager.getSceneRoot().setRoot(SceneManager.getStackCardsManager());
			}
		});
		return btnBack;
	}
	
	public void toForm() {
		double top = 510, addTop = 90;
		double TFChallRight = 1000, TFAnsRight = 100;
		double LBLChallLeft = 140, addChallToAnsLeft =900, addLblToTFLeft = 80;
		for(int i= 0; i< NB_QUESTION; i++) {
			//top
			AnchorPane.setTopAnchor(getLblEachAnswers().get(i), top);
			AnchorPane.setTopAnchor(getLblEachChallenges().get(i), top);
			AnchorPane.setTopAnchor(getTxtFEachAnswers().get(i), top);
			AnchorPane.setTopAnchor(getTxtFEachChallenges().get(i), top);
			top+=addTop;
			
			//Left
			AnchorPane.setLeftAnchor(getLblEachChallenges().get(i), LBLChallLeft );
			AnchorPane.setLeftAnchor(getTxtFEachChallenges().get(i), LBLChallLeft + addLblToTFLeft );
			AnchorPane.setLeftAnchor(getLblEachAnswers().get(i), LBLChallLeft  + addChallToAnsLeft);
			AnchorPane.setLeftAnchor(getTxtFEachAnswers().get(i), LBLChallLeft + addChallToAnsLeft + addLblToTFLeft);
			
			//right
			AnchorPane.setRightAnchor(getTxtFEachChallenges().get(i), TFChallRight);
			AnchorPane.setRightAnchor(getTxtFEachAnswers().get(i), TFAnsRight);
			
			//for
			getLblEachChallenges().get(i).getStyleClass().add("basicText");
			getLblEachAnswers().get(i).getStyleClass().add("basicText");
			getTxtFEachAnswers().get(i).getStyleClass().add("txtField");
			getTxtFEachChallenges().get(i).getStyleClass().add("txtField");
		}
	}
}
