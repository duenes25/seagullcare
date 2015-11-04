package com.headhigh.seagullcare.service;

import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CryptHelper {

	private static final Logger logger = LoggerFactory.getLogger(CryptHelper.class);
	private static final String KEY = "Bar12345Bar12345";// 128 bit key
	
	public static String encrypt(String stringToEncrypt){
		logger.info("Entering encrypt");
		String encryptedString = null;
		try 
	    {
			// Create key and cipher
	        Key aesKey = new SecretKeySpec(KEY.getBytes(), "AES");
	        Cipher cipher = Cipher.getInstance("AES");
	        // encrypt the text
	        cipher.init(Cipher.ENCRYPT_MODE, aesKey);
	        
	        byte[] encrypted = cipher.doFinal(stringToEncrypt.getBytes());

	        StringBuilder sb = new StringBuilder();
	        for (byte b: encrypted) {
	            sb.append((char)b);
	        }

	        // the encrypted String
	        encryptedString = sb.toString();
	        logger.info("Encryption Done");
	    }
		catch(Exception e) 
	    {
	        e.printStackTrace();
	        logger.error(e.getMessage());
	    }
		return encryptedString;
	}
	
	public static String decrypt(String stringToDecrypt){
		logger.info("Entering decrypt");
		String decryptedString = null;
		try 
	    {
	        // convert the string to byte array
	        // for decryption
	        byte[] bb = new byte[stringToDecrypt.length()];
	        for (int i=0; i<stringToDecrypt.length(); i++) {
	            bb[i] = (byte) stringToDecrypt.charAt(i);
	        }
	     // Create key and cipher
	        Key aesKey = new SecretKeySpec(KEY.getBytes(), "AES");
	        Cipher cipher = Cipher.getInstance("AES");
	        
	        // decrypt the text
	        cipher.init(Cipher.DECRYPT_MODE, aesKey);
	        decryptedString = new String(cipher.doFinal(bb));
	        logger.info("Decryption Completed");

	    }
	    catch(Exception e) 
	    {
	        e.printStackTrace();
	    }
	
		return decryptedString;
	}
	
	
}
