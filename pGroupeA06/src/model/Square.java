package model;

import java.util.ArrayList;
import java.util.List;

import enumerations.Theme;

public class Square {
	private Theme theme;
	private List<Position> playersPosition;

	public Square(Theme theme) {
		this.theme = theme;
		this.playersPosition = new ArrayList<>();
	}

	public Theme getTheme() {
		return theme;
	}

	public List<Position> getPlayersPosition() {
		return playersPosition;
	}

	public String toString() {
		return theme.toString() + ", [" + playersPosition + "]";
	}

	public boolean equals(Object o) {
		if (o instanceof Square) {
			Square sq = (Square) o;
			return sq.theme.equals(this.theme);
		}
		return false;
	}
}
