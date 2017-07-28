package org.academiadecodigo.bootcamp.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Security {

    public static String getHash(String password){

        try {

            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(password.getBytes());

            byte byteData[] = md.digest();

            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < byteData.length; i++) {
                String hex = Integer.toHexString(0xff & byteData[i]);
                if (hex.length() == 1){
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            System.err.println("Error: " + e.getMessage());
            System.exit(1);
        }

        return null;
    }

}
