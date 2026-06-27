package id.adr.mobile.moviesbyparkee.domain.repository

import id.adr.mobile.moviesbyparkee.domain.model.MoviesModel
import kotlinx.coroutines.flow.Flow

interface HomeRepository {
    fun getPopularMovies(page: Int, language: String): Flow<MoviesModel>

    fun getTopRatedMovies(page: Int, language: String): Flow<MoviesModel>

    fun getNowPlayingMovies(page: Int, language: String): Flow<MoviesModel?>
}