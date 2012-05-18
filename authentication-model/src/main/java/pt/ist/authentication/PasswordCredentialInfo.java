package pt.ist.authentication;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import org.apache.commons.codec.binary.Hex;

public class PasswordCredentialInfo extends PasswordCredentialInfo_Base {

	private static final String RNG_ALGORITHM = "SHA1PRNG";
	
    public void init(String passwordHash, String salt) {
      setPasswordHash(passwordHash);
      setSalt(salt);
    }
    
    public String encryption(String password)
  	{
  		MessageDigest md = null;
  		try
  		{
  			byte[] bytesOfMessage = password.getBytes("UTF-8");
  			md =  MessageDigest.getInstance("MD5");
  			byte[] thedigest = md.digest(bytesOfMessage);
  			return new String( Hex.encodeHex(thedigest));
  		}
  		catch (NoSuchAlgorithmException ex) {
  		      ex.printStackTrace();
  		} catch (UnsupportedEncodingException e) {
  			e.printStackTrace();
  		}
  		return null;
  	}
    
	public String saltGeneretor(){
		final byte[] salt = new byte[20];
		try {
			SecureRandom.getInstance(RNG_ALGORITHM).nextBytes(salt);
			return new String(salt);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}
}
