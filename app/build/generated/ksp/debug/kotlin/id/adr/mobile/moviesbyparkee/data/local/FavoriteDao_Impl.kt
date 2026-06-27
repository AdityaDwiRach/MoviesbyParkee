package id.adr.mobile.moviesbyparkee.`data`.local

import androidx.room.EntityDeleteOrUpdateAdapter
import androidx.room.EntityInsertAdapter
import androidx.room.RoomDatabase
import androidx.room.coroutines.createFlow
import androidx.room.util.getColumnIndexOrThrow
import androidx.room.util.performSuspending
import androidx.sqlite.SQLiteStatement
import javax.`annotation`.processing.Generated
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlin.collections.mutableListOf
import kotlin.reflect.KClass
import kotlinx.coroutines.flow.Flow

@Generated(value = ["androidx.room.RoomProcessor"])
@Suppress(names = ["UNCHECKED_CAST", "DEPRECATION", "REDUNDANT_PROJECTION", "REMOVAL"])
public class FavoriteDao_Impl(
  __db: RoomDatabase,
) : FavoriteDao {
  private val __db: RoomDatabase

  private val __insertAdapterOfFavoriteEntity: EntityInsertAdapter<FavoriteEntity>

  private val __deleteAdapterOfFavoriteEntity: EntityDeleteOrUpdateAdapter<FavoriteEntity>
  init {
    this.__db = __db
    this.__insertAdapterOfFavoriteEntity = object : EntityInsertAdapter<FavoriteEntity>() {
      protected override fun createQuery(): String = "INSERT OR REPLACE INTO `favorites` (`id`,`backdropPath`,`posterPath`,`title`,`overview`,`releaseDate`) VALUES (?,?,?,?,?,?)"

      protected override fun bind(statement: SQLiteStatement, entity: FavoriteEntity) {
        statement.bindLong(1, entity.id.toLong())
        statement.bindText(2, entity.backdropPath)
        statement.bindText(3, entity.posterPath)
        statement.bindText(4, entity.title)
        statement.bindText(5, entity.overview)
        statement.bindText(6, entity.releaseDate)
      }
    }
    this.__deleteAdapterOfFavoriteEntity = object : EntityDeleteOrUpdateAdapter<FavoriteEntity>() {
      protected override fun createQuery(): String = "DELETE FROM `favorites` WHERE `id` = ?"

      protected override fun bind(statement: SQLiteStatement, entity: FavoriteEntity) {
        statement.bindLong(1, entity.id.toLong())
      }
    }
  }

  public override suspend fun insertFavorite(movie: FavoriteEntity): Unit = performSuspending(__db, false, true) { _connection ->
    __insertAdapterOfFavoriteEntity.insert(_connection, movie)
  }

  public override suspend fun deleteFavorite(movie: FavoriteEntity): Unit = performSuspending(__db, false, true) { _connection ->
    __deleteAdapterOfFavoriteEntity.handle(_connection, movie)
  }

  public override fun getFavorites(): Flow<List<FavoriteEntity>> {
    val _sql: String = "SELECT * FROM favorites"
    return createFlow(__db, false, arrayOf("favorites")) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        val _columnIndexOfId: Int = getColumnIndexOrThrow(_stmt, "id")
        val _columnIndexOfBackdropPath: Int = getColumnIndexOrThrow(_stmt, "backdropPath")
        val _columnIndexOfPosterPath: Int = getColumnIndexOrThrow(_stmt, "posterPath")
        val _columnIndexOfTitle: Int = getColumnIndexOrThrow(_stmt, "title")
        val _columnIndexOfOverview: Int = getColumnIndexOrThrow(_stmt, "overview")
        val _columnIndexOfReleaseDate: Int = getColumnIndexOrThrow(_stmt, "releaseDate")
        val _result: MutableList<FavoriteEntity> = mutableListOf()
        while (_stmt.step()) {
          val _item: FavoriteEntity
          val _tmpId: Int
          _tmpId = _stmt.getLong(_columnIndexOfId).toInt()
          val _tmpBackdropPath: String
          _tmpBackdropPath = _stmt.getText(_columnIndexOfBackdropPath)
          val _tmpPosterPath: String
          _tmpPosterPath = _stmt.getText(_columnIndexOfPosterPath)
          val _tmpTitle: String
          _tmpTitle = _stmt.getText(_columnIndexOfTitle)
          val _tmpOverview: String
          _tmpOverview = _stmt.getText(_columnIndexOfOverview)
          val _tmpReleaseDate: String
          _tmpReleaseDate = _stmt.getText(_columnIndexOfReleaseDate)
          _item = FavoriteEntity(_tmpId,_tmpBackdropPath,_tmpPosterPath,_tmpTitle,_tmpOverview,_tmpReleaseDate)
          _result.add(_item)
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public companion object {
    public fun getRequiredConverters(): List<KClass<*>> = emptyList()
  }
}
