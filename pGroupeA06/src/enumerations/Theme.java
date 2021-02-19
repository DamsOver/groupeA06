package enumerations;

public enum Theme {
	IMPROBABLE("Improbable"),
	PLEASURE("Pleasure"),
	INFORMATICS("Informatics"),
	SCHOOL("School");

	private String theme;
	
	private Theme(String string) {
		this.theme = string;
	}
	
	public String getTheme() {
		return this.theme;
	}
}
