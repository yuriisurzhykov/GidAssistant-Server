package com.yuriysurzhikov.gidassistant.utils;
import java.util.*;

public class DateUtils {
    public static Integer calculateAge(Long birthday) {
        Date bd = Calendar.getInstance().getTime();
        bd.setTime(birthday);
        return Calendar.getInstance().getTime().getYear() - bd.getYear();
    }
}