package vue;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.scene.layout.ColumnConstraints;

public class LoginAdminAP extends GridPane{
	
	private PasswordField pwfAdmin;
	
	private Button btnVal;
	private Button btnBack;
	
	private Text txtTitle;
	private Text txtMessage;
	
	private Label lblPw;
	
	
	
	public LoginAdminAP() {
//		this.setGridLinesVisible(true);
		this.setPadding(new Insets(10));
		this.setVgap(10);
		this.setHgap(10);
		
		int nbCol = 20;
		for (int i = 0; i < nbCol; i++) {
			ColumnConstraints colConstr = new ColumnConstraints();
			colConstr.setPercentWidth(100. / nbCol);
			this.getColumnConstraints().add(colConstr);
		}
		
		//title
		this.add(getTxtTitle(), 4, 1);
		txtTitle.getStyleClass().add("title-style");
		
		//Password
		this.add(getLblPw(), 1, 3, 4, 1);
		this.add(getPwfAdmin(), 5, 3, 4, 1);
		
		//Message
		this.add(getTxtMessage(), 1, 6, 9, 1);
		
		//Validate Button
		this.add(getBtnVal(), 6 , 7, 8, 1);
		btnVal.getStyleClass().add("btn-style");
		this.add(getBtnBack(), 1, 7, 3, 1);
		btnBack.getStyleClass().add("btn-style");
	}
	public PasswordField getPwfAdmin() {
		if(pwfAdmin == null) {
			pwfAdmin = new PasswordField();
		}
		return pwfAdmin;
	}
	
	public Text getTxtTitle() {
		if(txtTitle == null) {
			txtTitle = new Text("Login Page");
		}
		return txtTitle;
	}
	
	public Text getTxtMessage() {
		if(txtMessage == null) {
			txtMessage = new Text("");
		}
		return txtMessage;
	}
	public void setTxtMessage(String s) {
		if(txtMessage== null) {
			txtMessage = new Text(s);
		}
		else {
			txtMessage.setText(s);
		}
	}
	
	public Label getLblPw() {
		if(lblPw == null) {
			lblPw = new Label("Insert the password :");
		}
		return lblPw;
	}
	
	public Button getBtnVal() {
		if(btnVal == null) {
			btnVal = new Button("Validate");
		}
		return btnVal;
	}
	
	public Button getBtnBack() {
		if(btnBack == null) {
			btnBack = new Button("Back");
		}
		return btnBack;
	}
}
