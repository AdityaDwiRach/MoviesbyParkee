package id.adr.mobile.moviesbyparkee.data.mapper

import id.adr.mobile.moviesbyparkee.data.local.FavoriteEntity
import id.adr.mobile.moviesbyparkee.domain.model.MovieItemModel

fun FavoriteEntity.toModel() = MovieItemModel(
    id, backdropPath, posterPath, title, overview, releaseDate
)

fun MovieItemModel.toEntity() = FavoriteEntity(
    id, backdropPath, posterPath, title, overview, releaseDate
)