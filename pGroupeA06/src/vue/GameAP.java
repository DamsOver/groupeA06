package vue;

import java.util.ArrayList;
import java.util.List;

import application.SceneManager;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import model.Game;
import util.Constants;

public class GameAP extends AnchorPane {

	private static List<ImageView> listImageView;

	public GameAP() {
		this.getStyleClass().add("gameBoard");
		this.getChildren().addAll(getIvPlayer());
	}

	public List<ImageView> getIvPlayer() {

		if (listImageView == null) {
			listImageView = new ArrayList<ImageView>();
			for (int i = 0; i < Constants.NB_PLAYER; i++) {
				Image tmp = new Image(getClass().getResourceAsStream("/img/Player_0" + (i + 1) + ".png"));
				listImageView.add(new ImageView(tmp));
				listImageView.get(i).setFitHeight(Constants.PLAYER_HEIGHT);
				listImageView.get(i).setFitWidth(Constants.PLAYER_WIDTH);
				listImageView.get(i).setX(Game.getBoard().getSquares().get(0).getPlayersPosition().get(i).getX());
				listImageView.get(i).setY(Game.getBoard().getSquares().get(0).getPlayersPosition().get(i).getY());
			}
		}
		return listImageView;
	}

	public static void setIvPlayer(double x, double y, int indice) {
		listImageView.get(indice).setX(x);
		listImageView.get(indice).setY(y);
	}

	public static List<ImageView> getListImageView() {
		return listImageView;
	}

}