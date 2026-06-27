package id.adr.mobile.moviesbyparkee.data.repository;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import id.adr.mobile.moviesbyparkee.data.local.FavoriteDao;
import id.adr.mobile.moviesbyparkee.data.local.FavoritePreference;
import javax.annotation.processing.Generated;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast",
    "deprecation",
    "nullness:initialization.field.uninitialized"
})
public final class FavoriteRepositoryImpl_Factory implements Factory<FavoriteRepositoryImpl> {
  private final Provider<FavoriteDao> favoriteDaoProvider;

  private final Provider<FavoritePreference> favoritePreferenceProvider;

  private FavoriteRepositoryImpl_Factory(Provider<FavoriteDao> favoriteDaoProvider,
      Provider<FavoritePreference> favoritePreferenceProvider) {
    this.favoriteDaoProvider = favoriteDaoProvider;
    this.favoritePreferenceProvider = favoritePreferenceProvider;
  }

  @Override
  public FavoriteRepositoryImpl get() {
    return newInstance(favoriteDaoProvider.get(), favoritePreferenceProvider.get());
  }

  public static FavoriteRepositoryImpl_Factory create(Provider<FavoriteDao> favoriteDaoProvider,
      Provider<FavoritePreference> favoritePreferenceProvider) {
    return new FavoriteRepositoryImpl_Factory(favoriteDaoProvider, favoritePreferenceProvider);
  }

  public static FavoriteRepositoryImpl newInstance(FavoriteDao favoriteDao,
      FavoritePreference favoritePreference) {
    return new FavoriteRepositoryImpl(favoriteDao, favoritePreference);
  }
}
