package id.adr.mobile.moviesbyparkee.domain.usecase

import id.adr.mobile.moviesbyparkee.domain.repository.FavoriteRepository
import javax.inject.Inject

class GetFavoriteMovieUseCase @Inject constructor(
    private val favoriteRepository: FavoriteRepository
) {
    operator fun invoke() = favoriteRepository.getFavoriteMovies()
}