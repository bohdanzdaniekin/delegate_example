package com.bohdanzdaniekin.delegate.ui.util.date

enum class DateTimeFormats(val format: String) {

    DEFAULT_DATE_FORMAT("d MMM yyyy"),
    FULL_DATE_TIME("yyyy-MM-dd HH:mm:ss"),
    DAY_SHORT_MONTH_SHORT("d MMM"),
    FULL_DATE_TIME_T("yyyy-MM-dd'T'HH:mm:ss"),

    TIME_HOURS_MINUTES_SECONDS("HH:mm:ss"),
    TIME_HOURS_MINUTES_SECONDS_12("HH:mm:ss aa"),
    TIME_HOURS_MINUTES("HH:mm")
}
