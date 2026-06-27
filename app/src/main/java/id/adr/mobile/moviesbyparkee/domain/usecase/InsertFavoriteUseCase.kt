package id.adr.mobile.moviesbyparkee.domain.usecase

import id.adr.mobile.moviesbyparkee.domain.model.MovieItemModel
import id.adr.mobile.moviesbyparkee.domain.repository.FavoriteRepository
import javax.inject.Inject

class InsertFavoriteUseCase @Inject constructor(
    private val favoriteRepository: FavoriteRepository
) {
    suspend operator fun invoke(favorite: MovieItemModel) = favoriteRepository.insertFavorite(favorite)
}