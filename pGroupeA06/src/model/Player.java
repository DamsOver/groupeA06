package model;

import enumerations.PlayerColors;

public class Player {
	private String name;
	private PlayerColors color;
	private Square square;
	
	public Player(String name,int number) {
		this.name=name;
		this.color=PlayerColors.getColor(number);
		this.square=Game.getBoard().getSquares().get(0);
	}
	
	public Player(String name,int number,Square sq) {
		this.name=name;
		this.color=PlayerColors.getColor(number);
		this.square=sq;
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

	public void setSquare(Square square) {
		this.square = square;
	}
	
	public Player clone() {
		return new Player(name,PlayerColors.getValue(color),square);
	}
}
