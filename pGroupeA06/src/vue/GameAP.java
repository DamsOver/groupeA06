package vue;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import util.Constants;

public class GameAP extends AnchorPane {

	private ImageView ivPlayer01;
	private ImageView ivPlayer02;
	private ImageView ivPlayer03;
	private ImageView ivPlayer04;
	private ImageView ivPlayer05;
	private ImageView ivPlayer06;
	private ImageView ivPlayer07;
	private ImageView ivPlayer08;

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
		getIvPlayer01().setX(Constants.PLAYER_01_POSITIONS_X.get(0));
		getIvPlayer01().setY(Constants.PLAYER_01_POSITIONS_Y.get(0));
		// P02
		getIvPlayer02().setX(Constants.PLAYER_02_POSITIONS_X.get(0));
		getIvPlayer02().setY(Constants.PLAYER_02_POSITIONS_Y.get(0));
		// P03
		getIvPlayer03().setX(Constants.PLAYER_03_POSITIONS_X.get(0));
		getIvPlayer03().setY(Constants.PLAYER_03_POSITIONS_Y.get(0));
		// P04
		getIvPlayer04().setX(Constants.PLAYER_04_POSITIONS_X.get(0));
		getIvPlayer04().setY(Constants.PLAYER_04_POSITIONS_Y.get(0));
		// P05
		getIvPlayer05().setX(Constants.PLAYER_05_POSITIONS_X.get(0));
		getIvPlayer05().setY(Constants.PLAYER_05_POSITIONS_Y.get(0));
		// P06
		getIvPlayer06().setX(Constants.PLAYER_06_POSITIONS_X.get(0));
		getIvPlayer06().setY(Constants.PLAYER_06_POSITIONS_Y.get(0));
		// P07
		getIvPlayer07().setX(Constants.PLAYER_07_POSITIONS_X.get(0));
		getIvPlayer07().setY(Constants.PLAYER_07_POSITIONS_Y.get(0));
		// P08
		getIvPlayer08().setX(Constants.PLAYER_08_POSITIONS_X.get(0));
		getIvPlayer08().setY(Constants.PLAYER_08_POSITIONS_Y.get(0));

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

}
