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
}
