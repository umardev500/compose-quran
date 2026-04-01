package com.example.quran.core.util

object NumberMapper {

    // Map from Western digits to Arabic-Indic digits
    private val arabicDigits = mapOf(
        '0' to '٠',
        '1' to '١',
        '2' to '٢',
        '3' to '٣',
        '4' to '٤',
        '5' to '٥',
        '6' to '٦',
        '7' to '٧',
        '8' to '٨',
        '9' to '٩'
    )

    // Function to convert a number (Int, Long, etc.) to Arabic numerals
    fun toArabic(number: Number): String {
        return number.toString().map { arabicDigits[it] ?: it }.joinToString("")
    }

    // Function to convert a String containing digits
    fun toArabic(string: String): String {
        return string.map { arabicDigits[it] ?: it }.joinToString("")
    }
}