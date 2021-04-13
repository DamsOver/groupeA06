package model;

import application.SceneManager;
import enumerations.Theme;
import javafx.animation.Animation;

public class StartCard extends SpecialCard {

	@Override
	public void action(Animation[] transitions) {
		BasicCard bc = SceneManager.getGameOperation().drawCard(Theme.getRandomTheme());
		//change the ratingAP labels
		SceneManager.getRating().setLbSubject(bc.getSubject());
		SceneManager.getRating().setLbTheme(bc.getTheme());
	}
}
