package id.adr.mobile.moviesbyparkee.domain.usecase

import id.adr.mobile.moviesbyparkee.domain.repository.FavoriteRepository
import javax.inject.Inject

class IsFavoriteUseCase @Inject constructor(
    private val favoriteRepository: FavoriteRepository
) {
    operator fun invoke(id: Int): Boolean = favoriteRepository.isFavorite(id)
}
