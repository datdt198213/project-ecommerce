package com.dangdat.ecommerce.hash;

import javax.xml.bind.DatatypeConverter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.AccessDeniedException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {

    public static void main(String[] args) {
        String s = "Hello world";
        String s2 = "Hello world";

        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-512");
            byte[] hash = digest.digest(s.getBytes(StandardCharsets.UTF_8));
            byte[] hash2 = digest.digest(s2.getBytes(StandardCharsets.UTF_8));

            String rs = DatatypeConverter.printHexBinary(hash);
            String rs2 = DatatypeConverter.printHexBinary(hash2);
            System.out.println("RS: " + rs + "\tlength: " + rs.length() + "\ns2: " + rs2 + "\tlength: " +rs2.length());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

}
