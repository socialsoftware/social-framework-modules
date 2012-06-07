package pt.ist.authentication;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import pt.ist.exception.MissingEmailException;
import pt.ist.exception.MissingPasswordException;
import pt.ist.exception.MissingUsernameException;
import pt.ist.exception.NotValidEmailException;

public class User extends User_Base {

  public void init(String username, String email, String password) throws MissingUsernameException, MissingEmailException, MissingPasswordException, NotValidEmailException {
	  if(username == null || username.equals("")){
			throw new MissingUsernameException("The user name is missing");
		}
	  else if(email == null || email.equals("")) {
			throw new MissingEmailException("The email is missing");
		}
	  else if(password == null || password.equals("")){
			throw new MissingPasswordException("The password is missing");
		}
	  else{
		  InternetAddress emailAddress =  null;
		  try {
			  emailAddress =  new InternetAddress(email);
			  emailAddress.validate();
			  } 
		  catch (AddressException e) {
				  throw new NotValidEmailException("The email is not valid");
			}
		  PasswordCredentialInfo credentialInfo = new PasswordCredentialInfo();
		  String salt = credentialInfo.saltGeneretor();
		  credentialInfo.init(credentialInfo.encryption(password + salt ), salt);
		  setUsername(username);
		  setEmail(email);
		  setCredentialInfo(credentialInfo);
	  }
  }
}
