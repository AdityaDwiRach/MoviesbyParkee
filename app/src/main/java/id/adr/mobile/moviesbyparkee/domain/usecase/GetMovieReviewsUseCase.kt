package id.adr.mobile.moviesbyparkee.domain.usecase

import id.adr.mobile.moviesbyparkee.domain.repository.DetailRepository
import javax.inject.Inject

class GetMovieReviewsUseCase @Inject constructor(
    private val detailRepository: DetailRepository
) {
    operator fun invoke(id: Int, page: Int, language: String) =
        detailRepository.getMovieReviews(id, page, language)
}