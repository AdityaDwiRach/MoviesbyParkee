package id.adr.mobile.moviesbyparkee.presentation.favorite

import id.adr.mobile.moviesbyparkee.domain.model.MovieItemModel

data class FavoriteUiState(
    val favorite: List<MovieItemModel> = listOf(),
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)