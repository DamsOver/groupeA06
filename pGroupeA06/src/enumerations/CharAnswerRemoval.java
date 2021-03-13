package enumerations;

import java.util.ArrayList;
import java.util.List;

public enum CharAnswerRemoval {
	AND("and"),
	OR("or"),
	A("a"),
	AN("an"),
	THE("the"),
	IN("in");
	
	private String value;
	
	CharAnswerRemoval(String value) {
		this.value=value;
	}
	
	
	public static List<String> getChar() {
		List<String> liste = new ArrayList<String>();
		for(CharAnswerRemoval r : values()) {
			liste.add(r.value.toString());
		}
		return liste;
	}
	
	
	
}
