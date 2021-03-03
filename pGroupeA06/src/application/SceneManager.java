package application;

import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import vue.AddCardsAP;
import vue.AddPlayersAP;
import vue.AdminAP;
import vue.GameAP;
import vue.GameRulesAP;
import vue.HomeAP;
import vue.LoginAdminAP;
import vue.OptionsAP;

public class SceneManager {
	
	private static Scene sceneRoot; 
	
	private static StackPane 	stackOptions,
								stackRoot,
								stackAddCards,
								stackAdmin,
								stackGame,
								stackAddPlayers,
								stackLoginAdmin,
								stackGameRule;
	
	private static HomeAP root;
	
	public static void initialize() {
		
		root = new HomeAP();
		stackRoot = new StackPane(root);
		stackAddCards = new StackPane(new AddCardsAP());
		stackAdmin = new StackPane(new AdminAP());
		stackGame = new StackPane(new GameAP());
		stackAddPlayers = new StackPane(new AddPlayersAP());
		stackOptions = new StackPane(new OptionsAP());
		stackLoginAdmin = new StackPane(new LoginAdminAP());
		stackGameRule = new StackPane(new GameRulesAP());
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

	public static StackPane getStackLoginAdmin() {
		return stackLoginAdmin;
	}
	public static StackPane getStackGameRule() {
		return stackGameRule;
	}
	
}
