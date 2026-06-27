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
public final class GetFavoriteMovieUseCase_Factory implements Factory<GetFavoriteMovieUseCase> {
  private final Provider<FavoriteRepository> favoriteRepositoryProvider;

  private GetFavoriteMovieUseCase_Factory(Provider<FavoriteRepository> favoriteRepositoryProvider) {
    this.favoriteRepositoryProvider = favoriteRepositoryProvider;
  }

  @Override
  public GetFavoriteMovieUseCase get() {
    return newInstance(favoriteRepositoryProvider.get());
  }

  public static GetFavoriteMovieUseCase_Factory create(
      Provider<FavoriteRepository> favoriteRepositoryProvider) {
    return new GetFavoriteMovieUseCase_Factory(favoriteRepositoryProvider);
  }

  public static GetFavoriteMovieUseCase newInstance(FavoriteRepository favoriteRepository) {
    return new GetFavoriteMovieUseCase(favoriteRepository);
  }
}
