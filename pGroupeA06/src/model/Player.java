package model;

import enumerations.PlayerColors;
import vue.GameAP;

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
	
	public void setSquare(Square square,Game g,Player p, int indexPlayer) {
		this.square = square;
		GameAP.setIvPlayer(
				Game.getBoard().getSquares().get(g.getBoard().getSquares().indexOf(p.getSquare())).getPlayersPosition().get(indexPlayer).getX(),
				Game.getBoard().getSquares().get(g.getBoard().getSquares().indexOf(p.getSquare())).getPlayersPosition().get(indexPlayer).getY(),
				indexPlayer);
	}
	
	
	
	public Player clone() {
		return new Player(name,PlayerColors.getValue(color),square);
	}
}
