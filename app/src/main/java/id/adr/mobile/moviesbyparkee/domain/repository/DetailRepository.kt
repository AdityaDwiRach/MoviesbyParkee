package id.adr.mobile.moviesbyparkee.domain.repository

import id.adr.mobile.moviesbyparkee.domain.model.MovieReviewsModel
import kotlinx.coroutines.flow.Flow

fun interface DetailRepository {
    fun getMovieReviews(
        id: Int,
        page: Int,
        language: String,
    ): Flow<MovieReviewsModel>
}