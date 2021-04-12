package model;

import java.util.List;

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
		this.square = SceneManager.getGameOperation().getGame().getBoard().getSquares().get(0);
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
	
	public void setOldSquare(Square square) {
		this.oldSquare = square;
	}

	public Animation[] setSquare(Square square, Game g, Player p, int indexPlayer, Square oldSquare) {
		
		this.square = square;
		this.oldSquare = oldSquare;
		List<Square> squares = SceneManager.getGameOperation().getGame().getBoard().getSquares();

		int indexOfSquare = squares.indexOf(p.getSquare());
		int indexOfOldSquare = squares.indexOf(p.getOldSquare());
		
		Square currentSquare = oldSquare;
		Square targetSquare;
		
		
		Animation[] a = new Animation[Math.abs(indexOfSquare-indexOfOldSquare)+1];
		a[0]=SceneManager.getGameOperation().animation(Constants.ANIMATION_TIME_START,
				SceneManager.getStackGame(), null);
		
		for(int i = 0 ; i <Math.abs(indexOfSquare-indexOfOldSquare);i++) {
			double distX = 0;
			double distY = 0;
			
			int indexOfCurrentSquare = squares.indexOf(currentSquare);
			targetSquare = (indexOfSquare-indexOfOldSquare>0)?squares.get(indexOfCurrentSquare+1):squares.get(indexOfCurrentSquare-1);
			
			double currentPosX = squares.get(indexOfCurrentSquare).getPlayersPosition().get(indexPlayer).getX();
			double currentPosY = squares.get(indexOfCurrentSquare).getPlayersPosition().get(indexPlayer).getY();
			
			int indexOfNextSquare = squares.indexOf(targetSquare);
			double nextPosX = squares.get(indexOfNextSquare).getPlayersPosition().get(indexPlayer).getX();
			double nextPosY = squares.get(indexOfNextSquare).getPlayersPosition().get(indexPlayer).getY();
			
			distX = nextPosX - currentPosX;
			distY = nextPosY - currentPosY;
			
			TranslateTransition translate = new TranslateTransition();
			
			translate.setByX(distX);
			translate.setByY(distY);
			
			translate.setDuration(Duration.millis(Constants.ANIMATION_MOVEMENT));

			translate.setNode(GameAP.getListImageView().get(indexPlayer));
			
			a[i+1]=translate;
			currentSquare=targetSquare;
		}
		return a;
	}
	
	public Animation[] switchSquares(Player p) {
		
		Animation[] a = new Animation[3];
		a[0]=SceneManager.getGameOperation().animation(Constants.ANIMATION_TIME_START,SceneManager.getStackGame(), null);
		
		this.oldSquare = this.square;
		this.square = p.getSquare();
		p.setOldSquare(p.getSquare());
		p.setSquare(this.oldSquare);
		
		List<Square> squares = SceneManager.getGameOperation().getGame().getBoard().getSquares();

		int indexOfSquare1 = squares.indexOf(p.getSquare());
		int indexOfOldSquare1 = squares.indexOf(p.getOldSquare());
		int indexOfSquare2 = squares.indexOf(p.getSquare());
		int indexOfOldSquare2 = squares.indexOf(p.getOldSquare());
		
		int indexPlayer1 = SceneManager.getGameOperation().getGame().getPlayers().indexOf(this);
		int indexPlayer2 = SceneManager.getGameOperation().getGame().getPlayers().indexOf(p);
		
		double distX = 0;
		double distY = 0;
		
		double currentPosX = squares.get(indexOfOldSquare1).getPlayersPosition().get(indexPlayer1).getX();
		double currentPosY = squares.get(indexOfOldSquare1).getPlayersPosition().get(indexPlayer1).getY();
		double nextPosX = squares.get(indexOfSquare1).getPlayersPosition().get(indexPlayer1).getX();
		double nextPosY = squares.get(indexOfSquare1).getPlayersPosition().get(indexPlayer1).getY();
		
		distX = nextPosX - currentPosX;
		distY = nextPosY - currentPosY;
		
		TranslateTransition translate = new TranslateTransition();
		translate.setByX(distX);
		translate.setByY(distY);
		translate.setDuration(Duration.millis(Constants.ANIMATION_MOVEMENT));
		translate.setNode(GameAP.getListImageView().get(indexPlayer1));
		
		a[1]=translate;
		
		distX = 0;
		distY = 0;
		
		currentPosX = squares.get(indexOfOldSquare2).getPlayersPosition().get(indexPlayer2).getX();
		currentPosY = squares.get(indexOfOldSquare2).getPlayersPosition().get(indexPlayer2).getY();
		nextPosX = squares.get(indexOfSquare2).getPlayersPosition().get(indexPlayer2).getX();
		nextPosY = squares.get(indexOfSquare2).getPlayersPosition().get(indexPlayer2).getY();
		
		distX = nextPosX - currentPosX;
		distY = nextPosY - currentPosY;
		
		TranslateTransition translate2 = new TranslateTransition();
		translate2.setByX(distX);
		translate2.setByY(distY);
		translate2.setDuration(Duration.millis(Constants.ANIMATION_MOVEMENT));
		translate2.setNode(GameAP.getListImageView().get(indexPlayer2));
		
		a[2]=translate2;
		return a;
	}

	public Player clone() {
		return new Player(name, PlayerColors.getValue(color), square);
	}
}
