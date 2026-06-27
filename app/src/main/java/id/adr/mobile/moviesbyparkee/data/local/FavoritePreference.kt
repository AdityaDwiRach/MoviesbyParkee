package id.adr.mobile.moviesbyparkee.data.local

import android.content.Context
import android.content.SharedPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FavoritePreference @Inject constructor(
    @ApplicationContext context: Context
) {
    private val sharedPreference: SharedPreferences =
        context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

    fun saveFavoriteId(id: Int) {
        val ids = getFavoriteIds().toMutableSet()
        ids.add(id.toString())
        sharedPreference.edit().putStringSet(KEY_FAVORITE_IDS, ids).apply()
    }

    fun removeFavoriteId(id: Int) {
        val ids = getFavoriteIds().toMutableSet()
        ids.remove(id.toString())
        sharedPreference.edit().putStringSet(KEY_FAVORITE_IDS, ids).apply()
    }

    fun getFavoriteIds(): Set<String> {
        return sharedPreference.getStringSet(KEY_FAVORITE_IDS, emptySet()) ?: emptySet()
    }

    fun isFavorite(id: Int): Boolean {
        return getFavoriteIds().contains(id.toString())
    }

    companion object {
        private const val PREF_NAME = "favorite_prefs"
        private const val KEY_FAVORITE_IDS = "key_favorite_ids"
    }
}
