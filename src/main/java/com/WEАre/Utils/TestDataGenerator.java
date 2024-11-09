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

        return baseUsername + uniqueSuffix;
    }

    // Generates a random comment
    public static String generateRandomComment() {
        String baseComment = "Deadpool 3 is a funny movie";
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"; // Pool of random characters
        StringBuilder randomSuffix = new StringBuilder();

        Random random = new Random();
        int suffixLength = 6; // Length of the random addition

        for (int i = 0; i < suffixLength; i++) {
            randomSuffix.append(characters.charAt(random.nextInt(characters.length())));
        }

        return baseComment + " " + randomSuffix;
    }

}
