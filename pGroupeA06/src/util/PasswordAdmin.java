package util;

public class PasswordAdmin {
	private final String PW_ADMIN = "TEST";
	private boolean validation;
	private String message;
	
	public PasswordAdmin(String response){
		validatePassword(response);
	}

	public void validatePassword(String response) {
		if(!response.equals(PW_ADMIN)) {
			validation = false;
			message =  "Your password is incorrect";
		}
		else {
			validation = true;
			message = "";
		}
	}
	
	public String getMessage() {
		return message;
	}
	public Boolean getValidation() {
		return validation;
	}
}
