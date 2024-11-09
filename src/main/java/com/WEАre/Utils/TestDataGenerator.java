package com.WEАre.Utils;
import java.util.Random;


public class TestDataGenerator {
    public static String generateUniqueUsername() {
        String baseUsername = "user";
        int length = 6; // Length of the random suffix
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder uniqueSuffix = new StringBuilder();

        Random random = new Random();
        for (int i = 0; i < length; i++) {
            uniqueSuffix.append(characters.charAt(random.nextInt(characters.length())));
        }

        return baseUsername + uniqueSuffix.toString();
    }
}
