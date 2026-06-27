package id.adr.mobile.moviesbyparkee.data.remote.api

import id.adr.mobile.moviesbyparkee.data.remote.dto.GetMoviesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface HomeService {
    @GET("popular")
    suspend fun getPopularMovies(
        @Query("l") page: Int,
        @Query("language") language: String,
        @Query("sort_by") sortBy: String = "popularity.desc"
    ): GetMoviesResponse

    @GET("top_rated")
    suspend fun getTopRatedMovies(
        @Query("page") page: Int,
        @Query("language") language: String,
        @Query("sort_by") sortBy: String = "vote_average.desc"
    ): GetMoviesResponse

    @GET("now_playing")
    suspend fun getNowPlayingMovies(
        @Query("page") page: Int,
        @Query("language") language: String,
        @Query("sort_by") sortBy: String = "popularity.desc"
    ): GetMoviesResponse
}