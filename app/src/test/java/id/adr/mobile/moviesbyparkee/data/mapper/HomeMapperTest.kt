package id.adr.mobile.moviesbyparkee.data.mapper

import id.adr.mobile.moviesbyparkee.data.remote.dto.GetMoviesResponse
import id.adr.mobile.moviesbyparkee.data.remote.dto.MovieItem
import id.adr.mobile.moviesbyparkee.domain.model.MoviesModel
import org.junit.Assert.assertEquals
import org.junit.Test

class HomeMapperTest {

    @Test
    fun `GetMoviesResponse toModel should map data correctly`() {
        val response = GetMoviesResponse(
            page = 1,
            results = listOf(
                MovieItem(id = 101, title = "Movie 1", backdropPath = "/path1"),
                MovieItem(id = 102, title = "Movie 2", posterPath = "/path2")
            ),
            totalPages = 5
        )

        val model = response.toModel()

        assertEquals(1, model.page)
        assertEquals(2, model.results.size)
        assertEquals(101, model.results[0].id)
        assertEquals("Movie 1", model.results[0].title)
        assertEquals("/path1", model.results[0].backdropPath)
        assertEquals(5, model.totalPages)
    }

    @Test
    fun `GetMoviesResponse toModel should handle null values`() {
        val response = GetMoviesResponse(null, null, null)
        val model = response.toModel()

        assertEquals(0, model.page)
        assertEquals(0, model.results.size)
        assertEquals(0, model.totalPages)
    }
}
