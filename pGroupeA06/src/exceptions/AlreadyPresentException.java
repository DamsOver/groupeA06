package exceptions;

public class AlreadyPresentException extends Exception {

	private static final long serialVersionUID = 7045838545225674788L;

	public AlreadyPresentException() {
		super("This Object is already present in the List");
	}	
}
