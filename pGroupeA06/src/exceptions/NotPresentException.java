package exceptions;

public class NotPresentException extends Exception {

	private static final long serialVersionUID = -942734177121522968L;

	public NotPresentException() {
		super("This Object is not present in the List");
	}
	
}
