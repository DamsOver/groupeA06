package vue;
import enumerations.Theme;

import java.util.ArrayList;
import java.util.List;

import application.SceneManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import model.BasicCard;
import model.Deck;
import model.Game;
import util.AddCards;
import util.Constants;

public class CardsManagementAP extends AnchorPane {
	public static Game game;
	private Deck deck;
	
	private Text txtTitle, txtTheme;
	private Button btnBack, btnModify, btnDelete, btnAdd;
	private ComboBox<String> cbTheme;
	private ListView<String> lvCards;

	private ObservableList<String> listIgnore = FXCollections.observableArrayList("START", "FINISH", "SPECIAL");
	public CardsManagementAP() {
		this.getStyleClass().add("pane");

		this.getChildren().addAll(getTxtTitle(), getBtnBack(), getTxtTheme(), getCbTheme(), getLvCards(), getBtnAdd(), getBtnDelete(), getBtnModify());

		// title
		txtTitle.getStyleClass().add("title-style");
		AnchorPane.setTopAnchor(getTxtTitle(), 100.0);
		AnchorPane.setLeftAnchor(getTxtTitle(), 300.0);

		// Theme
		txtTheme.getStyleClass().add("basicText");
		AnchorPane.setTopAnchor(getTxtTheme(), 350.0);
		AnchorPane.setLeftAnchor(getTxtTheme(), 200.0);
		
		// lvCards
		lvCards.getStyleClass().add("lview");	
		AnchorPane.setTopAnchor(getLvCards(), 450.0);
		AnchorPane.setLeftAnchor(getLvCards(), 200.0);
		AnchorPane.setRightAnchor(getLvCards(), 480.0);
		AnchorPane.setBottomAnchor(getLvCards(), 120.0);
		
		// cbbTheme
		cbTheme.getStyleClass().add("cbbox");
		AnchorPane.setTopAnchor(getCbTheme(), 350.0);
		AnchorPane.setLeftAnchor(getCbTheme(), 380.0);
		cbTheme.getSelectionModel().selectFirst();
		
		// BtnModify
		btnModify.getStyleClass().add("btn_small");
		AnchorPane.setTopAnchor(getBtnModify(), 460.0);
		AnchorPane.setLeftAnchor(getBtnModify(), 1550.0);
		AnchorPane.setRightAnchor(getBtnModify(), 150.0);
		
		// BtnDelete
		btnDelete.getStyleClass().add("btn_small");
		AnchorPane.setTopAnchor(getBtnDelete(), 590.0);
		AnchorPane.setLeftAnchor(getBtnDelete(), 1550.0);
		AnchorPane.setRightAnchor(getBtnDelete(), 150.0);
		
		// BtnAdd
		btnAdd.getStyleClass().add("btn_small");
		AnchorPane.setTopAnchor(getBtnAdd(), 720.0);
		AnchorPane.setLeftAnchor(getBtnAdd(), 1550.0);
		AnchorPane.setRightAnchor(getBtnAdd(), 150.0);
		
		// BtnBack
		btnBack.getStyleClass().add("btn-style");
		AnchorPane.setTopAnchor(getBtnBack(), 900.0);
		AnchorPane.setLeftAnchor(getBtnBack(), 1600.0);
		
		
	}

	public Text getTxtTitle() {
		if (txtTitle == null) {
			txtTitle = new Text("Cards Management");
		}
		return txtTitle;
	}

	public Button getBtnBack() {
		if (btnBack == null) {
			btnBack = new Button("Back");
		}
		btnBack.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				SceneManager.getSceneRoot().setRoot(SceneManager.getStackAdmin());
			}
		});
		return btnBack;
	}

	public Text getTxtTheme() {
		if (txtTheme == null) {
			txtTheme = new Text("Theme : ");
		}
		return txtTheme;
	}
	
	public ListView<String> getLvCards() {
		if (lvCards == null) {
			lvCards = new ListView<String>();
			this.game= new Game();
			deck = new Deck();
			deck = game.getDeck();
			fillListView();
		}
		return lvCards;
	}
	
	public void fillListView() {
		lvCards.getItems().clear();
		if(cbTheme.valueProperty().get().equals("ALL")) {
			for(BasicCard b : deck.getBasicCards()) {
				lvCards.getItems().add(b.getSubject());
			}
		}
		else {
			for(BasicCard b : deck.getBasicCards()) {
				if(cbTheme.valueProperty().get().equals(b.getTheme().toString())) {
					lvCards.getItems().add(b.getSubject());
				}
			}
		}
	}
	
	public ComboBox<String> getCbTheme() {
		if (cbTheme == null) {
			cbTheme = new ComboBox<String>();
			cbTheme.getItems().add("ALL");
			for(Theme t : Theme.values()) {
				if(!listIgnore.contains(t.name())) {
					cbTheme.getItems().add(t.name());
				}
			}
			cbTheme.setValue(cbTheme.getItems().get(0).toString());
		}
		cbTheme.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				fillListView();
			}
		});
		return cbTheme;
	}

	public Button getBtnModify() {
		if (btnModify == null) {
			btnModify = new Button("Modify");
		}
		
		return btnModify;
	}

	public Button getBtnDelete() {
		if (btnDelete == null) {
			btnDelete = new Button("Delete");
		}
		btnDelete.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				ObservableList<Integer> toRemove = getLvCards().getSelectionModel().getSelectedIndices();
				//remove String
				
				//remove
			}
		});
		return btnDelete;
	}

	public Button getBtnAdd() {
		if (btnAdd == null) {
			btnAdd = new Button("Add");
		}
		btnAdd.setOnAction(new EventHandler<ActionEvent>(){
	        public void handle(ActionEvent event) {
	            SceneManager.getSceneRoot().setRoot(SceneManager.getStackAddCards());
	            }
			});
		return btnAdd;
	}

}
