package id.adr.mobile.moviesbyparkee.presentation.detail

import id.adr.mobile.moviesbyparkee.domain.model.DetailReviewItem

data class DetailUiState(
    val movieDetail: DetailReviewItem? = null,
    val isLoading: Boolean = false,
    val isFavorite: Boolean = false,
    val errorMessage: String? = null
)
