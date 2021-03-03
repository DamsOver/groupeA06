package application;

import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import vue.AddCardsAP;
import vue.AddPlayersAP;
import vue.AdminAP;
import vue.GameAP;
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
								stackLoginAdmin;
	
	public static void initialize() {
		stackRoot = new StackPane(new HomeAP());
		stackAddCards = new StackPane(new AddCardsAP());
		stackAdmin = new StackPane(new AdminAP());
		stackGame = new StackPane(new GameAP());
		stackAddPlayers = new StackPane(new AddPlayersAP());
		stackOptions = new StackPane(new OptionsAP());
		stackLoginAdmin = new StackPane(new LoginAdminAP());
		sceneRoot = new Scene(stackRoot, 1920, 1080);
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
	
	
}
