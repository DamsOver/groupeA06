package vue;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonParser;

import application.SceneManager;
import enumerations.Theme;
import exceptions.AlreadyPresentException;
import exceptions.TooManyException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import model.Question;
import serialisation.Serialisation;
import util.Constants;

public class AddCardsAP extends AnchorPane {
	private final int NB_QUESTION = 4;
	private Boolean modification = false;
	private BasicCard bc;
	
	private Text txtTitle;

	private Text txtTheme;
	private Label lblAuthor;
	private Label lblSubject;
	private ComboBox<String> cbTheme;
	private TextField txtFAuthor;
	private TextField txtFSubject;

	private Label lblChallenges;
	private Label lblAnswer;

	private ArrayList<Label> lblEachChallenges;
	private ArrayList<TextField> txtFEachChallenges;
	private ArrayList<Label>	lblEachAnswers;
	private ArrayList<TextField> txtFEachAnswers;

	private Button btnErase;
	private Button btnSubmit;
	private Button btnBack;

	private ObservableList<String> listIgnore = FXCollections.observableArrayList("START", "FINISH", "SPECIAL");
	public AddCardsAP() {

		this.getStyleClass().add("pane");
		this.getChildren().addAll(getTxtTitle(), getBtnBack(), getBtnErase(), getBtnSubmit(), getTxtTheme(),
				getCbTheme(), getLblAuthor(), getTxtFAuthor(), getLblSubject(), getTxtFSubject(), getLblChallenges(), getLblAnswer());
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
//		cbTheme.setItems(FXCollections.observableArrayList("IMPROBABLE", "PLEASURE", "INFORMATICS", "SCHOOL"));
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
		//use list of Nodes and form its
		toForm();

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
	
	public void loadCard(BasicCard b) {
		bc = b;
		getTxtFAuthor().setText(bc.getAuthor());
		getTxtFSubject().setText(bc.getSubject());
		getCbTheme().setValue(bc.getTheme().toString());
		for(int i =0; i<NB_QUESTION; i++) {
			getTxtFEachChallenges().get(i).setText(bc.getQuestions().get(i).getChallenge());
			getTxtFEachAnswers().get(i).setText(bc.getQuestions().get(i).getAnswer());
		}
		modification= true;
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
			for(Theme t : Theme.values()) {
			if(!listIgnore.contains(t.name())) {
					cbTheme.getItems().add(t.name());
				}
			}
			cbTheme.setValue(cbTheme.getItems().get(0).toString());
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
			setEachLabel(lblEachAnswers);
		}
		return lblEachAnswers;
	}
	public ArrayList<Label> getLblEachChallenges() {
		if (lblEachChallenges == null) {
			lblEachChallenges = new ArrayList<>();
			setEachLabel(lblEachChallenges);
		}
		return lblEachChallenges;
	}
	//create each Label
	public void setEachLabel(ArrayList<Label> list) {
		for(int i= 0; i< NB_QUESTION; i++) {
			list.add(new Label((i+1)+" : "));
		}
	}

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
	//create each textField
	public void setEachTextField(ArrayList<TextField> list) {
		for(int i= 0; i< NB_QUESTION; i++){
			list.add(new TextField());
		}
	}
	
	public TextField getTxtFAuthor() {
		if (txtFAuthor == null) {
			txtFAuthor = new TextField();
		}
		return txtFAuthor;
	}

	public TextField getTxtFSubject() {
		if (txtFSubject == null) {
			txtFSubject = new TextField();
		}
		return txtFSubject;
	}

	public Button getBtnErase() {
		if (btnErase == null) {
			btnErase = new Button("Erase");
		}
		btnErase.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				removeText();
			}
		});
		return btnErase;
	}

	public Button getBtnSubmit() {
		if (btnSubmit == null) {
			btnSubmit = new Button("Submit");
		}
		btnSubmit.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				if(checkTextField()) {
					//create new Basic card
					BasicCard bc = new BasicCard(getTxtFAuthor().getText(), 
												Theme.getTheme(cbTheme.getValue()), 
												getTxtFSubject().getText());
					//get questions
					for(int i= 0; i< NB_QUESTION; i++) {
						//add and create questions
						try {
							bc.addQuestion(getTxtFEachChallenges().get(i).getText(), getTxtFEachAnswers().get(i).getText());
						} catch (AlreadyPresentException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (TooManyException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
					Deck deck = new Deck().fromJson();
					//System.out.println(deck.toString());
					if(modification) {
						//update
						int index= deck.getBasicCards().indexOf(bc);
						deck.getBasicCards().remove(index);
						deck.getBasicCards().add(index, bc);
						System.out.println("Modification");
					}
					else {
						try {
							deck.addBasicCard(bc);						
						} catch (AlreadyPresentException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					//System.out.println(deck.toString());
					Serialisation.saveDeckClear(deck, Constants.DECK_PATH);
					removeText();
				
			}
		}
	});
	return btnSubmit;
	}

public Button getBtnBack() {
		if (btnBack == null) {
			btnBack = new Button("Back");
		}
		btnBack.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				SceneManager.getSceneRoot().setRoot(SceneManager.getStackCardsManager());
				removeText();
			}
		});
		return btnBack;
	}
	
	public void toForm() {
		//Basis position
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
			
			//form
			getLblEachChallenges().get(i).getStyleClass().add("basicText");
			getLblEachAnswers().get(i).getStyleClass().add("basicText");
			getTxtFEachAnswers().get(i).getStyleClass().add("txtField");
			getTxtFEachChallenges().get(i).getStyleClass().add("txtField");
		}
	}
	
	public boolean checkTextField() {
		for(int i= 0; i< NB_QUESTION; i++) {
			if(getTxtFEachAnswers().get(i).getText().isBlank() || getTxtFEachChallenges().get(i).getText().isBlank()) {
				return false;
			}
		}
		if(getTxtFAuthor().getText().isBlank() || getTxtFSubject().getText().isBlank()) {
			return false;
		}
		return true;
	}
	public void removeText() {
		for(int i= 0; i< NB_QUESTION; i++) {
			getTxtFEachAnswers().get(i).setText("");
			getTxtFEachChallenges().get(i).setText("");
		}
		getTxtFAuthor().setText("");
		getTxtFSubject().setText("");
	}
}
