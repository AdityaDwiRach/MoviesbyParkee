package id.adr.mobile.moviesbyparkee.data.repository

import id.adr.mobile.moviesbyparkee.data.mapper.toModel
import id.adr.mobile.moviesbyparkee.data.remote.api.DetailService
import id.adr.mobile.moviesbyparkee.domain.repository.DetailRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class DetailRepositoryImpl @Inject constructor(
    private val service: DetailService
): DetailRepository {
    override fun getMovieReviews(
        id: Int,
        page: Int,
        language: String
    ) = flow {
        emit(
            service.getMovieReviews(
                id = id,
                page = page,
                language = language,
            ).toModel()
        )
    }.flowOn(Dispatchers.IO)
}