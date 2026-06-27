package id.adr.mobile.moviesbyparkee.data.remote.dto

import com.google.gson.annotations.SerializedName

data class GetDetailMovieReviewsResponse(
    @SerializedName("page")
    val page: Int? = null,
    @SerializedName("results")
    val results: List<DetailMovieReviewItem>? = null,
    @SerializedName("total_pages")
    val totalPages: Int? = null
)

data class DetailMovieReviewItem(
    @SerializedName("author")
    val author: String? = null,
    @SerializedName("content")
    val content: String? = null
)