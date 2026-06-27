package id.adr.mobile.moviesbyparkee.domain.mapper

import id.adr.mobile.moviesbyparkee.domain.model.MovieItemModel
import id.adr.mobile.moviesbyparkee.utils.Constants.EMPTY_STRING
import id.adr.mobile.moviesbyparkee.utils.Constants.ZERO

fun MovieItemModel?.orEmpty() = this ?: MovieItemModel(
    ZERO,
    EMPTY_STRING,
    EMPTY_STRING,
    EMPTY_STRING,
    EMPTY_STRING,
    EMPTY_STRING
)