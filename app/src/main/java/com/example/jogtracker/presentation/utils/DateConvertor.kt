package com.example.jogtracker.presentation.utils

import java.text.SimpleDateFormat
import java.util.*

object DateConvertor{
    private const val DATE_FORMAT = "HH:mm:ss\ndd/MM/yyyy "

    fun toString(dateAsLong: Long): String {
        val dateFormat = SimpleDateFormat(DATE_FORMAT, Locale.US)
        return dateFormat.format(Date(dateAsLong))
    }
}
