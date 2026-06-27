package id.adr.mobile.moviesbyparkee.data.repository

import id.adr.mobile.moviesbyparkee.data.local.FavoriteDao
import id.adr.mobile.moviesbyparkee.data.local.FavoritePreference
import id.adr.mobile.moviesbyparkee.data.mapper.toEntity
import id.adr.mobile.moviesbyparkee.data.mapper.toModel
import id.adr.mobile.moviesbyparkee.domain.model.MovieItemModel
import id.adr.mobile.moviesbyparkee.domain.repository.FavoriteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class FavoriteRepositoryImpl @Inject constructor(
    private val favoriteDao: FavoriteDao,
    private val favoritePreference: FavoritePreference
) : FavoriteRepository {

    override fun getFavoriteMovies(): Flow<List<MovieItemModel>> {
        return favoriteDao.getFavorites().map { entities ->
            entities.map { it.toModel() }
        }
    }

    override fun isFavorite(id: Int): Boolean {
        return favoritePreference.isFavorite(id)
    }

    override suspend fun insertFavorite(favorite: MovieItemModel) {
        try {
            favoriteDao.insertFavorite(favorite.toEntity())
            favoritePreference.saveFavoriteId(favorite.id)
        } catch (e: Exception) {
            throw e
        }
    }

    override suspend fun deleteFavorite(favorite: MovieItemModel) {
        try {
            favoriteDao.deleteFavorite(favorite.toEntity())
            favoritePreference.removeFavoriteId(favorite.id)
        } catch (e: Exception) {
            throw e
        }
    }
}