package id.adr.mobile.moviesbyparkee.presentation.favorite;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import id.adr.mobile.moviesbyparkee.domain.usecase.GetFavoriteMovieUseCase;
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
public final class FavoriteViewModel_Factory implements Factory<FavoriteViewModel> {
  private final Provider<GetFavoriteMovieUseCase> getFavoriteMovieUseCaseProvider;

  private FavoriteViewModel_Factory(
      Provider<GetFavoriteMovieUseCase> getFavoriteMovieUseCaseProvider) {
    this.getFavoriteMovieUseCaseProvider = getFavoriteMovieUseCaseProvider;
  }

  @Override
  public FavoriteViewModel get() {
    return newInstance(getFavoriteMovieUseCaseProvider.get());
  }

  public static FavoriteViewModel_Factory create(
      Provider<GetFavoriteMovieUseCase> getFavoriteMovieUseCaseProvider) {
    return new FavoriteViewModel_Factory(getFavoriteMovieUseCaseProvider);
  }

  public static FavoriteViewModel newInstance(GetFavoriteMovieUseCase getFavoriteMovieUseCase) {
    return new FavoriteViewModel(getFavoriteMovieUseCase);
  }
}
