package PasswordManagerClasses;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Scanner;

public class AES{

    private static final String ALGORITHM = "AES";
    private static SecretKey secretKey;

    static {
        initializeKey();
    }

    private static void initializeKey() {
        try {
            // Hardcoded key for simplicity; replace with secure key management
            String key = "1234567890123456"; // 16-byte key for AES-128
            secretKey = new SecretKeySpec(key.getBytes(), ALGORITHM);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String encrypt(String strToEncrypt) {
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] encryptedBytes = cipher.doFinal(strToEncrypt.getBytes());
            return Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String decrypt(String strToDecrypt) {
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(strToDecrypt));
            return new String(decryptedBytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

//    public static void main(String[] args) {
//        try {
//
//            Scanner scanner = new Scanner(System.in);
//            System.out.print("Enter a string to encrypt: ");
//            String originalString = scanner.nextLine();
//
//            // Encrypt the string
//            String encryptedString = encrypt(originalString);
//            System.out.println("Encrypted string: " + encryptedString);
//
//            // Decrypt the string
//            String decryptedString = decrypt(encryptedString);
//            System.out.println("Decrypted string: " + decryptedString);
//
//            scanner.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
