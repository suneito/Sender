package Crypto;
import java.security.Key;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;
import Control.GeneralConstants;
import Util.ToolSender;

/**
 * Encryption
 * Encryption tools class
 * @author Suneo
 *
 */

public class Encryption {
	private Key key;
	
	/**
	 * Constructor generates a 16 bytes key
	 * @param determined by user passCrudo
	 * @throws Exception
	 */
	public Encryption(String passCrudo) throws Exception {
		KeyGenerator keyGenerator = KeyGenerator.getInstance(GeneralConstants.CryptoConstants.ALGORITHM_SHORT);
		keyGenerator.init(128);
		key = keyGenerator.generateKey();
		key = new SecretKeySpec(passCrudo.getBytes(),  0, 16, GeneralConstants.CryptoConstants.ALGORITHM_SHORT);				
	}
	
	/**
	 * Encrypts the entered text 
	 * @param String clearText
	 * @return String encrypted text
	 */
	public String encrypt(String clearText) {
		Cipher cripy;
		try {
			cripy = Cipher.getInstance(GeneralConstants.CryptoConstants.ALGORITHM_LONG);
			cripy.init(Cipher.ENCRYPT_MODE, key);
			byte[] cripyText = cripy.doFinal(clearText.getBytes());
			return Base64.getEncoder()
					.encodeToString(cripyText);
		} catch (Exception e) {
			ToolSender.print( e.getMessage());
        	return null;
        }
	}
	
	/**
	 * Decrypts entered text
	 * @param String encryptedText
	 * @return String decrypted text
	 */
	public String decrypt(String encryptedText) {
		Cipher cripy;
		try {
			cripy = Cipher.getInstance(GeneralConstants.CryptoConstants.ALGORITHM_LONG);
			cripy.init(Cipher.DECRYPT_MODE, key);
			byte[] plainText = cripy.doFinal(Base64.getDecoder()
			        .decode(encryptedText));
			    return new String(plainText);
		} catch (Exception e) {
        	return encryptedText;
        }		
	}
	
	public boolean evalPassword() {
		//TODO
		return false;
	}
}
