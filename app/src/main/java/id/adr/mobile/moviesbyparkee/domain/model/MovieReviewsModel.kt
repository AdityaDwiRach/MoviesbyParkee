package id.adr.mobile.moviesbyparkee.domain.model

data class MovieReviewsModel(
    val page: Int,
    val results: List<MovieReviewItem>,
    val totalPages: Int
)

data class MovieReviewItem(
    val author: String,
    val content: String
)