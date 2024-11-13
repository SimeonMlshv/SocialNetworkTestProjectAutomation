package com.WEАre.Utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class LoginHelper {

    /**
     * Login method using Basic Authentication
     * @param username The username to log in with
     * @param password The password for the user
     * @return The session cookie extracted from the login response
     */
    public static String login(String username, String password) {
        // Set up basic authentication
        RestAssured.authentication = RestAssured.preemptive().basic(username, password);

        // Send the POST request to log in
        Response response = RestAssured.given()
                .header("Content-Type", "application/x-www-form-urlencoded")
                .queryParam("username", username)
                .queryParam("password", password)
                .post("/authenticate")
                .then()
                .statusCode(302) // Expecting a 302 redirect response
                .extract()
                .response(); // Extract the response

        // Extract the session cookie (assuming it's called "JSESSIONID")
        String sessionCookie = response.getCookie("JSESSIONID");
        return sessionCookie; // Return the session cookie
    }
}
