package pt.ist.authentication;

public class PasswordCredentialInfo extends PasswordCredentialInfo_Base {

    public void init(String passwordHash, String salt) {
      setPasswordHash(passwordHash);
      setSalt(salt);
    }
}
