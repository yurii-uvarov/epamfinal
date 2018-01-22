package ua.nure.uvarov.Practice3;

import java.security.*;
import java.util.Formatter;


public class Part4 {
    public static String hash(String input, String algorithm) throws NoSuchAlgorithmException {
        Formatter formatter = new Formatter();
        MessageDigest digest = MessageDigest.getInstance(algorithm);
        digest.update(input.getBytes());
        byte[] hash = digest.digest();
        for (int i = 0; i < hash.length; i++) {
            if (Byte.toString(hash[i]).length() == 1) {
                formatter.format("0%x",Byte.toUnsignedInt(hash[i]));
            }else {
                formatter.format("%x", Byte.toUnsignedInt(hash[i]));
            }
        }
        return formatter.toString().toUpperCase();
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println(hash("passwort", "SHA-256"));
        System.out.println(hash("password", "SHA-256"));

    }
}