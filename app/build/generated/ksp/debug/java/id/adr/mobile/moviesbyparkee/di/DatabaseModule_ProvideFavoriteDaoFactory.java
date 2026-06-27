package id.adr.mobile.moviesbyparkee.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import id.adr.mobile.moviesbyparkee.data.local.FavoriteDao;
import id.adr.mobile.moviesbyparkee.data.local.FavoriteDatabase;
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
public final class DatabaseModule_ProvideFavoriteDaoFactory implements Factory<FavoriteDao> {
  private final Provider<FavoriteDatabase> databaseProvider;

  private DatabaseModule_ProvideFavoriteDaoFactory(Provider<FavoriteDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public FavoriteDao get() {
    return provideFavoriteDao(databaseProvider.get());
  }

  public static DatabaseModule_ProvideFavoriteDaoFactory create(
      Provider<FavoriteDatabase> databaseProvider) {
    return new DatabaseModule_ProvideFavoriteDaoFactory(databaseProvider);
  }

  public static FavoriteDao provideFavoriteDao(FavoriteDatabase database) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideFavoriteDao(database));
  }
}
