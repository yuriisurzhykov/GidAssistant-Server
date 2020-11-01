package com.yuriysurzhikov.gidassistant.utils;

public class Const {

    public static class Repository {
        public static final Integer SAVE_SUCCESSFUL = 0;
        public static final Integer SAVE_FOUND_COINCIDENCE = 1000;
        public static final Integer SAVE_INVALID = -1;
    }

    public static class Locale {
        public static final String ENG = "en";
        public static final String RU = "ru";
        public static final String UA = "ua";
    }

    public static class Route {
        public static final String ROUTE_TYPE_RECOMMENDED = "";
    }

    public static class City {
        public static final String GET_CITY_TYPE_ALL = "all";
        public static final String GET_CITY_TYPE_BIG = "big";
        public static final String GET_CITY_TYPE_SMALL = "town";
    }

    public static class User {
        public static final String UNIQUE_ID_KEY = "unique_id";
        public static final String SESSION_ID_KEY = "session_id_key";
        public static final String ERROR_SESSION_MESSAGE = "error_message";
    }

    public static class Messages {
        public static final String login_error_message = "Error was occurred during user login!";
    }
}
