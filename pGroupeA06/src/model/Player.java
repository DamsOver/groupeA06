package model;

import enumerations.PlayerColors;
import javafx.animation.TranslateTransition;
import javafx.util.Duration;
import vue.GameAP;

public class Player {
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

	public void setSquare(Square square, Game g, Player p, int indexPlayer, Square oldSquare) {

		this.square = square;
		this.oldSquare = oldSquare;

		double distX = 0;
		double distY = 0;

		int indexOfSquare = g.getBoard().getSquares().indexOf(p.getSquare());
		int indexOfOldSquare = g.getBoard().getSquares().indexOf(p.getOldSquare());

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
		
		translate.setDuration(Duration.millis(2000));

		translate.setNode(GameAP.getListImageView().get(indexPlayer));
		translate.play();

//		GameAP.setIvPlayer(nextPosX, nextPosY, indexPlayer);

	}

	public Player clone() {
		return new Player(name, PlayerColors.getValue(color), square);
	}
}
