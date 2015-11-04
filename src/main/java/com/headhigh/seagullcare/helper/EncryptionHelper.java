package com.headhigh.seagullcare.helper;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;
import java.util.Random;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;


/*
 * When adding a new user, call generateSalt(), 
 * then getEncryptedPassword(), 
 * and store both the encrypted password and the salt. 
 * Do not store the clear-text password. 
 * Don’t worry about keeping the salt in a separate table or location from the encrypted password; 
 * 
 * When authenticating a user, 
 * retrieve the previously encrypted password and salt from the database, 
 * then send those and the clear-text password they entered to authenticate(). 
 * If it returns true, authentication succeeded.
 * 
 * When a user changes their password, it’s safe to reuse their old salt; 
 * you can just call getEncryptedPassword() with the old salt.
 */



public class EncryptionHelper {

	public static int randInt(int min, int max) {
	    Random rand = new Random();

	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}
	
	public static boolean authenticate(String attemptedPassword, byte[] encryptedPassword, byte[] salt)
			   throws NoSuchAlgorithmException, InvalidKeySpecException {
			  // Encrypt the clear-text password using the same salt that was used to
			  // encrypt the original password
			  byte[] encryptedAttemptedPassword = getEncryptedPassword(attemptedPassword, salt);

			  // Authentication succeeds if encrypted password that the user entered
			  // is equal to the stored hash
			  return Arrays.equals(encryptedPassword, encryptedAttemptedPassword);
			 }

	public static byte[] getEncryptedPassword(String password, byte[] salt)
			   throws NoSuchAlgorithmException, InvalidKeySpecException {
			  // PBKDF2 with SHA-1 as the hashing algorithm. Note that the NIST
			  // specifically names SHA-1 as an acceptable hashing algorithm for PBKDF2
			  String algorithm = "PBKDF2WithHmacSHA1";
			  // SHA-1 generates 160 bit hashes, so that's what makes sense here
			  int derivedKeyLength = 160;
			  // Pick an iteration count that works for you. The NIST recommends at
			  // least 1,000 iterations:
			  // http://csrc.nist.gov/publications/nistpubs/800-132/nist-sp800-132.pdf
			  // iOS 4.x reportedly uses 10,000:
			  // http://blog.crackpassword.com/2010/09/smartphone-forensics-cracking-blackberry-backup-passwords/
			  int iterations = 20000;

			  KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, iterations, derivedKeyLength);

			  SecretKeyFactory f = SecretKeyFactory.getInstance(algorithm);

			  return f.generateSecret(spec).getEncoded();
			 }

	public static byte[] generateSalt() throws NoSuchAlgorithmException {
			  // VERY important to use SecureRandom instead of just Random
			  SecureRandom random = SecureRandom.getInstance("SHA1PRNG");

			  // Generate a 8 byte (64 bit) salt as recommended by RSA PKCS5
			  byte[] salt = new byte[8];
			  random.nextBytes(salt);

			  return salt;
			 }
	
	
	
	
}





