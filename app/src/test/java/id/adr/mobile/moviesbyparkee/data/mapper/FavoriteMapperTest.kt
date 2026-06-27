package id.adr.mobile.moviesbyparkee.data.mapper

import id.adr.mobile.moviesbyparkee.data.local.FavoriteEntity
import id.adr.mobile.moviesbyparkee.domain.model.MovieItemModel
import org.junit.Assert.assertEquals
import org.junit.Test

class FavoriteMapperTest {

    @Test
    fun `FavoriteEntity toModel should map data correctly`() {
        val entity = FavoriteEntity(
            id = 1,
            backdropPath = "/backdrop",
            posterPath = "/poster",
            title = "Title",
            overview = "Overview",
            releaseDate = "2024"
        )

        val model = entity.toModel()

        assertEquals(1, model.id)
        assertEquals("Title", model.title)
        assertEquals("/backdrop", model.backdropPath)
        assertEquals("/poster", model.posterPath)
        assertEquals("Overview", model.overview)
        assertEquals("2024", model.releaseDate)
    }

    @Test
    fun `MovieItemModel toEntity should map data correctly`() {
        val model = MovieItemModel(
            id = 1,
            backdropPath = "/backdrop",
            posterPath = "/poster",
            title = "Title",
            overview = "Overview",
            releaseDate = "2024"
        )

        val entity = model.toEntity()

        assertEquals(1, entity.id)
        assertEquals("Title", entity.title)
        assertEquals("/backdrop", entity.backdropPath)
        assertEquals("/poster", entity.posterPath)
        assertEquals("Overview", entity.overview)
        assertEquals("2024", entity.releaseDate)
    }
}
