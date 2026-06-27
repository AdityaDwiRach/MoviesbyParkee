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
public final class DeleteFavoriteUseCase_Factory implements Factory<DeleteFavoriteUseCase> {
  private final Provider<FavoriteRepository> favoriteRepositoryProvider;

  private DeleteFavoriteUseCase_Factory(Provider<FavoriteRepository> favoriteRepositoryProvider) {
    this.favoriteRepositoryProvider = favoriteRepositoryProvider;
  }

  @Override
  public DeleteFavoriteUseCase get() {
    return newInstance(favoriteRepositoryProvider.get());
  }

  public static DeleteFavoriteUseCase_Factory create(
      Provider<FavoriteRepository> favoriteRepositoryProvider) {
    return new DeleteFavoriteUseCase_Factory(favoriteRepositoryProvider);
  }

  public static DeleteFavoriteUseCase newInstance(FavoriteRepository favoriteRepository) {
    return new DeleteFavoriteUseCase(favoriteRepository);
  }
}
