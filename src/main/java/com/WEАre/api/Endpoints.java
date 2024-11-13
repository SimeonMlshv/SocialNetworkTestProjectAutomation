package com.WEАre.api;

public class Endpoints {

    public static final String BASE_URL = "http://localhost:8081";  // or use the internal Docker network name if accessing it from another container
    public static final String REGISTER_USER = BASE_URL + "/register";
    public static final String LOGIN_USER = BASE_URL + "/login";
    public static final String GET_USERS = BASE_URL + "/users";
}
