package vue;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class SampleBorderPane implements Initializable{

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

	@FXML
	public void test() {
		System.out.println("ok");
		test2();
	}
	
	@FXML
	public void test2() {
		System.out.println(" 2 ");
	}
}
