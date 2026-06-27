package id.adr.mobile.moviesbyparkee.data.repository

import id.adr.mobile.moviesbyparkee.data.mapper.toModel
import id.adr.mobile.moviesbyparkee.data.remote.api.HomeService
import id.adr.mobile.moviesbyparkee.domain.repository.HomeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val service: HomeService
): HomeRepository {
    override fun getPopularMovies(page: Int, language: String) = flow {
        emit(
            service.getPopularMovies(
                page = page,
                language = language,
            ).toModel()
        )
    }.flowOn(Dispatchers.IO)

    override fun getTopRatedMovies(page: Int, language: String) = flow {
        emit(
            service.getTopRatedMovies(
                page = page,
                language = language,
            ).toModel()
        )
    }.flowOn(Dispatchers.IO)

    override fun getNowPlayingMovies(page: Int, language: String) = flow {
        emit(
            service.getNowPlayingMovies(
                page = page,
                language = language,
            ).toModel()
        )
    }.flowOn(Dispatchers.IO)
}