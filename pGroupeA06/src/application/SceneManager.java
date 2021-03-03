package application;

import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import vue.AddCardsAP;
import vue.AddPlayersAP;
import vue.AdminAP;
import vue.CardsManagementAP;
import vue.GameAP;
import vue.GameRulesAP;
import vue.HomeAP;
import vue.OptionsAP;

public class SceneManager {
	
	private static Scene sceneRoot; 
	
	private static StackPane 	stackOptions,
								stackRoot,
								stackAddCards,
								stackAdmin,
								stackGame,
								stackAddPlayers,
								stackGameRule,
								stackCardsManagement;
	
	public static OptionsAP getOptions() {
		return options;
	}
	private static HomeAP root;
	private static OptionsAP options;
	
	public static void initialize() {
		
		root = new HomeAP();
		options=new OptionsAP();
		stackRoot = new StackPane(root);
		stackAddCards = new StackPane(new AddCardsAP());
		stackAdmin = new StackPane(new AdminAP());
		stackGame = new StackPane(new GameAP());
		stackAddPlayers = new StackPane(new AddPlayersAP());
		stackOptions = new StackPane(options);
		stackGameRule = new StackPane(new GameRulesAP());
		stackCardsManagement = new StackPane(new CardsManagementAP());
		sceneRoot = new Scene(stackRoot, 1920, 1080);
	}

	public static HomeAP getRoot() {
		return root;
	}

	public static Scene getSceneRoot() {
		return sceneRoot;
	}

	public static StackPane getStackOptions() {
		return stackOptions;
	}

	public static StackPane getStackRoot() {
		return stackRoot;
	}

	public static StackPane getStackAddCards() {
		return stackAddCards;
	}

	public static StackPane getStackAdmin() {
		return stackAdmin;
	}

	public static StackPane getStackGame() {
		return stackGame;
	}

	public static StackPane getStackAddPlayers() {
		return stackAddPlayers;
	}

	public static StackPane getStackGameRule() {
		return stackGameRule;
	}
	public static StackPane getStackCardsManager() {
		return stackCardsManagement;
	}
	
	
}
