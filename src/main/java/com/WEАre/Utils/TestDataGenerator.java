package com.WEАre.Utils;

import java.util.Random;

public class TestDataGenerator {

    // Generates a unique username
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

    // Generate a random title for the post
    public static String generateRandomTitle() {
        String[] titles = {
                "Exciting News!",
                "Big Announcement",
                "Latest Updates",
                "Breaking News",
                "Special Offer",
                "New Features Released"
        };

        Random random = new Random();
        int index = random.nextInt(titles.length); // Randomly pick a title from the array
        return titles[index];
    }

    // Generate a random body for the post
    public static String generateRandomBody() {
        String[] bodies = {
                "We are excited to share this with you. Stay tuned for more details.",
                "This is a special announcement about something big. Keep an eye out for updates.",
                "Our team has been working hard on something new, and we're happy to share it with you.",
                "We've launched something awesome! Check it out and let us know what you think.",
                "A lot of great things are happening, and we want you to be part of it."
        };

        Random random = new Random();
        int index = random.nextInt(bodies.length); // Randomly pick a body from the array
        return bodies[index];
    }
}
