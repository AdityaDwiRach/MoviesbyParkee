package id.adr.mobile.moviesbyparkee.data.remote.api

import id.adr.mobile.moviesbyparkee.data.remote.dto.GetDetailMovieReviewsResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

fun interface DetailService {
    @GET("{movie_id}/reviews")
    suspend fun getMovieReviews(
        @Path("movie_id") id: Int,
        @Query("page") page: Int,
        @Query("language") language: String,
    ): GetDetailMovieReviewsResponse
}