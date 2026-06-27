package id.adr.mobile.moviesbyparkee.presentation.favorite

import app.cash.turbine.test
import id.adr.mobile.moviesbyparkee.domain.model.MovieItemModel
import id.adr.mobile.moviesbyparkee.domain.usecase.GetFavoriteMovieUseCase
import id.adr.mobile.moviesbyparkee.utils.MainDispatcherRule
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class FavoriteViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private val getFavoriteMovieUseCase: GetFavoriteMovieUseCase = mockk()

    private lateinit var viewModel: FavoriteViewModel

    private val mockFavoriteList = listOf(
        MovieItemModel(1, "", "", "Title 1", "Overview 1", "2024"),
        MovieItemModel(2, "", "", "Title 2", "Overview 2", "2024")
    )

    @Before
    fun setUp() {
        every { getFavoriteMovieUseCase() } returns flowOf(mockFavoriteList)
        
        // FavoriteViewModel calls getFavorites in init
        viewModel = FavoriteViewModel(getFavoriteMovieUseCase)
    }

    @Test
    fun `getFavorites should update uiState with favorite movies`() = runTest {
        viewModel.uiState.test {
            val state = awaitItem()
            assertFalse(state.isLoading)
            assertEquals(mockFavoriteList, state.favorite)
        }
    }
}
