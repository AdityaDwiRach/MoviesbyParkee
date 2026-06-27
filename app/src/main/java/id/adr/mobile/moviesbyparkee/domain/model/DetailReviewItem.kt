package id.adr.mobile.moviesbyparkee.domain.model

data class DetailReviewItem(
    val movie: MovieItemModel,
    val reviews: List<MovieReviewItem>
)
