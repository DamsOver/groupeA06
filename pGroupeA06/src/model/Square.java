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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((playersPosition == null) ? 0 : playersPosition.hashCode());
		result = prime * result + ((theme == null) ? 0 : theme.hashCode());
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
		Square other = (Square) obj;
		if (playersPosition == null) {
			if (other.playersPosition != null)
				return false;
		} else if (!playersPosition.equals(other.playersPosition))
			return false;
		if (theme != other.theme)
			return false;
		return true;
	}


}