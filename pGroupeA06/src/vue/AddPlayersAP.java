package vue;

import javafx.beans.binding.Bindings;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class AddPlayersAP extends AnchorPane {

	private Text txtTitle,txtPlayer1,txtPlayer2,txtPlayer3,txtPlayer4,txtPlayer5,txtPlayer6,txtPlayer7,txtPlayer8,txtNbPlayer;

	private TextField txtFPlayer1,txtFPlayer2,txtFPlayer3,txtFPlayer4,txtFPlayer5,txtFPlayer6,txtFPlayer7,txtFPlayer8;

	private Button btnBack,btnStart,arrowUp,arrowDown;

	private Slider slPlayer;
	
	

	public AddPlayersAP() {

		this.getChildren().addAll(getTxtTitle(), getBtnBack(),getBtnStart(),getTxtNbPlayer(),getArrowUp(),getArrowDown(),
				getTxtPlayer1(),getTxtPlayer2(),getTxtPlayer3(),getTxtPlayer4(),getTxtPlayer5(),getTxtPlayer6(),getTxtPlayer7(),getTxtPlayer8(),
				getTxtFPlayer1(),getTxtFPlayer2(),getTxtFPlayer3(),getTxtFPlayer4(),getTxtFPlayer5(),getTxtFPlayer6(),getTxtFPlayer7(),getTxtFPlayer8());

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
		AnchorPane.setRightAnchor(getArrowUp(), 970.0);
		AnchorPane.setLeftAnchor(getArrowUp(), 850.0);
		
		//ArrowDown
		arrowDown.getStyleClass().add("arrowDown");
		AnchorPane.setTopAnchor(getArrowDown(), 290.0);
		AnchorPane.setBottomAnchor(getArrowDown(), 690.0);
		AnchorPane.setRightAnchor(getArrowDown(), 820.0);
		AnchorPane.setLeftAnchor(getArrowDown(),1000.0);
		
		
		//TxtPlayer1
		txtPlayer1.getStyleClass().add("txtAddPlayer");
		AnchorPane.setTopAnchor(getTxtPlayer1(),430.0);
		AnchorPane.setRightAnchor(getTxtPlayer1(), 1400.0);
		AnchorPane.setLeftAnchor(getTxtPlayer1(), 275.0);
		txtPlayer1.opacityProperty().bind(Bindings.when(txtPlayer1.disabledProperty()).then(0.4).otherwise(1));
		
		//TxtPlayer3
		txtPlayer3.getStyleClass().add("txtAddPlayer");
		AnchorPane.setTopAnchor(getTxtPlayer3(),540.0);
		AnchorPane.setRightAnchor(getTxtPlayer3(), 1400.0);
		AnchorPane.setLeftAnchor(getTxtPlayer3(), 275.0);
		txtPlayer3.opacityProperty().bind(Bindings.when(txtPlayer3.disabledProperty()).then(0.4).otherwise(1));
		txtPlayer3.setDisable(true);
		
		//TxtPlayer5
		txtPlayer5.getStyleClass().add("txtAddPlayer");
		AnchorPane.setTopAnchor(getTxtPlayer5(),650.0);
		AnchorPane.setRightAnchor(getTxtPlayer5(), 1400.0);
		AnchorPane.setLeftAnchor(getTxtPlayer5(), 275.0);
		txtPlayer5.opacityProperty().bind(Bindings.when(txtPlayer5.disabledProperty()).then(0.4).otherwise(1));
		txtPlayer5.setDisable(true);
		
		//TxtPlayer7
		txtPlayer7.getStyleClass().add("txtAddPlayer");
		AnchorPane.setTopAnchor(getTxtPlayer7(),760.0);
		AnchorPane.setRightAnchor(getTxtPlayer7(), 1400.0);
		AnchorPane.setLeftAnchor(getTxtPlayer7(), 275.0);
		txtPlayer7.opacityProperty().bind(Bindings.when(txtPlayer7.disabledProperty()).then(0.4).otherwise(1));
		txtPlayer7.setDisable(true);
		
		//TxtFPlayer2
		txtPlayer2.getStyleClass().add("txtAddPlayer");
		AnchorPane.setTopAnchor(getTxtPlayer2(),430.0);
		AnchorPane.setRightAnchor(getTxtPlayer2(), 1400.0);
		AnchorPane.setLeftAnchor(getTxtPlayer2(), 1100.0);
		txtPlayer2.opacityProperty().bind(Bindings.when(txtPlayer2.disabledProperty()).then(0.4).otherwise(1));
		
		//TxtPlayer4
		txtPlayer4.getStyleClass().add("txtAddPlayer");
		AnchorPane.setTopAnchor(getTxtPlayer4(),540.0);
		AnchorPane.setRightAnchor(getTxtPlayer4(), 1400.0);
		AnchorPane.setLeftAnchor(getTxtPlayer4(), 1100.0);
		txtPlayer4.opacityProperty().bind(Bindings.when(txtPlayer4.disabledProperty()).then(0.4).otherwise(1));
		txtPlayer4.setDisable(true);
		
		//TxtPlayer6
		txtPlayer6.getStyleClass().add("txtAddPlayer");
		AnchorPane.setTopAnchor(getTxtPlayer6(),650.0);
		AnchorPane.setRightAnchor(getTxtPlayer6(), 1400.0);
		AnchorPane.setLeftAnchor(getTxtPlayer6(), 1100.0);
		txtPlayer6.opacityProperty().bind(Bindings.when(txtPlayer6.disabledProperty()).then(0.4).otherwise(1));
		txtPlayer6.setDisable(true);
		
		//TxtPlayer8
		txtPlayer8.getStyleClass().add("txtAddPlayer");
		AnchorPane.setTopAnchor(getTxtPlayer8(),760.0);
		AnchorPane.setRightAnchor(getTxtPlayer8(), 1400.0);
		AnchorPane.setLeftAnchor(getTxtPlayer8(), 1100.0);
		txtPlayer8.opacityProperty().bind(Bindings.when(txtPlayer8.disabledProperty()).then(0.4).otherwise(1));
		txtPlayer8.setDisable(true);
		
		//TxtFPlayer1
		txtFPlayer1.getStyleClass().add("txtField");
		AnchorPane.setTopAnchor(getTxtFPlayer1(),425.0);
		AnchorPane.setRightAnchor(getTxtFPlayer1(), 1100.0);
		AnchorPane.setLeftAnchor(getTxtFPlayer1(), 460.0);
		txtFPlayer1.opacityProperty().bind(Bindings.when(txtFPlayer1.disabledProperty()).then(0.4).otherwise(1));
		
		//TxtFPlayer2
		txtFPlayer2.getStyleClass().add("txtField");
		AnchorPane.setTopAnchor(getTxtFPlayer2(),425.0);
		AnchorPane.setRightAnchor(getTxtFPlayer2(), 260.0);
		AnchorPane.setLeftAnchor(getTxtFPlayer2(), 1300.0);
		txtFPlayer2.opacityProperty().bind(Bindings.when(txtFPlayer2.disabledProperty()).then(0.4).otherwise(1));
		
		//TxtFPlayer3
		txtFPlayer3.getStyleClass().add("txtField");
		AnchorPane.setTopAnchor(getTxtFPlayer3(),535.0);
		AnchorPane.setRightAnchor(getTxtFPlayer3(), 1100.0);
		AnchorPane.setLeftAnchor(getTxtFPlayer3(), 460.0);
		txtFPlayer3.opacityProperty().bind(Bindings.when(txtFPlayer3.disabledProperty()).then(0.4).otherwise(1));
		txtFPlayer3.setDisable(true);
		
		//TxtFPlayer5
		txtFPlayer5.getStyleClass().add("txtField");
		AnchorPane.setTopAnchor(getTxtFPlayer5(),645.0);
		AnchorPane.setRightAnchor(getTxtFPlayer5(), 1100.0);
		AnchorPane.setLeftAnchor(getTxtFPlayer5(), 460.0);
		txtFPlayer5.opacityProperty().bind(Bindings.when(txtFPlayer5.disabledProperty()).then(0.4).otherwise(1));
		txtFPlayer5.setDisable(true);
		
		//TxtFPlayer7
		txtFPlayer7.getStyleClass().add("txtField");
		AnchorPane.setTopAnchor(getTxtFPlayer7(),755.0);
		AnchorPane.setRightAnchor(getTxtFPlayer7(), 1100.0);
		AnchorPane.setLeftAnchor(getTxtFPlayer7(), 460.0);
		txtFPlayer7.opacityProperty().bind(Bindings.when(txtFPlayer7.disabledProperty()).then(0.4).otherwise(1));
		txtFPlayer7.setDisable(true);
		
		//TxtFPlayer4
		txtFPlayer4.getStyleClass().add("txtField");
		AnchorPane.setTopAnchor(getTxtFPlayer4(),535.0);
		AnchorPane.setRightAnchor(getTxtFPlayer4(), 260.0);
		AnchorPane.setLeftAnchor(getTxtFPlayer4(), 1300.0);
		txtFPlayer4.opacityProperty().bind(Bindings.when(txtFPlayer4.disabledProperty()).then(0.4).otherwise(1));
		txtFPlayer4.setDisable(true);
		
		//TxtFPlayer6
		txtFPlayer6.getStyleClass().add("txtField");
		AnchorPane.setTopAnchor(getTxtFPlayer6(),645.0);
		AnchorPane.setRightAnchor(getTxtFPlayer6(), 260.0);
		AnchorPane.setLeftAnchor(getTxtFPlayer6(), 1300.0);
		txtFPlayer6.opacityProperty().bind(Bindings.when(txtFPlayer6.disabledProperty()).then(0.4).otherwise(1));
		txtFPlayer6.setDisable(true);
		
		//TxtFPlayer8
		txtFPlayer8.getStyleClass().add("txtField");
		AnchorPane.setTopAnchor(getTxtFPlayer8(),755.0);
		AnchorPane.setRightAnchor(getTxtFPlayer8(), 260.0);
		AnchorPane.setLeftAnchor(getTxtFPlayer8(), 1300.0);
		txtFPlayer8.opacityProperty().bind(Bindings.when(txtFPlayer8.disabledProperty()).then(0.4).otherwise(1));
		txtFPlayer8.setDisable(true);
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
		return btnBack;
	}

	public Button getBtnStart() {
		if (btnStart == null) {
			btnStart = new Button("Start");
		}
		return btnStart;
	}

	public Text getTxtNbPlayer() {
		if (txtNbPlayer == null) {
			txtNbPlayer = new Text("2 Players  : ");
		}
		return txtNbPlayer;
	}
	
	public Button getArrowUp() {
		if (arrowUp == null) {
			arrowUp = new Button();
		}
		return arrowUp;
	} 
	
	public Button getArrowDown() {
		if (arrowDown == null) {
			arrowDown = new Button();
		}
		return arrowDown;
	}

	public Text getTxtPlayer1() {
		if (txtPlayer1 == null) {
			txtPlayer1 = new Text("Player 1 : ");
		}
		return txtPlayer1;
	}

	public Text getTxtPlayer2() {
		if (txtPlayer2 == null) {
			txtPlayer2 = new Text("Player 2 : ");
		}
		return txtPlayer2;
	}
	
	public Text getTxtPlayer3() {
		if (txtPlayer3 == null) {
			txtPlayer3 = new Text("Player 3 : ");
		}
		return txtPlayer3;
	}
	
	public Text getTxtPlayer4() {
		if (txtPlayer4 == null) {
			txtPlayer4 = new Text("Player 4 : ");
		}
		return txtPlayer4;
	}
	
	public Text getTxtPlayer5() {
		if (txtPlayer5 == null) {
			txtPlayer5 = new Text("Player 5 : ");
		}
		return txtPlayer5;
	}
	
	public Text getTxtPlayer6() {
		if (txtPlayer6 == null) {
			txtPlayer6 = new Text("Player 6 : ");
		}
		return txtPlayer6;
	}
	
	public Text getTxtPlayer7() {
		if (txtPlayer7 == null) {
			txtPlayer7 = new Text("Player 7 : ");
		}
		return txtPlayer7;
	}
	
	public Text getTxtPlayer8() {
		if (txtPlayer8 == null) {
			txtPlayer8 = new Text("Player 8 : ");
		}
		return txtPlayer8;
	}

	public TextField getTxtFPlayer1() {
		if (txtFPlayer1 == null) {
			txtFPlayer1 = new TextField();
			txtFPlayer1.setPromptText("name");
		}
		return txtFPlayer1;
	}
	
	public TextField getTxtFPlayer2() {
		if (txtFPlayer2 == null) {
			txtFPlayer2 = new TextField();
			txtFPlayer2.setPromptText("name");
		}
		return txtFPlayer2;
	}

	public TextField getTxtFPlayer3() {
		if (txtFPlayer3 == null) {
			txtFPlayer3 = new TextField();
			txtFPlayer3.setPromptText("name");
		}
		return txtFPlayer3;
	}
	
	public TextField getTxtFPlayer4() {
		if (txtFPlayer4 == null) {
			txtFPlayer4 = new TextField();
			txtFPlayer4.setPromptText("name");
		}
		return txtFPlayer4;
	}
	
	public TextField getTxtFPlayer5() {
		if (txtFPlayer5 == null) {
			txtFPlayer5 = new TextField();
			txtFPlayer5.setPromptText("name");
		}
		return txtFPlayer5;
	}
	
	public TextField getTxtFPlayer6() {
		if (txtFPlayer6 == null) {
			txtFPlayer6 = new TextField();
			txtFPlayer6.setPromptText("name");
		}
		return txtFPlayer6;
	}
	
	public TextField getTxtFPlayer7() {
		if (txtFPlayer7 == null) {
			txtFPlayer7 = new TextField();
			txtFPlayer7.setPromptText("name");
		}
		return txtFPlayer7;
	}
	
	public TextField getTxtFPlayer8() {
		if (txtFPlayer8 == null) {
			txtFPlayer8 = new TextField();
			txtFPlayer8.setPromptText("name");
		}
		return txtFPlayer8;
	}
	
	public Slider getSlPlayer() {
		if (slPlayer == null) {
			slPlayer = new Slider();
		}
		return slPlayer;
	}

}
