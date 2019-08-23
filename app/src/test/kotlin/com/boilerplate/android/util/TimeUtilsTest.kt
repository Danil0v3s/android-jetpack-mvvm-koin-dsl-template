package com.boilerplate.android.util

import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
import java.util.Calendar
import java.util.concurrent.TimeUnit

@RunWith(MockitoJUnitRunner::class)
class TimeUtilsTest {

    @Test
    fun getDaysBetween_withSameTimeStamp_returnZero() {
        // act
        val daysBetween = TimeUtils.getDaysBetween(1000L, 1000L)

        // assert
        assertEquals(daysBetween, 0)
    }

    @Test
    fun getDaysBetween_withLessThanTwentyFourHoursDifference_returnZero() {
        // prepare
        val dateOne = Calendar.getInstance().timeInMillis
        val dateTwo = dateOne + TimeUnit.HOURS.toMillis(23)

        // act
        val daysBetween = TimeUtils.getDaysBetween(dateOne, dateTwo)

        // assert
        assertEquals(daysBetween, 0)
    }

    @Test
    fun getDaysBetween_withMoreThanOneDayDifference_returnDifferenceBetweenTimestamps() {
        // prepare
        val dateOne = Calendar.getInstance().timeInMillis
        val dateTwo = dateOne - TimeUnit.DAYS.toMillis(3)

        // act
        val daysBetween = TimeUtils.getDaysBetween(dateOne, dateTwo)

        // assert
        assertEquals(daysBetween, 3)
    }

    @Test
    fun getDaysBetween_firstTimestampLowerThanSecondTimestamp_returnAbsoluteValue() {
        // prepare
        val calendarInstance = Calendar.getInstance()
        val dateOne = calendarInstance.timeInMillis - TimeUnit.DAYS.toMillis(10)
        val dateTwo = calendarInstance.timeInMillis

        // act
        val daysBetween = TimeUtils.getDaysBetween(dateOne, dateTwo)

        // assert
        assertEquals(daysBetween, 10)
    }
}