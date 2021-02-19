package exceptions;

public class NotPresentException extends Exception {

	private static final long serialVersionUID = -942734177121522968L;

	public NotPresentException() {
		super("This question is not present on this card");
	}
	
}
