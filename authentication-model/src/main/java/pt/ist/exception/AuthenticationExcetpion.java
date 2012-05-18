package pt.ist.exception;

public class AuthenticationExcetpion extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String msg;

	public AuthenticationExcetpion(String msg) {
		this.msg = msg;
	}
	
	public String getMsg() {
		return msg;
	}

}
