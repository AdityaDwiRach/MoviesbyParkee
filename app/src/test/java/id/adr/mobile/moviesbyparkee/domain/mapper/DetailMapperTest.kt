package id.adr.mobile.moviesbyparkee.domain.mapper

import id.adr.mobile.moviesbyparkee.domain.model.MovieItemModel
import org.junit.Assert.assertEquals
import org.junit.Test

class DetailMapperTest {

    @Test
    fun `MovieItemModel orEmpty should return object when not null`() {
        val model = MovieItemModel(
            id = 1,
            backdropPath = "b",
            posterPath = "p",
            title = "t",
            overview = "o",
            releaseDate = "r"
        )
        
        val result = model.orEmpty()
        
        assertEquals(1, result.id)
        assertEquals("t", result.title)
    }

    @Test
    fun `MovieItemModel orEmpty should return default object when null`() {
        val model: MovieItemModel? = null
        
        val result = model.orEmpty()
        
        assertEquals(0, result.id)
        assertEquals("", result.title)
        assertEquals("", result.backdropPath)
    }
}
