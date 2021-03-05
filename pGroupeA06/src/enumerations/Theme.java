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
	
	public static Theme getTheme(String string) {
		   for (Theme t : Theme.values()) {
		        if (t.name().equals(string)) {
		            return t;
		        }
		    }
		return null;
	}
	
	
	public String getTheme() {
		return this.theme;
	}
}
