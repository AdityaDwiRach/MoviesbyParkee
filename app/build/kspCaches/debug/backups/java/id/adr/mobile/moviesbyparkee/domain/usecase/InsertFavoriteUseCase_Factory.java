package id.adr.mobile.moviesbyparkee.domain.usecase;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import id.adr.mobile.moviesbyparkee.domain.repository.FavoriteRepository;
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
public final class InsertFavoriteUseCase_Factory implements Factory<InsertFavoriteUseCase> {
  private final Provider<FavoriteRepository> favoriteRepositoryProvider;

  private InsertFavoriteUseCase_Factory(Provider<FavoriteRepository> favoriteRepositoryProvider) {
    this.favoriteRepositoryProvider = favoriteRepositoryProvider;
  }

  @Override
  public InsertFavoriteUseCase get() {
    return newInstance(favoriteRepositoryProvider.get());
  }

  public static InsertFavoriteUseCase_Factory create(
      Provider<FavoriteRepository> favoriteRepositoryProvider) {
    return new InsertFavoriteUseCase_Factory(favoriteRepositoryProvider);
  }

  public static InsertFavoriteUseCase newInstance(FavoriteRepository favoriteRepository) {
    return new InsertFavoriteUseCase(favoriteRepository);
  }
}
