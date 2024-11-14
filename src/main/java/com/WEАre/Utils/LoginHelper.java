package com.WEАre.Utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class LoginHelper {

    /**
     * Login method using Basic Authentication
     * @param username The username to log in with
     * @param password The password for the user
     * @return The session cookie extracted from the login response
     */
    public static String login(String username, String password) {
        RestAssured.authentication = RestAssured.preemptive().basic(username, password);
        Response response = RestAssured.given()
                .header("Content-Type", "application/x-www-form-urlencoded")
                .queryParam("username", username)
                .queryParam("password", password)
                .post("/authenticate")
                .then()
                .statusCode(302) // Expecting a 302 redirect response
                .extract()
                .response();

        return  response.getCookie("JSESSIONID");

    }

    }