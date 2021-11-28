package Crypto;
import java.security.Key;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;
import Control.GeneralConstants;
import Util.ToolSender;

public class Encryption {
	private Key key;
	
	public Encryption(String passCrudo) throws Exception {
		KeyGenerator keyGenerator = KeyGenerator.getInstance(GeneralConstants.CryptoConstants.ALGORITHM_SHORT);
		keyGenerator.init(128);
		key = keyGenerator.generateKey();
		key = new SecretKeySpec(passCrudo.getBytes(),  0, 16, GeneralConstants.CryptoConstants.ALGORITHM_SHORT);				
	}
	
	public String encrypt(String clearText) {
		Cipher aes;
		try {
			aes = Cipher.getInstance(GeneralConstants.CryptoConstants.ALGORITHM_LONG);
			aes.init(Cipher.ENCRYPT_MODE, key);
			byte[] cipherText = aes.doFinal(clearText.getBytes());
			return Base64.getEncoder()
					.encodeToString(cipherText);
		} catch (Exception e) {
			ToolSender.print( e.getMessage());
        	return null;
        }
	}
	
	public String decrypt(String encryptedText) {
		Cipher aes;
		try {
			aes = Cipher.getInstance(GeneralConstants.CryptoConstants.ALGORITHM_LONG);
			aes.init(Cipher.DECRYPT_MODE, key);
			byte[] plainText = aes.doFinal(Base64.getDecoder()
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
