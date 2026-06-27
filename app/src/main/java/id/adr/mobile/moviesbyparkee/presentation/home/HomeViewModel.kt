package id.adr.mobile.moviesbyparkee.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import id.adr.mobile.moviesbyparkee.domain.model.MovieItemModel
import id.adr.mobile.moviesbyparkee.domain.usecase.GetNowPlayingMoviesUseCase
import id.adr.mobile.moviesbyparkee.domain.usecase.GetPopularMoviesUseCase
import id.adr.mobile.moviesbyparkee.domain.usecase.GetTopRatedMoviesUseCase
import id.adr.mobile.moviesbyparkee.utils.Constants.ONE
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getNowPlayingMoviesUseCase: GetNowPlayingMoviesUseCase,
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase,
    private val getTopRatedMoviesUseCase: GetTopRatedMoviesUseCase
): ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    fun getMovies(languageTag: String) {
        _uiState.update { it.copy(isLoading = true) }
        viewModelScope.launch {
            combine(
                getNowPlayingMoviesUseCase(ONE, languageTag),
                getPopularMoviesUseCase(ONE, languageTag),
                getTopRatedMoviesUseCase(ONE, languageTag)
            ) { nowPlaying, popular, topRated ->
                HomeUiState(
                    nowPlayingMovies = nowPlaying?.results ?: emptyList(),
                    popularMovies = popular.results,
                    topRatedMovies = topRated.results,
                    isLoading = false
                )
            }.catch { e ->
                _uiState.update { it.copy(isLoading = false, errorMessage = e.message) }
            }.collect { newState ->
                _uiState.value = newState
            }
        }
    }
}
