package id.adr.mobile.moviesbyparkee.data.mapper

import id.adr.mobile.moviesbyparkee.data.remote.dto.GetMoviesResponse
import id.adr.mobile.moviesbyparkee.data.remote.dto.MovieItem
import id.adr.mobile.moviesbyparkee.domain.model.MovieItemModel
import id.adr.mobile.moviesbyparkee.domain.model.MoviesModel
import id.adr.mobile.moviesbyparkee.utils.Constants.EMPTY_STRING
import id.adr.mobile.moviesbyparkee.utils.Constants.ZERO

fun GetMoviesResponse.toModel() = MoviesModel(
    page = page ?: ZERO,
    results = results?.map { it.toModel() } ?: emptyList(),
    totalPages = totalPages ?: ZERO
)

fun MovieItem.toModel() = MovieItemModel(
    id ?: ZERO,
    backdropPath ?: EMPTY_STRING,
    posterPath ?: EMPTY_STRING,
    title ?: EMPTY_STRING,
    overview ?: EMPTY_STRING,
    releaseDate ?: EMPTY_STRING
)