package id.adr.mobile.moviesbyparkee.presentation.main

import androidx.annotation.IdRes
import id.adr.mobile.moviesbyparkee.domain.model.MovieItemModel

sealed class MainNavigation {
    data class ToDetail(val movie: MovieItemModel) : MainNavigation()
    data object ToFavorite : MainNavigation()
    data object Back : MainNavigation()
}

data class MainUiState(
    val navigation: MainNavigation? = null
)
