package model;

import application.SceneManager;
import enumerations.Theme;
import javafx.animation.PauseTransition;
import util.Constants;

public class StartCard extends SpecialCard {

	@Override
	public void action() {
		BasicCard bc = SceneManager.getGameOperation().drawCard(Theme.getRandomTheme());
		//change the ratingAP labels
		SceneManager.getRating().setLbSubject(bc.getSubject());
		SceneManager.getRating().setLbTheme(bc.getTheme());
	}
}
