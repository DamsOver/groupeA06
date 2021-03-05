package vue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import application.SceneManager;
import javafx.animation.PauseTransition;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.util.Duration;
import model.GameOperation;
import util.Constants;


public class AddPlayersAP extends AnchorPane {
	private int nbPl;
	private final int MIN_PLAYER = 2, MAX_PLAYER =8;
	private List<String> playerNames;
	
	private Text txtTitle,txtNbPlayer;

	private Button btnBack,btnStart,arrowUp,arrowDown;

	private Slider slPlayer;
	
	private List<Text> texts ;
	private List<TextField> textfds;
	

	public AddPlayersAP() {
		setNbPl(MIN_PLAYER);
		this.getStyleClass().add("pane");
		this.getChildren().addAll(getTxtTitle(), getBtnBack(),getBtnStart(),getTxtNbPlayer(),getArrowUp(),getArrowDown());
		this.getChildren().addAll(getTexts());
		this.getChildren().addAll(getTextfds());
		// title
		txtTitle.getStyleClass().add("title-style");
		AnchorPane.setTopAnchor(getTxtTitle(), 80.0);
		AnchorPane.setRightAnchor(getTxtTitle(), 600.0);
		AnchorPane.setLeftAnchor(getTxtTitle(), 600.0);
		
		//BtnStart
		btnStart.getStyleClass().add("btn-style");
		AnchorPane.setTopAnchor(getBtnStart(), 900.0);
		AnchorPane.setRightAnchor(getBtnStart(), 1600.0);
		AnchorPane.setLeftAnchor(getBtnStart(), 50.0);
		
		//BtnBack
		btnBack.getStyleClass().add("btn-style");
		AnchorPane.setTopAnchor(getBtnBack(), 900.0);
		AnchorPane.setRightAnchor(getBtnBack(), 50.0);
		AnchorPane.setLeftAnchor(getBtnBack(),1600.0);
		
		//NbPlayer
		txtNbPlayer.getStyleClass().add("h1");
		AnchorPane.setTopAnchor(getTxtNbPlayer(),300.0);
		AnchorPane.setRightAnchor(getTxtNbPlayer(), 700.0);
		AnchorPane.setLeftAnchor(getTxtNbPlayer(), 500.0);
		
		//ArrowUp
		arrowUp.getStyleClass().add("arrowUp");
		AnchorPane.setTopAnchor(getArrowUp(), 290.0);
		AnchorPane.setBottomAnchor(getArrowUp(), 690.0);
		AnchorPane.setRightAnchor(getArrowUp(), 1050.0);
		AnchorPane.setLeftAnchor(getArrowUp(), 850.0);
		
		//ArrowDown
		arrowDown.getStyleClass().add("arrowDown");
		AnchorPane.setTopAnchor(getArrowDown(), 290.0);
		AnchorPane.setBottomAnchor(getArrowDown(), 690.0);
		AnchorPane.setRightAnchor(getArrowDown(), 900.0);
		AnchorPane.setLeftAnchor(getArrowDown(),1000.0);
		
		toForm();
		hideOrShowPlayer();
		
	}

	public Text getTxtTitle() {
		if (txtTitle == null) {
			txtTitle = new Text("Add Players");
		}
		return txtTitle;
	}

	public Button getBtnBack() {
		if (btnBack == null) {
			btnBack = new Button("Back");
		}
		
		btnBack.setOnAction(new EventHandler<ActionEvent>(){
	        public void handle(ActionEvent event) {
	            SceneManager.getSceneRoot().setRoot(SceneManager.getStackRoot());
	        }
		});
		
		return btnBack;
	}

	public Button getBtnStart() {
		if (btnStart == null) {
			btnStart = new Button("Start");
		}
		
		btnStart.setOnAction(new EventHandler<ActionEvent>(){
	        public void handle(ActionEvent event) {
	        	setPlayerNames();
	        	if(!checkTxtField()) {
	        		//afficher un message pour allerter qu'une textBox est vide
	        		
	        	}
	        	else {

	        		SceneManager.getTransitionAnimation().setTxtAnimation("It's Damien's turn !");
	        		SceneManager.getSceneRoot().setRoot(SceneManager.getStackTransititionAnimation());
	        		
	        		PauseTransition pause = new PauseTransition(Duration.seconds(3));
	                pause.setOnFinished(
	                    e -> SceneManager.getSceneRoot().setRoot(SceneManager.getStackRating())
	                    );
	                pause.play();
	        		
	        		
//	        		SceneManager.getSceneRoot().setRoot(SceneManager.getStackTransititionAnimation());
	        		
	        		
//		        	SceneManager.getTransitionAnimation().setTxtAnimation("The game starts!");
//		        	SceneManager.transition(SceneManager.getStackTransititionAnimation(), SceneManager.getStackGame(),Constants.TIME_ANIMATION);

		        	//SceneManager.getTransitionAnimation().setTxtAnimation("It's "+ getPlayerNames().get(0) +"'s turn!");
		        	//GameOperation.skipMilliseconds(Constants.TIME_ANIMATION,SceneManager.getStackTransititionAnimation(), SceneManager.getStackGame());
		        }
	        }
		});
		
		return btnStart;
	}

	public Text getTxtNbPlayer() {
		if (txtNbPlayer == null) {
			txtNbPlayer = new Text(getNbPl()+" Players  : ");
		}
		return txtNbPlayer;
	}
	
	public Button getArrowUp() {
		if (arrowUp == null) {
			arrowUp = new Button();
		}
		arrowUp.setOnAction(new EventHandler<ActionEvent>(){
	        public void handle(ActionEvent event) {
	        	setNbPl(getNbPl()+1);
	        	getTxtNbPlayer().setText(getNbPl()+" Players  : ");
	        	hideOrShowPlayer();
	        }
		});
		return arrowUp;
	} 
	
	public Button getArrowDown() {
		if (arrowDown == null) {
			arrowDown = new Button();
		}
		arrowDown.setOnAction(new EventHandler<ActionEvent>(){
	        public void handle(ActionEvent event) {
	        	setNbPl(getNbPl()-1);
	        	getTxtNbPlayer().setText(getNbPl()+" Players  : ");
	        	hideOrShowPlayer();
	        }
		});
		return arrowDown;
	}


	
	public Slider getSlPlayer() {
		if (slPlayer == null) {
			slPlayer = new Slider();
		}
		return slPlayer;
	}
	public int getNbPl() {
		return nbPl;
	}

	public void setNbPl(int nb) {
		if(nb <MIN_PLAYER) {
			nbPl= MIN_PLAYER;
		}
		else if(nb>MAX_PLAYER){
			nbPl=MAX_PLAYER;
		}
		else {
			nbPl = nb;
		}
	}
	
	public List<Text> getTexts(){
		if(texts == null) {
			texts = new ArrayList<>();
			for(int i=MIN_PLAYER-2; i<MAX_PLAYER; i++) {
				texts.add(new Text("Player "+(i+1)+" : "));
			}
		}
		return texts;
	}
	
	public List<TextField> getTextfds(){
		if(textfds == null) {
			textfds = new ArrayList<>();
			for(int i=MIN_PLAYER-2; i<MAX_PLAYER; i++) {
				textfds.add(new TextField());
				textfds.get(i).setPromptText("name");
			}
		}
		return textfds;
	}
	//private pour pas modifier ailleurs dans le code
	private void setPlayerNames() {
		playerNames = new ArrayList<>();
		for(int i=MIN_PLAYER-2; i<getNbPl(); i++) {
			playerNames.add(getTextfds().get(i).getText());
		}
	}
	public List<String> getPlayerNames() {
		if(playerNames == null) {
			setPlayerNames();
		}
		return playerNames;
	}
	
	public void toForm() {
		double topfp = 315.0;
		double toptxt = 320.;
		double topAdd = 110.;
		for(int i=MIN_PLAYER-2; i<MAX_PLAYER; i++) {
			//ajout des fonctionnalité
			getTexts().get(i).getStyleClass().add("txtAddPlayer");
			getTexts().get(i).opacityProperty().bind(Bindings.when(getTexts().get(i).disabledProperty()).then(0.4).otherwise(1));
			
			getTextfds().get(i).getStyleClass().add("txtField");
			getTextfds().get(i).opacityProperty().bind(Bindings.when(getTextfds().get(i).disabledProperty()).then(0.4).otherwise(1));
			
			//mise ne forme
			if((i+1)%2==0) {
				//nb joueur pair : right anchor = 200 pour textfield
				AnchorPane.setRightAnchor(getTextfds().get(i), 200.0);
				//left anchor = 1350 pour txtfield
				AnchorPane.setLeftAnchor(getTextfds().get(i), 1350.0);
				//left anchor = 1100 pour text
				AnchorPane.setLeftAnchor(getTexts().get(i), 1100.0);
				AnchorPane.setRightAnchor(getTexts().get(i),600.0);
			}
			else {
				//nbJoueur impaire : right anchor = 1200 pour textfield
				AnchorPane.setRightAnchor(getTextfds().get(i), 1200.0);
				//left anchor = 350 pour txtfield
				AnchorPane.setLeftAnchor(getTextfds().get(i),350.0);

				//left anchor = 100 pour text
				AnchorPane.setLeftAnchor(getTexts().get(i), 100.0);
				AnchorPane.setRightAnchor(getTexts().get(i),1600.0);
				//top selon la regle des plus 110
				topfp+=topAdd;
				toptxt+=topAdd;
			}
			//tous ont le meme top (selon leur type) qui augmente de 110 à chaque ligne
			AnchorPane.setTopAnchor(getTexts().get(i), toptxt);
			AnchorPane.setTopAnchor(getTextfds().get(i), topfp);		
		}
	}
	public void hideOrShowPlayer() {
		for(int i=MIN_PLAYER-1; i<MAX_PLAYER; i++) {
			
			if(i< getNbPl()) {
				getTexts().get(i).setDisable(false);
				getTextfds().get(i).setDisable(false);
			}
			else {
				getTexts().get(i).setDisable(true);
				getTextfds().get(i).setDisable(true);
			}
		}
	}
	public boolean checkTxtField() {
		for(int i=MIN_PLAYER-2; i<getNbPl(); i++) {
			if(getTextfds().get(i).getText().isEmpty()) {
				return false;
			}
		}
		return true;
	}
}
