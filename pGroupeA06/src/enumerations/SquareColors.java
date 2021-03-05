package enumerations;

public enum SquareColors {
	BLUE("Informatics"),
	ORANGE("Pleasure"),
	GREEN("School"),
	PURPLE("Improbable");

	private String theme;
	SquareColors(String theme) {
		this.theme = theme;
	}
	public String getTheme() {
		return theme;
	}
}
