package id.adr.mobile.moviesbyparkee.utils

import id.adr.mobile.moviesbyparkee.utils.Constants.STRIP
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

private fun String.toDateTime(pattern: String): LocalDateTime {
    return try {
        val formatter = DateTimeFormatter.ofPattern(pattern)
        try {
            LocalDateTime.parse(this, formatter)
        } catch (_: Exception) {
            LocalDate.parse(this, formatter).atStartOfDay()
        }
    } catch (_: Exception) {
        LocalDateTime.now()
    }
}

private fun LocalDateTime.toDateTimeDisplay(pattern: String) =
    this.format(DateTimeFormatter.ofPattern(pattern)) ?: STRIP

fun String.toDateTimeDisplay(patternIn: String, patternOut: String) =
    this.toDateTime(patternIn).toDateTimeDisplay(patternOut)