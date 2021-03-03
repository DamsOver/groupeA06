package vue;

import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class TransitionAnimationAP extends AnchorPane{

	private Text txtAnimation;
	
	public TransitionAnimationAP() {
		
		this.getStyleClass().add("pane");
		this.getChildren().addAll(getTxtAnimation());
		
		getTxtAnimation().getStyleClass().add("title-style");
		AnchorPane.setTopAnchor(getTxtAnimation(), 400.0 );
		AnchorPane.setRightAnchor(getTxtAnimation(), 550.0 );
		AnchorPane.setLeftAnchor(getTxtAnimation(), 550.0 );
	}
	
	public Text getTxtAnimation() {
		if(txtAnimation==null) {
			txtAnimation = new Text();
		}
		return txtAnimation;
	}
	
	public Text setTxtAnimation(String texte) {
		if(txtAnimation==null) {
			txtAnimation = new Text(texte);
		}else {
			txtAnimation.setText(texte);
		}
		return txtAnimation;
	}
}
