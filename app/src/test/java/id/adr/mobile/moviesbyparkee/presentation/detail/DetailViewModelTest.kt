package id.adr.mobile.moviesbyparkee.presentation.detail

import app.cash.turbine.test
import id.adr.mobile.moviesbyparkee.domain.model.MovieItemModel
import id.adr.mobile.moviesbyparkee.domain.model.MovieReviewsModel
import id.adr.mobile.moviesbyparkee.domain.usecase.DeleteFavoriteUseCase
import id.adr.mobile.moviesbyparkee.domain.usecase.GetMovieReviewsUseCase
import id.adr.mobile.moviesbyparkee.domain.usecase.InsertFavoriteUseCase
import id.adr.mobile.moviesbyparkee.domain.usecase.IsFavoriteUseCase
import id.adr.mobile.moviesbyparkee.utils.MainDispatcherRule
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class DetailViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private val getMovieReviewsUseCase: GetMovieReviewsUseCase = mockk()
    private val deleteFavoriteUseCase: DeleteFavoriteUseCase = mockk()
    private val insertFavoriteUseCase: InsertFavoriteUseCase = mockk()
    private val isFavoriteUseCase: IsFavoriteUseCase = mockk()

    private lateinit var viewModel: DetailViewModel

    private val mockMovie = MovieItemModel(1, "", "", "Title", "Overview", "2024")
    private val mockReviews = MovieReviewsModel(1, emptyList(), 1)

    @Before
    fun setUp() {
        viewModel = DetailViewModel(
            getMovieReviewsUseCase,
            deleteFavoriteUseCase,
            insertFavoriteUseCase,
            isFavoriteUseCase
        )
        viewModel.movieArgs = mockMovie
    }

    @Test
    fun `getMovieReview should update uiState with results and check favorite status`() = runTest {
        every { isFavoriteUseCase(mockMovie.id) } returns true
        every { getMovieReviewsUseCase(mockMovie.id, any(), any()) } returns flowOf(mockReviews)

        viewModel.getMovieReview("en-US")

        viewModel.uiState.test {
            val state = awaitItem()
            assertFalse(state.isLoading)
            assertTrue(state.isFavorite)
            assertEquals(mockMovie.id, state.movieDetail?.movie?.id)
            assertEquals(mockReviews.results, state.movieDetail?.reviews)
        }
    }

    @Test
    fun `toggleFavorite from not favorite should call insertFavoriteUseCase`() = runTest {
        _testToggleFavorite(initialFavorite = false)
    }

    @Test
    fun `toggleFavorite from favorite should call deleteFavoriteUseCase`() = runTest {
        _testToggleFavorite(initialFavorite = true)
    }

    private fun _testToggleFavorite(initialFavorite: Boolean) = runTest {
        every { isFavoriteUseCase(mockMovie.id) } returns initialFavorite
        every { getMovieReviewsUseCase(any(), any(), any()) } returns flowOf(mockReviews)
        coEvery { insertFavoriteUseCase(any()) } returns Unit
        coEvery { deleteFavoriteUseCase(any()) } returns Unit

        viewModel.getMovieReview("en-US")
        
        viewModel.toggleFavorite()

        viewModel.uiState.test {
            val state = awaitItem()
            assertEquals(!initialFavorite, state.isFavorite)
            if (initialFavorite) {
                coVerify { deleteFavoriteUseCase(mockMovie) }
            } else {
                coVerify { insertFavoriteUseCase(mockMovie) }
            }
        }
    }
}
