package id.adr.mobile.moviesbyparkee.data.remote.dto

import com.google.gson.annotations.SerializedName

data class GetMoviesResponse(
    @SerializedName("page")
    val page: Int? = null,
    @SerializedName("results")
    val results: List<MovieItem>? = null,
    @SerializedName("total_pages")
    val totalPages: Int? = null
)

data class MovieItem(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("backdrop_path")
    val backdropPath: String? = null,
    @SerializedName("poster_path")
    val posterPath: String? = null,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("overview")
    val overview: String? = null,
    @SerializedName("release_date")
    val releaseDate: String? = null
)
