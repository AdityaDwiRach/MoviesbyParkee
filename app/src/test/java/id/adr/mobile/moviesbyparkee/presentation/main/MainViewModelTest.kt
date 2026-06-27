package id.adr.mobile.moviesbyparkee.presentation.main

import app.cash.turbine.test
import id.adr.mobile.moviesbyparkee.domain.model.MovieItemModel
import id.adr.mobile.moviesbyparkee.utils.MainDispatcherRule
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private lateinit var viewModel: MainViewModel

    @Before
    fun setUp() {
        viewModel = MainViewModel()
    }

    @Test
    fun `navigateToDetail should update navigation state with ToDetail`() = runTest {
        val movie = MovieItemModel(
            id = 1,
            title = "Test Movie",
            backdropPath = "",
            posterPath = "",
            overview = "",
            releaseDate = ""
        )
        viewModel.navigateToDetail(movie)

        viewModel.uiState.test {
            val state = awaitItem()
            val navigation = state.navigation as MainNavigation.ToDetail
            assertEquals(movie, navigation.movie)
        }
    }

    @Test
    fun `navigateToFavorite should update navigation state with ToFavorite`() = runTest {
        viewModel.navigateToFavorite()

        viewModel.uiState.test {
            val state = awaitItem()
            assertEquals(MainNavigation.ToFavorite, state.navigation)
        }
    }

    @Test
    fun `navigateBack should update navigation state with Back`() = runTest {
        viewModel.navigateBack()

        viewModel.uiState.test {
            val state = awaitItem()
            assertEquals(MainNavigation.Back, state.navigation)
        }
    }

    @Test
    fun `onNavigationConsumed should set navigation state to null`() = runTest {
        viewModel.navigateToFavorite()
        viewModel.onNavigationConsumed()

        viewModel.uiState.test {
            val state = awaitItem()
            assertNull(state.navigation)
        }
    }
}
