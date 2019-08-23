package com.boilerplate.android.util

import java.util.concurrent.TimeUnit

class TimeUtils {

    companion object {
        fun getDaysBetween(timestampOne: Long, timestampTwo: Long): Long {
            val diffDays = TimeUnit.DAYS.convert(timestampOne - timestampTwo, TimeUnit.MILLISECONDS)
            return Math.abs(diffDays)
        }
    }
}