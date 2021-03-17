package enumerations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Random;

public enum Theme {
	IMPROBABLE("Improbable"), 
	PLEASURE("Pleasure"), 
	INFORMATICS("Informatics"), 
	SCHOOL("School"), 
	SPECIAL("Special"),
	START("Start"), 
	FINISH("FINISH");

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

	public static Theme getRandomTheme() {
		Random rand = new Random();
		List<Theme> tmp = new ArrayList<Theme>();

		for (Theme t : Theme.values()) {
			if (!(t.equals(Theme.START) || t.equals(Theme.FINISH) || t.equals(Theme.SPECIAL))) {
				tmp.add(t);
			}
		}
		return tmp.get(rand.nextInt(tmp.size()));
	}

	public String getTheme() {
		return this.theme;
	}
}
