package id.adr.mobile.moviesbyparkee.domain.usecase

import id.adr.mobile.moviesbyparkee.domain.repository.HomeRepository
import javax.inject.Inject

class GetNowPlayingMoviesUseCase @Inject constructor(
    private val homeRepository: HomeRepository
) {
    operator fun invoke(page: Int, language: String) =
        homeRepository.getNowPlayingMovies(page, language)
}