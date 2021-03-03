package util;

public class UnlockAdmin {
	private final String validLogin = "admin";
	private final String validPassword = "helha";
	private String login;
	private String password;
	private String message;
	
	public UnlockAdmin(String login, String password){
		this.login = login;
		this.password = password;
	}
	
	public boolean isValide() {
		if(login.equals(validLogin)&&password.equals(validPassword)) {
			message = "";
			return true;
		}
		message = "Wrong password or login";
		return false;
	}


}
