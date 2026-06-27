package id.adr.mobile.moviesbyparkee.domain.repository

import id.adr.mobile.moviesbyparkee.domain.model.MovieItemModel
import kotlinx.coroutines.flow.Flow

interface FavoriteRepository {
    fun getFavoriteMovies(): Flow<List<MovieItemModel>>
    fun isFavorite(id: Int): Boolean
    suspend fun insertFavorite(favorite: MovieItemModel)
    suspend fun deleteFavorite(favorite: MovieItemModel)
}