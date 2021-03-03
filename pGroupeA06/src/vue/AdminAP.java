package vue;

import application.SceneManager;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class AdminAP extends AnchorPane {

	private Text txtTitle, txtLogin, txtPassword;
	private TextField txtFLogin, txtFPassword;

	private Button btnBack, btnUnlock;

	public AdminAP() {
		this.getStyleClass().add("pane");
		this.getChildren().addAll(getTxtTitle(), getBtnBack(), getBtnUnlock(), getTxtPassword(), getTxtLogin(),
				getTxtFLogin(), getTxtFPassword());

		// title
		txtTitle.getStyleClass().add("title-style");
		AnchorPane.setTopAnchor(getTxtTitle(), 100.0);
		AnchorPane.setLeftAnchor(getTxtTitle(), 700.0);

		// Login
		txtLogin.getStyleClass().add("basicText");
		AnchorPane.setTopAnchor(getTxtLogin(), 450.0);
		AnchorPane.setLeftAnchor(getTxtLogin(), 200.0);

		// Password
		txtPassword.getStyleClass().add("basicText");
		AnchorPane.setTopAnchor(getTxtPassword(), 550.0);
		AnchorPane.setLeftAnchor(getTxtPassword(), 200.0);

		// LoginField
		txtFLogin.getStyleClass().add("txtField");
		AnchorPane.setTopAnchor(getTxtFLogin(), 445.0);
		AnchorPane.setLeftAnchor(getTxtFLogin(), 410.0);
		AnchorPane.setRightAnchor(getTxtFLogin(), 1160.0);

		// PasswordField
		txtFPassword.getStyleClass().add("txtField");
		AnchorPane.setTopAnchor(getTxtFPassword(), 545.0);
		AnchorPane.setLeftAnchor(getTxtFPassword(), 410.0);
		AnchorPane.setRightAnchor(getTxtFPassword(), 1160.0);

		// Unlock
		btnUnlock.getStyleClass().add("btn-style");
		AnchorPane.setTopAnchor(getBtnUnlock(), 700.0);
		AnchorPane.setLeftAnchor(getBtnUnlock(), 200.0);

		// BtnBack
		btnBack.getStyleClass().add("btn-style");
		AnchorPane.setTopAnchor(getBtnBack(), 900.0);
		AnchorPane.setLeftAnchor(getBtnBack(), 1600.0);
	}

	public Text getTxtLogin() {
		if (txtLogin == null) {
			txtLogin = new Text("Login : ");
		}
		return txtLogin;
	}

	public Text getTxtPassword() {
		if (txtPassword == null) {
			txtPassword = new Text("Password : ");
		}
		return txtPassword;
	}

	public TextField getTxtFLogin() {
		if (txtFLogin == null) {
			txtFLogin = new TextField();
		}
		return txtFLogin;
	}

	public TextField getTxtFPassword() {
		if (txtFPassword == null) {
			txtFPassword = new TextField();
		}
		return txtFPassword;
	}

	public Text getTxtTitle() {
		if (txtTitle == null) {
			txtTitle = new Text("Admin");
		}
		return txtTitle;
	}

	public Button getBtnBack() {
		if (btnBack == null) {
			btnBack = new Button("Back");
		}
		btnBack.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				SceneManager.getSceneRoot().setRoot(SceneManager.getStackOptions());
			}
		});
		return btnBack;
	}

	public Button getBtnUnlock() {
		if (btnUnlock == null) {
			btnUnlock = new Button("Unlock");
		}
		btnUnlock.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				SceneManager.getSceneRoot().setRoot(SceneManager.getStackCardsManager());
			}
		});
		
		return btnUnlock;
	}

}
