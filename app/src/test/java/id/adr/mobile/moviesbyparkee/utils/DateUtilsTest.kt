package id.adr.mobile.moviesbyparkee.utils

import id.adr.mobile.moviesbyparkee.utils.Constants.YYYY
import id.adr.mobile.moviesbyparkee.utils.Constants.YYYY_MM_DD
import org.junit.Assert.assertEquals
import org.junit.Test
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class DateUtilsTest {

    @Test
    fun `toDateTimeDisplay should format valid date string correctly`() {
        val inputDate = "2024-05-20"
        val expectedOutput = "2024"
        
        val result = inputDate.toDateTimeDisplay(YYYY_MM_DD, YYYY)
        
        assertEquals(expectedOutput, result)
    }

    @Test
    fun `toDateTimeDisplay should return current year for invalid date string`() {
        val invalidDate = "invalid-date"
        val expectedYear = LocalDateTime.now().format(DateTimeFormatter.ofPattern(YYYY))
        
        val result = invalidDate.toDateTimeDisplay(YYYY_MM_DD, YYYY)
        
        assertEquals(expectedYear, result)
    }

    @Test
    fun `toDateTimeDisplay should return current year for empty date string`() {
        val emptyDate = ""
        val expectedYear = LocalDateTime.now().format(DateTimeFormatter.ofPattern(YYYY))
        
        val result = emptyDate.toDateTimeDisplay(YYYY_MM_DD, YYYY)
        
        assertEquals(expectedYear, result)
    }
    
    @Test
    fun `toDateTimeDisplay should handle different output patterns`() {
        val inputDate = "2024-05-20"
        val outputPattern = "MM/yyyy"
        val expectedOutput = "05/2024"
        
        val result = inputDate.toDateTimeDisplay(YYYY_MM_DD, outputPattern)
        
        assertEquals(expectedOutput, result)
    }
}
