package id.adr.mobile.moviesbyparkee.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import id.adr.mobile.moviesbyparkee.data.local.FavoriteDao
import id.adr.mobile.moviesbyparkee.data.local.FavoriteDatabase
import jakarta.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): FavoriteDatabase {
        return Room.databaseBuilder(
            context,
            FavoriteDatabase::class.java,
            "favorite.db"
        ).build()
    }

    @Provides
    fun provideFavoriteDao(
        database: FavoriteDatabase
    ): FavoriteDao {
        return database.favoriteDao()
    }
}