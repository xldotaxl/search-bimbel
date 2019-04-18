package it.aldi.app.controller;

import org.springframework.stereotype.Component;

@Component
public class Routes {

    // MVC
    public static final String INDEX = "/";
    public static final String LOGOUT = "/logout";
    public static final String REGISTER = "/register";
    public static final String SEARCH = "/search";
    public static final String SIGNIN = "/signin";

    // REST
    public static final String API = "/api";
    public static final String PROVINCE = "/province";
    public static final String API_PROVINCE = API + PROVINCE;
}
