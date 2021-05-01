package exceptions;

public class TooManyException extends Exception {

	private static final long serialVersionUID = -4562479983229286363L;

	public TooManyException() {
		super("The maximum number of Object has been reached in this List");
	}
		
}
