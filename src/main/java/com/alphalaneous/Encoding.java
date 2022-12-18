package com.alphalaneous;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Base64;

public class Encoding {

    public static String sha1(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");

            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);

            StringBuilder hashtext = new StringBuilder(no.toString(16));

            while (hashtext.length() < 32) hashtext.insert(0, "0");

            return hashtext.toString();
        }

        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
    public static String generateGJP(String password){
        String xored = Encoding.xor(password, String.valueOf(37526));
        return Base64.getUrlEncoder().encodeToString(xored.getBytes());

    }

    public static String generateCHK(int key, ArrayList<String> values, String salt){

        values.add(salt);

        String s = String.join("", values);

        String hashed = sha1(s);

        String xored = xor(hashed, String.valueOf(key));

        return Base64.getUrlEncoder().encodeToString(xored.getBytes());
    }

    public static String xorBasic(String inputString, int key) {
        StringBuilder outputString = new StringBuilder();

        for(char c : inputString.toCharArray()) {
            outputString.append((char) (c ^ key));

        }

        return outputString.toString();
    }

    public static String xor(String inputString, String key) {
        StringBuilder outputString = new StringBuilder();
        int j = 0;

        for(char c : inputString.toCharArray()) {
            outputString.append((char) (c ^ key.charAt(j)));
            j++;
            if (j == key.length()) j = 0;
        }

        return outputString.toString();
    }

}
