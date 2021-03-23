package model;

import application.SceneManager;
import enumerations.PlayerColors;
import javafx.animation.Animation;
import javafx.animation.Transition;
import javafx.animation.TranslateTransition;
import javafx.util.Duration;
import util.Constants;
import vue.GameAP;

public class Player {
	@Override
	public String toString() {
		return "Player [name=" + name + ", color=" + color + ", square=" + square + ", oldSquare=" + oldSquare + "]";
	}

	private String name;
	private PlayerColors color;
	private Square square;
	private Square oldSquare;

	public Player(String name, int number) {
		this.name = name;
		this.color = PlayerColors.getColor(number);
		this.square = Game.getBoard().getSquares().get(0);
	}

	public Player(String name, int number, Square sq) {
		this.name = name;
		this.color = PlayerColors.getColor(number);
		this.square = sq;
	}

	public String getName() {
		return name;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((square == null) ? 0 : square.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		if (color != other.color)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (square == null) {
			if (other.square != null)
				return false;
		} else if (!square.equals(other.square))
			return false;
		return true;
	}

	public PlayerColors getColor() {
		return color;
	}

	public Square getSquare() {
		return square;
	}

	public Square getOldSquare() {
		return oldSquare;
	}

	public void setSquare(Square square) {
		this.square = square;
	}

	public Animation[] setSquare(Square square, Game g, Player p, int indexPlayer, Square oldSquare) {

		this.square = square;
		this.oldSquare = oldSquare;

		double distX = 0;
		double distY = 0;

		int indexOfSquare = Game.getBoard().getSquares().indexOf(p.getSquare());
		int indexOfOldSquare = Game.getBoard().getSquares().indexOf(p.getOldSquare());
		
		double currentPosX = Game.getBoard().getSquares().get(indexOfOldSquare).getPlayersPosition().get(indexPlayer)
				.getX();
		double currentPosY = Game.getBoard().getSquares().get(indexOfOldSquare).getPlayersPosition().get(indexPlayer)
				.getY();

		double nextPosX = Game.getBoard().getSquares().get(indexOfSquare).getPlayersPosition().get(indexPlayer).getX();
		double nextPosY = Game.getBoard().getSquares().get(indexOfSquare).getPlayersPosition().get(indexPlayer).getY();

		TranslateTransition translate = new TranslateTransition();

		distX = nextPosX - currentPosX;
		distY = nextPosY - currentPosY;
		
//		System.out.println("nextX : " + nextPosX + ", currentX : " + currentPosX + ", nextY : " + nextPosY
//				+ ", currentY : " + currentPosY);
		
		translate.setByX(distX);
		translate.setByY(distY);
		
		translate.setDuration(Duration.millis(Constants.ANIMATION_TIME_TURN));

		translate.setNode(GameAP.getListImageView().get(indexPlayer));
		//translate.play();

//		GameAP.setIvPlayer(nextPosX, nextPosY, indexPlayer);
		Animation[] a = new Animation[2];
		a[0]=SceneManager.getGameOperation().animation(Constants.ANIMATION_TIME_START,
				SceneManager.getStackGame(), null);
		a[1]=translate;
		
		return a;
	}

	public Player clone() {
		return new Player(name, PlayerColors.getValue(color), square);
	}
}
