package vue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import application.SceneManager;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import util.Constants;

public class GameRulesAP extends AnchorPane {

	private Text txtTitle, txtRules;
	private ScrollPane sp;
	private Button btnBack;

	public GameRulesAP() {

		this.getStyleClass().add("pane");

		this.getChildren().addAll(getTxtTitle(), getSP(), getBtnBack());

		getTxtTitle().getStyleClass().add("title-style");
		AnchorPane.setTopAnchor(getTxtTitle(), 100.0);
		AnchorPane.setRightAnchor(getTxtTitle(), 550.0);
		AnchorPane.setLeftAnchor(getTxtTitle(), 550.0);

		getSP().getStyleClass().add("scroll-pane");
		getSP().setFitToWidth(true);
		AnchorPane.setTopAnchor(getSP(), 300.0);
		AnchorPane.setRightAnchor(getSP(), 390.0);
		AnchorPane.setLeftAnchor(getSP(), 390.0);
		AnchorPane.setBottomAnchor(getSP(), 250.0);
		

		getTxtRules().getStyleClass().add("txtAddPlayer");

		// BtnBack
		btnBack.getStyleClass().add("btn-style");
		AnchorPane.setTopAnchor(getBtnBack(), 900.0);
		AnchorPane.setRightAnchor(getBtnBack(), 50.0);
		AnchorPane.setLeftAnchor(getBtnBack(), 1600.0);

	}

	public Text getTxtTitle() {
		if (txtTitle == null) {
			txtTitle = new Text("Game Rules");
		}
		return txtTitle;
	}

	public Text getTxtRules() {
		if (txtRules == null) {
			txtRules = new Text();
			try (BufferedReader rule = new BufferedReader(
					new InputStreamReader(GameRulesAP.class.getResourceAsStream(Constants.RULE_PATH)))) {
				StringBuilder allText = new StringBuilder();
				String tmp = new String();
				while ((tmp = rule.readLine()) != null) {
					allText.append(tmp+"\n");
				}
				txtRules.setText(allText.toString());
				rule.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		txtRules.setWrappingWidth(1120);
		txtRules.setTextAlignment(TextAlignment.JUSTIFY);
		return txtRules;
	}

	public ScrollPane getSP() {
		if (sp == null) {
			sp = new ScrollPane();
		}
		sp.setContent(getTxtRules());
		return sp;
	}

	public Button getBtnBack() {
		if (btnBack == null) {
			btnBack = new Button("Back");
		}
		btnBack.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				SceneManager.getSceneRoot().setRoot(SceneManager.getStackRoot());
			}
		});
		return btnBack;
	}

}
