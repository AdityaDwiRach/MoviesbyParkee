package id.adr.mobile.moviesbyparkee.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import id.adr.mobile.moviesbyparkee.data.repository.DetailRepositoryImpl
import id.adr.mobile.moviesbyparkee.data.repository.FavoriteRepositoryImpl
import id.adr.mobile.moviesbyparkee.data.repository.HomeRepositoryImpl
import id.adr.mobile.moviesbyparkee.domain.repository.DetailRepository
import id.adr.mobile.moviesbyparkee.domain.repository.FavoriteRepository
import id.adr.mobile.moviesbyparkee.domain.repository.HomeRepository

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindFavoriteRepository(
        impl: FavoriteRepositoryImpl
    ): FavoriteRepository

    @Binds
    abstract fun bindDetailRepository(
        impl: DetailRepositoryImpl
    ): DetailRepository

    @Binds
    abstract fun bindHomeRepository(
        impl: HomeRepositoryImpl
    ): HomeRepository
}