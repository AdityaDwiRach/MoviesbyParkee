package id.adr.mobile.moviesbyparkee.presentation.home

import app.cash.turbine.test
import id.adr.mobile.moviesbyparkee.domain.model.MoviesModel
import id.adr.mobile.moviesbyparkee.domain.usecase.GetNowPlayingMoviesUseCase
import id.adr.mobile.moviesbyparkee.domain.usecase.GetPopularMoviesUseCase
import id.adr.mobile.moviesbyparkee.domain.usecase.GetTopRatedMoviesUseCase
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

class HomeViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private val getNowPlayingMoviesUseCase: GetNowPlayingMoviesUseCase = mockk()
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase = mockk()
    private val getTopRatedMoviesUseCase: GetTopRatedMoviesUseCase = mockk()

    private lateinit var viewModel: HomeViewModel

    private val mockMoviesModel = MoviesModel(1, emptyList(), 1)

    @Before
    fun setUp() {
        every { getNowPlayingMoviesUseCase(any(), any()) } returns flowOf(mockMoviesModel)
        every { getPopularMoviesUseCase(any(), any()) } returns flowOf(mockMoviesModel)
        every { getTopRatedMoviesUseCase(any(), any()) } returns flowOf(mockMoviesModel)
        
        // HomeViewModel calls getMovies in init
        viewModel = HomeViewModel(
            getNowPlayingMoviesUseCase,
            getPopularMoviesUseCase,
            getTopRatedMoviesUseCase
        )
    }

    @Test
    fun `getMovies should update uiState with results from use cases`() = runTest {
        viewModel.uiState.test {
            val state = awaitItem()
            assertFalse(state.isLoading)
            assertEquals(mockMoviesModel.results, state.nowPlayingMovies)
            assertEquals(mockMoviesModel.results, state.popularMovies)
            assertEquals(mockMoviesModel.results, state.topRatedMovies)
        }
    }
}
