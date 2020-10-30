package com.yuriysurzhikov.gidassistant.utils

import java.text.SimpleDateFormat
import java.util.*

object DateUtils {
    @JvmStatic
    fun calculateAge(birthday: Long): Int? {
        val bd = Calendar.getInstance().time
        bd.time = birthday
        return Calendar.getInstance().time.year - bd.year
    }
}