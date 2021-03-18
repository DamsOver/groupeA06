package vue;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import model.Game;
import util.Constants;

public class GameAP extends AnchorPane {

	private static ImageView ivPlayer01;
	private static ImageView ivPlayer02;
	private static ImageView ivPlayer03;
	private static ImageView ivPlayer04;
	private static ImageView ivPlayer05;
	private static ImageView ivPlayer06;
	private static ImageView ivPlayer07;
	private static ImageView ivPlayer08;

	public GameAP() {
		this.getStyleClass().add("gameBoard");
		this.getChildren().addAll(getIvPlayer01(), getIvPlayer02(), getIvPlayer03(), getIvPlayer04(), getIvPlayer05(),
				getIvPlayer06(), getIvPlayer07(), getIvPlayer08());

		// Size
		// P01
		getIvPlayer01().setFitHeight(Constants.PLAYER_HEIGHT);
		getIvPlayer01().setFitWidth(Constants.PLAYER_WIDTH);
		// P02
		getIvPlayer02().setFitHeight(Constants.PLAYER_HEIGHT);
		getIvPlayer02().setFitWidth(Constants.PLAYER_WIDTH);
		// P03
		getIvPlayer03().setFitHeight(Constants.PLAYER_HEIGHT);
		getIvPlayer03().setFitWidth(Constants.PLAYER_WIDTH);
		// P04
		getIvPlayer04().setFitHeight(Constants.PLAYER_HEIGHT);
		getIvPlayer04().setFitWidth(Constants.PLAYER_WIDTH);
		// P05
		getIvPlayer05().setFitHeight(Constants.PLAYER_HEIGHT);
		getIvPlayer05().setFitWidth(Constants.PLAYER_WIDTH);
		// P06
		getIvPlayer06().setFitHeight(Constants.PLAYER_HEIGHT);
		getIvPlayer06().setFitWidth(Constants.PLAYER_WIDTH);
		// P07
		getIvPlayer07().setFitHeight(Constants.PLAYER_HEIGHT);
		getIvPlayer07().setFitWidth(Constants.PLAYER_WIDTH);
		// P08
		getIvPlayer08().setFitHeight(Constants.PLAYER_HEIGHT);
		getIvPlayer08().setFitWidth(Constants.PLAYER_WIDTH);

		// Position
		// P01
			
//		int i = 10; // 36 Positions donc jusqu'à indice 35 maximum
		int indexSquare=0;
		getIvPlayer01().setX(Game.getBoard().getSquares().get(indexSquare).getPlayersPosition().get(0).getX());
		getIvPlayer01().setY(Game.getBoard().getSquares().get(indexSquare).getPlayersPosition().get(0).getY());
		// P02
		getIvPlayer02().setX(Game.getBoard().getSquares().get(indexSquare).getPlayersPosition().get(1).getX());
		getIvPlayer02().setY(Game.getBoard().getSquares().get(indexSquare).getPlayersPosition().get(1).getY());
		// P03
		getIvPlayer03().setX(Game.getBoard().getSquares().get(indexSquare).getPlayersPosition().get(2).getX());
		getIvPlayer03().setY(Game.getBoard().getSquares().get(indexSquare).getPlayersPosition().get(2).getY());
		// P04
		getIvPlayer04().setX(Game.getBoard().getSquares().get(indexSquare).getPlayersPosition().get(3).getX());
		getIvPlayer04().setY(Game.getBoard().getSquares().get(indexSquare).getPlayersPosition().get(3).getY());
		// P05
		getIvPlayer05().setX(Game.getBoard().getSquares().get(indexSquare).getPlayersPosition().get(4).getX());
		getIvPlayer05().setY(Game.getBoard().getSquares().get(indexSquare).getPlayersPosition().get(4).getY());
		// P06
		getIvPlayer06().setX(Game.getBoard().getSquares().get(indexSquare).getPlayersPosition().get(5).getX());
		getIvPlayer06().setY(Game.getBoard().getSquares().get(indexSquare).getPlayersPosition().get(5).getY());
		// P07
		getIvPlayer07().setX(Game.getBoard().getSquares().get(indexSquare).getPlayersPosition().get(6).getX());
		getIvPlayer07().setY(Game.getBoard().getSquares().get(indexSquare).getPlayersPosition().get(6).getY());
		// P08
		getIvPlayer08().setX(Game.getBoard().getSquares().get(indexSquare).getPlayersPosition().get(7).getX());
		getIvPlayer08().setY(Game.getBoard().getSquares().get(indexSquare).getPlayersPosition().get(7).getY());

	}

	public ImageView getIvPlayer01() {
		if (ivPlayer01 == null) {
			Image tmp = new Image(getClass().getResourceAsStream("/img/Player_01.png"));
			ivPlayer01 = new ImageView(tmp);
		}
		return ivPlayer01;
	}

	public ImageView getIvPlayer02() {
		if (ivPlayer02 == null) {
			Image tmp = new Image(getClass().getResourceAsStream("/img/Player_02.png"));
			ivPlayer02 = new ImageView(tmp);
		}
		return ivPlayer02;
	}

	public ImageView getIvPlayer03() {
		if (ivPlayer03 == null) {
			Image tmp = new Image(getClass().getResourceAsStream("/img/Player_03.png"));
			ivPlayer03 = new ImageView(tmp);
		}
		return ivPlayer03;
	}

	public ImageView getIvPlayer04() {
		if (ivPlayer04 == null) {
			Image tmp = new Image(getClass().getResourceAsStream("/img/Player_04.png"));
			ivPlayer04 = new ImageView(tmp);
		}
		return ivPlayer04;
	}

	public ImageView getIvPlayer05() {
		if (ivPlayer05 == null) {
			Image tmp = new Image(getClass().getResourceAsStream("/img/Player_05.png"));
			ivPlayer05 = new ImageView(tmp);
		}
		return ivPlayer05;
	}

	public ImageView getIvPlayer06() {
		if (ivPlayer06 == null) {
			Image tmp = new Image(getClass().getResourceAsStream("/img/Player_06.png"));
			ivPlayer06 = new ImageView(tmp);
		}
		return ivPlayer06;
	}

	public ImageView getIvPlayer07() {
		if (ivPlayer07 == null) {
			Image tmp = new Image(getClass().getResourceAsStream("/img/Player_07.png"));
			ivPlayer07 = new ImageView(tmp);
		}
		return ivPlayer07;
	}

	public ImageView getIvPlayer08() {
		if (ivPlayer08 == null) {
			Image tmp = new Image(getClass().getResourceAsStream("/img/Player_08.png"));
			ivPlayer08 = new ImageView(tmp);
		}
		return ivPlayer08;
	}
	
	public static void setIvPlayer01(double x, double y) {
		GameAP.ivPlayer01.setX(x);
		GameAP.ivPlayer01.setY(y);
	}

	public static void setIvPlayer02(double x, double y) {
		GameAP.ivPlayer02.setX(x);
		GameAP.ivPlayer02.setY(y);
	}

	public static void setIvPlayer03(double x, double y) {
		GameAP.ivPlayer03.setX(x);
		GameAP.ivPlayer03.setY(y);
	}

	public static void setIvPlayer04(double x, double y) {
		GameAP.ivPlayer04.setX(x);
		GameAP.ivPlayer04.setY(y);
	}

	public static void setIvPlayer05(double x, double y) {
		GameAP.ivPlayer05.setX(x);
		GameAP.ivPlayer05.setY(y);
	}

	public static void setIvPlayer06(double x, double y) {
		GameAP.ivPlayer06.setX(x);
		GameAP.ivPlayer06.setY(y);
	}

	public static void setIvPlayer07(double x, double y) {
		GameAP.ivPlayer07.setX(x);
		GameAP.ivPlayer07.setY(y);
	}

	public static void setIvPlayer08(double x, double y) {
		GameAP.ivPlayer08.setX(x);
		GameAP.ivPlayer08.setY(y);
	}

}