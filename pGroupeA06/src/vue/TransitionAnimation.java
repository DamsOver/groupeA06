package vue;

import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class TransitionAnimation extends AnchorPane{

	private Text txtAnimation;
	
	public TransitionAnimation() {
		this.getStyleClass().add("animation");
		this.getChildren().addAll(getTxtAnimation());
	}
	
	public Text getTxtAnimation() {
		if(txtAnimation==null) {
			txtAnimation = new Text();
		}
		return txtAnimation;
	}
	
}
