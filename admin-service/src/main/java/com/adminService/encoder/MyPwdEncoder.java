package com.adminService.encoder;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class MyPwdEncoder {
    public static void main(String[] args) {
        PasswordEncoder encoder = new BCryptPasswordEncoder();

        String encoded = encoder.encode("adminpswd");
        System.out.println("Encoded: "+encoded);

        System.out.println("data@123: "+encoder.matches("data@123", encoded));
        System.out.println("adminpswd: "+encoder.matches("adminpswd", encoded));
        System.out.println("demo@1234: "+encoder.matches("demo@1234", encoded));
    }
}