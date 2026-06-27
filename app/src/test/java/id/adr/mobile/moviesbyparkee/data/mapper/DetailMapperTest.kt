package id.adr.mobile.moviesbyparkee.data.mapper

import id.adr.mobile.moviesbyparkee.data.remote.dto.DetailMovieReviewItem
import id.adr.mobile.moviesbyparkee.data.remote.dto.GetDetailMovieReviewsResponse
import id.adr.mobile.moviesbyparkee.domain.model.MovieReviewsModel
import org.junit.Assert.assertEquals
import org.junit.Test

class DetailMapperTest {

    @Test
    fun `GetDetailMovieReviewsResponse toModel should map data correctly`() {
        val response = GetDetailMovieReviewsResponse(
            page = 1,
            results = listOf(
                DetailMovieReviewItem(author = "Author 1", content = "Content 1")
            ),
            totalPages = 2
        )

        val model = response.toModel()

        assertEquals(1, model.page)
        assertEquals(1, model.results.size)
        assertEquals("Author 1", model.results[0].author)
        assertEquals("Content 1", model.results[0].content)
        assertEquals(2, model.totalPages)
    }

    @Test
    fun `GetDetailMovieReviewsResponse toModel should handle null values`() {
        val response = GetDetailMovieReviewsResponse(null, null, null)
        val model = response.toModel()

        assertEquals(0, model.page)
        assertEquals(0, model.results.size)
        assertEquals(0, model.totalPages)
    }
}
