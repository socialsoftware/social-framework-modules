package pt.ist.authentication;

public class User extends User_Base {

  public void init(String email, String passwordHash, String salt) {
    setEmail(email);
    PasswordCredentialInfo credentialInfo = new PasswordCredentialInfo();
    credentialInfo.init(passwordHash, salt);
    setCredentialInfo(credentialInfo);
  }

}
