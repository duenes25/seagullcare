package com.headhigh.seagullcare.test.login;

import com.headhigh.seagullcare.service.CryptHelper;

import junit.framework.TestCase;


public class CryptTest extends TestCase {
	 
		public void testEncrypt() {
			String encrypted = CryptHelper.encrypt("25E25e2144");
			System.out.println(encrypted);
			
		}
		
		public void testDecrypt() {
			String decrypted = CryptHelper.decrypt(CryptHelper.encrypt("test"));
			assertEquals("test", decrypted);
		}
		
		
		
		
		
	}


