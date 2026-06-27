package id.adr.mobile.moviesbyparkee.presentation.home

import id.adr.mobile.moviesbyparkee.domain.model.MovieItemModel

data class HomeUiState(
    val nowPlayingMovies: List<MovieItemModel> = emptyList(),
    val popularMovies: List<MovieItemModel> = emptyList(),
    val topRatedMovies: List<MovieItemModel> = emptyList(),
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)
