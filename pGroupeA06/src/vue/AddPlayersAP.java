package vue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import application.SceneManager;
import javafx.animation.PauseTransition;
import javafx.animation.Transition;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.util.Duration;
import model.Game;
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
	
	private static List<ImageView> listImageView;

	public AddPlayersAP() {
		setNbPl(MIN_PLAYER);
		this.getStyleClass().add("pane");
		this.getChildren().addAll(getTxtTitle(), getBtnBack(),getBtnStart(),getTxtNbPlayer(),getArrowUp(),getArrowDown());
		this.getChildren().addAll(getTexts());
		this.getChildren().addAll(getTextfds());
		this.getChildren().addAll(getIvPlayer());
		// title
		txtTitle.getStyleClass().add("title-style");
		AnchorPane.setTopAnchor(getTxtTitle(), 80.0);
		AnchorPane.setRightAnchor(getTxtTitle(), 600.0);
		AnchorPane.setLeftAnchor(getTxtTitle(), 600.0);
		
		//BtnStart
		btnStart.getStyleClass().add("btn-style");
		AnchorPane.setTopAnchor(getBtnStart(), 900.0);
		AnchorPane.setRightAnchor(getBtnStart(), 1600.0);
		AnchorPane.setLeftAnchor(getBtnStart(), 100.0);
		
		//BtnBack
		btnBack.getStyleClass().add("btn-style");
		AnchorPane.setTopAnchor(getBtnBack(), 900.0);
		AnchorPane.setRightAnchor(getBtnBack(), 100.0);
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
	        	//getting the players names
	        	setPlayerNames();
	        	if(!checkTxtFieldEmpty()) {
	        		SceneManager.getTransitionAnimation().setTxtAnimation("Some fields are empty!");
	        		 SceneManager.getSceneRoot().setRoot(SceneManager.getStackTransititionAnimation());
	        		Transition pause1 = SceneManager.getGameOperation().animation(Constants.ANIMATION_TIME_ERROR,SceneManager.getStackAddPlayers(),null);
	        		pause1.play();
	        	}
	        	else if(!checkTxtFieldDuplicate()){
	        		SceneManager.getTransitionAnimation().setTxtAnimation("Each names \nmust be different!");
	        		SceneManager.getSceneRoot().setRoot(SceneManager.getStackTransititionAnimation());
	        		Transition pause1 = SceneManager.getGameOperation().animation(Constants.ANIMATION_TIME_ERROR,SceneManager.getStackAddPlayers(),null);
	        		pause1.play();
	        	}
	        	else {
	        		//checking if it's the first turn off the game (if there are no players and it's turn 0)
	        		if(SceneManager.getGameOperation().getGame().getPlayers().size()==0&&SceneManager.getGameOperation().getGame().getTurn()==0) {
	        			GameOperation.addPlayers(getPlayerNames());
	        			SceneManager.getGameOperation().getGame().setPlayerVisible();
	        			SceneManager.getGameOperation().turnRating(true,null);
		        		
	        		}
	        		else {
	        			SceneManager.getGameOperation().getGame().setPlayerVisible();
	        			SceneManager.getGameOperation().turnRating(false,null);
	        		}
	        		
	                	      
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
		//basis positions 
		double topfp = 315.0, toptxt = 320., topImg = 290., topAdd = 110.;
		double leftTxt = 100., addLeftTxtToTF = 250.;
		double rightTF = 200., addRightTFToTxt= 400.;
		double leftTxtToImg = addLeftTxtToTF - leftTxt; // 150.
		double addLeftToRight = 1000. ;
		
		for(int i=MIN_PLAYER-2; i<MAX_PLAYER; i++) {
			//ajout des fonctionnalité
			getTexts().get(i).getStyleClass().add("txtAddPlayer");
			getTexts().get(i).opacityProperty().bind(Bindings.when(getTexts().get(i).disabledProperty()).then(0.4).otherwise(1));
			
			getTextfds().get(i).getStyleClass().add("txtField");
			getTextfds().get(i).opacityProperty().bind(Bindings.when(getTextfds().get(i).disabledProperty()).then(0.4).otherwise(1));
			
			//form
			if((i+1)%2==0) {
				//Right column
				AnchorPane.setRightAnchor(getTextfds().get(i), rightTF);
				AnchorPane.setLeftAnchor(getTextfds().get(i), leftTxt +addLeftToRight + addLeftTxtToTF);
				
				AnchorPane.setLeftAnchor(getTexts().get(i), leftTxt +addLeftToRight);
				AnchorPane.setRightAnchor(getTexts().get(i),rightTF + addRightTFToTxt);
				
				AnchorPane.setLeftAnchor(getIvPlayer().get(i), leftTxt+leftTxtToImg + addLeftToRight);
			}
			else {
				//Left column
				AnchorPane.setRightAnchor(getTextfds().get(i), rightTF + addLeftToRight);
				AnchorPane.setLeftAnchor(getTextfds().get(i), leftTxt+addLeftTxtToTF);

				AnchorPane.setLeftAnchor(getTexts().get(i), leftTxt);
				AnchorPane.setRightAnchor(getTexts().get(i), rightTF + addRightTFToTxt + addLeftToRight);
				
				AnchorPane.setLeftAnchor(getIvPlayer().get(i), leftTxt+leftTxtToImg );
				//Top 
				topfp+=topAdd;
				toptxt+=topAdd;
				topImg+=topAdd;
			}
			//Top
			AnchorPane.setTopAnchor(getTexts().get(i), toptxt);
			AnchorPane.setTopAnchor(getTextfds().get(i), topfp);	
			AnchorPane.setTopAnchor(getIvPlayer().get(i), topImg);
		}
	}
	
	public void hideOrShowPlayer() {
		for(int i=MIN_PLAYER-1; i<MAX_PLAYER; i++) {
			
			if(i< getNbPl()) {
				getTexts().get(i).setDisable(false);
				getTextfds().get(i).setDisable(false);
				getIvPlayer().get(i).setVisible(true);
			}
			else {
				getTexts().get(i).setDisable(true);
				getTextfds().get(i).setDisable(true);
				getIvPlayer().get(i).setVisible(false);
			}
		}
	}
	public boolean checkTxtFieldEmpty() {
		String trimName;
		for(int i=MIN_PLAYER-2; i<getNbPl(); i++) {
			if(getTextfds().get(i).getText().isBlank()) {
				return false;
			}
			//remove blank
			trimName = getTextfds().get(i).getText().trim();
			getTextfds().get(i).setText(trimName);
			getPlayerNames().remove(i);
			getPlayerNames().add(i, trimName);
		}
		return true;
	}
	public boolean checkTxtFieldDuplicate(){
		for(int i=MIN_PLAYER-2; i<getNbPl()-1; i++) {
			for(int j = i+1; j<getNbPl(); j++) {
				if(getTextfds().get(i).getText().equalsIgnoreCase(getTextfds().get(j).getText())) {
					return false;
				}
			}
		}
		return true;
	}
	public List<ImageView> getIvPlayer() {
		
		if (listImageView==null) {
			listImageView = new ArrayList<ImageView>();
			for(int i = 0;i<=7;i++) {
				Image tmp = new Image(getClass().getResourceAsStream("/img/Player_0"+(i+1)+".png"));
				listImageView.add(new ImageView(tmp));
				listImageView.get(i).setFitHeight(Constants.PLAYER_HEIGHT);
				listImageView.get(i).setFitWidth(Constants.PLAYER_WIDTH);
			}
		}
		return listImageView;
	}
}
