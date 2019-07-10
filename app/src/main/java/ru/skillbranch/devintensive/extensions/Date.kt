package ru.skillbranch.devintensive.extensions

import java.text.SimpleDateFormat
import java.util.*

const val SECOND = 1000L
const val MINUTE = 60 * SECOND
const val HOUR = 60 * MINUTE
const val DAY = 24 * HOUR

fun Date.format(pattern: String = "HH:mm:ss dd.MM.yy"): String {
    val dateFormat = SimpleDateFormat(pattern, Locale("ru"))

    return dateFormat.format(this)
}

fun Date.add(value: Int, units: TimeUnits = TimeUnits.SECONDS): Date {
    var time = this.time

    time += when (units) {
        TimeUnits.SECONDS -> value * SECOND
        TimeUnits.MINUTE -> value * MINUTE
        TimeUnits.HOUR -> value * HOUR
        TimeUnits.DAY -> value * DAY
    }

    this.time = time
    return this

}

fun Date.humanizeDiff(date: Date = Date()): String {
    var time = this.time
    var outputTime: String

    outputTime = when (date) {
        date.add(time.toInt(), TimeUnits.SECONDS) -> "несколько $SECOND назад"
        else -> "только что"
    }

    return outputTime
}




enum class TimeUnits{
    SECONDS,
    MINUTE,
    HOUR,
    DAY
}