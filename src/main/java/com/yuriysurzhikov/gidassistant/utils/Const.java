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
}
