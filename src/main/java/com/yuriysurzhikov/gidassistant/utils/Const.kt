package com.yuriysurzhikov.gidassistant.utils;

object Const {

    object Repository {
        const val SAVE_SUCCESSFUL = 0;
        const val SAVE_FOUND_COINCIDENCE = 1000;
        const val SAVE_INVALID = -1;
    }

    object Locale {
        const val ENG = "en";
        const val RU = "ru";
        const val UA = "ua";
    }

    object Route {
        const val ROUTE_TYPE_RECOMMENDED = "";
    }
    
    object City {
        const val GET_CITY_TYPE_ALL = "all"
        const val GET_CITY_TYPE_BIG = "big"
        const val GET_CITY_TYPE_SMALL = "town"
    }
}
