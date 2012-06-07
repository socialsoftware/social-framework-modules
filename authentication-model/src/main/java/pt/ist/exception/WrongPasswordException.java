package pt.ist.exception;

public class WrongPasswordException extends AuthenticationExcetpion{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WrongPasswordException(String msg) {
		super(msg);
	}

}
