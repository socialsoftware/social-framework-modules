package pt.ist.exception;

public class WrongUsernameException extends AuthenticationExcetpion {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WrongUsernameException(String msg) {
		super(msg);
	}
}
