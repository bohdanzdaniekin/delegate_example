package com.bohdanzdaniekin.delegate.ui.util.date

import android.util.Log
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

object DateTimeFormatter {

    private val tag = this::class.java.canonicalName

    fun format(
        date: String,
        inputFormat: DateTimeFormats,
        outputFormat: DateTimeFormats
    ): String {
        return try {
            format(parse(date, inputFormat), outputFormat)
        } catch (e: Exception) {
            Log.e(tag, e.localizedMessage, e)
            ""
        }
    }

    fun format(date: Date, outputFormat: DateTimeFormats): String {
        val formatter = getSimpleDateFormat(outputFormat.format)
        return formatter.format(date)
    }

    fun parse(date: String, format: DateTimeFormats): Date {
        val parser = getSimpleDateFormat(format.format)
        return parser.parse(date)
    }

    private fun getSimpleDateFormat(patter: String): SimpleDateFormat {
        return SimpleDateFormat(patter, Locale.ENGLISH)
    }
}