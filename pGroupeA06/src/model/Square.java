package model;

import enumerations.Theme;

public class Square {
	private Theme theme;
	
	public Square(Theme theme) {
		this.theme = theme;
	}

	public Theme getTheme() {
		return theme;
	}
	
	public String toString() {
		return theme.getTheme();
	}
	
	public boolean equals(Object o) {
		if(o instanceof Square) {
			Square sq = (Square)o;
			return sq.theme.equals(this.theme);
		}
		return false;
	}
}
