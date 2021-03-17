package model;

import com.google.gson.Gson;

import enumerations.Theme;

public abstract class Card {
	private String author;
	private Theme theme;
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author=author;
		
	}
	public Theme getTheme() {
		return theme;
	}
	
	public void setTheme(Theme t) {
		this.theme = t;
	}
	
	public abstract String toString();
	
	public String toJson(){
		return new Gson().toJson(this);
	}
	
	public abstract BasicCard fromJson(String json);
	
}
