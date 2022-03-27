package gov.iti.jets.shoppy.presentation.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashManager {

        /* Driver Code */
        public String generateSecurePassword(String password) {
            /* Plain-text password initialization. */
            String encryptedpassword = null;
            try {
                /* MessageDigest instance for MD5. */
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");

                /* Add plain-text password bytes to digest using MD5 update() method. */
                messageDigest.update(password.getBytes());

                /* Convert the hash value into bytes */
                byte[] bytes = messageDigest.digest();

                /*
                 * The bytes array has bytes in decimal form. Converting it into hexadecimal
                 * format.
                 */
                StringBuilder s = new StringBuilder();
                for (int i = 0; i < bytes.length; i++) {
                    s.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
                }

                /* Complete hashed password in hexadecimal format */
                encryptedpassword = s.toString();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            return encryptedpassword;

        }

}
