package com.zhenxin.medicine.authentication.product;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.*;

import com.zhenxin.medicine.authentication.drug.DrugItem;

/**
 * This class functions as a serial code generator for validating our code.
 * @author Ivan
 *
 */
public class SerialGenerator {
	
	private final static String ALGO = "AES";
	// might want to move the secret key into Spring and encrypt the .properties file
	private final static byte [] secretKey = new byte[]{'B', 'a', 'r', 'b', 'e', 'q', 'u', 'e', 'B', 'a', 'r', 'b', 'e', 'q', 'u', 'e'};

	
	public static String encrypt(String data) throws Exception	{
		Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGO);
        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] encVal = c.doFinal(data.getBytes());
        String encryptedValue = new BASE64Encoder().encode(encVal);
        return encryptedValue;
	}
	
	public static String decrypt(String encryptedData) throws Exception	{
		Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGO);
        c.init(Cipher.DECRYPT_MODE, key);
        byte[] decodedValue = new BASE64Decoder().decodeBuffer(encryptedData);
        byte[] decValue = c.doFinal(decodedValue);
        String decryptedValue = new String(decValue);
        return decryptedValue;
	}

	private static Key generateKey() {
		Key key = new SecretKeySpec(secretKey, ALGO);
		return key;
	}
	
}

