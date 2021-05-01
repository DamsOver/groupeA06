package exceptions;

public class TooLittleException extends Exception{

	private static final long serialVersionUID = 356500478872630566L;

	public TooLittleException() {
		super("There is no Object in this List");
	}

}
