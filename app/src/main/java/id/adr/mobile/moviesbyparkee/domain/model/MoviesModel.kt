package id.adr.mobile.moviesbyparkee.domain.model

data class MoviesModel(
    val page: Int,
    val results: List<MovieItemModel>,
    val totalPages: Int
)

data class MovieItemModel(
    val id: Int,
    val backdropPath: String,
    val posterPath: String,
    val title: String,
    val overview: String,
    val releaseDate: String
)