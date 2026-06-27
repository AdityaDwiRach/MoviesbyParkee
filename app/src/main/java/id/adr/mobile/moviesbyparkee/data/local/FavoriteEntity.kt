package id.adr.mobile.moviesbyparkee.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorites")
data class FavoriteEntity(
    @PrimaryKey
    val id: Int,
    val backdropPath: String,
    val posterPath: String,
    val title: String,
    val overview: String,
    val releaseDate: String
)