package it.aldi.app.controller;

import org.springframework.stereotype.Component;

@Component
public class Routes {

    /*
     * MVC endpoint
     */
    public static final String INDEX = "/";
    public static final String LOGOUT = "/logout";
    public static final String REGISTER = "/register";
    public static final String SEARCH = "/search";
    public static final String SIGNIN = "/signin";
    // TUTOR
    public static final String TUTOR_HOME = "/tutor";
    public static final String TUTOR_SCHEDULE = TUTOR_HOME + "/schedule";
    // STUDENT
    public static final String STUDENT_HOME = "/student";
    // OWNER
    public static final String OWNER_HOME = "/owner";
    public static final String OWNER_USER_MANAGEMENT = OWNER_HOME + "/user_management";

    /*
     * Rest endpoint
     */
    public static final String API = "/api";
    public static final String CITIES = "/cities";
    public static final String PROVINCES = "/provinces";
    public static final String API_CITIES = API + CITIES;
    public static final String API_PROVINCE = API + PROVINCES;
}
