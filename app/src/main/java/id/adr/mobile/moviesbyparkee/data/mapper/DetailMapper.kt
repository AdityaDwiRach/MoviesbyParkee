package id.adr.mobile.moviesbyparkee.data.mapper

import id.adr.mobile.moviesbyparkee.data.remote.dto.DetailMovieReviewItem
import id.adr.mobile.moviesbyparkee.data.remote.dto.GetDetailMovieReviewsResponse
import id.adr.mobile.moviesbyparkee.domain.model.MovieReviewItem
import id.adr.mobile.moviesbyparkee.domain.model.MovieReviewsModel
import id.adr.mobile.moviesbyparkee.utils.Constants.EMPTY_STRING
import id.adr.mobile.moviesbyparkee.utils.Constants.ZERO

fun GetDetailMovieReviewsResponse.toModel() = MovieReviewsModel(
    page = page ?: ZERO,
    results = results?.map { it.toModel() } ?: emptyList(),
    totalPages = totalPages ?: ZERO
)

fun DetailMovieReviewItem.toModel() = MovieReviewItem(
    author = author ?: EMPTY_STRING,
    content = content ?: EMPTY_STRING
)