package id.adr.mobile.moviesbyparkee.presentation.home;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import id.adr.mobile.moviesbyparkee.domain.usecase.GetNowPlayingMoviesUseCase;
import id.adr.mobile.moviesbyparkee.domain.usecase.GetPopularMoviesUseCase;
import id.adr.mobile.moviesbyparkee.domain.usecase.GetTopRatedMoviesUseCase;
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
public final class HomeViewModel_Factory implements Factory<HomeViewModel> {
  private final Provider<GetNowPlayingMoviesUseCase> getNowPlayingMoviesUseCaseProvider;

  private final Provider<GetPopularMoviesUseCase> getPopularMoviesUseCaseProvider;

  private final Provider<GetTopRatedMoviesUseCase> getTopRatedMoviesUseCaseProvider;

  private HomeViewModel_Factory(
      Provider<GetNowPlayingMoviesUseCase> getNowPlayingMoviesUseCaseProvider,
      Provider<GetPopularMoviesUseCase> getPopularMoviesUseCaseProvider,
      Provider<GetTopRatedMoviesUseCase> getTopRatedMoviesUseCaseProvider) {
    this.getNowPlayingMoviesUseCaseProvider = getNowPlayingMoviesUseCaseProvider;
    this.getPopularMoviesUseCaseProvider = getPopularMoviesUseCaseProvider;
    this.getTopRatedMoviesUseCaseProvider = getTopRatedMoviesUseCaseProvider;
  }

  @Override
  public HomeViewModel get() {
    return newInstance(getNowPlayingMoviesUseCaseProvider.get(), getPopularMoviesUseCaseProvider.get(), getTopRatedMoviesUseCaseProvider.get());
  }

  public static HomeViewModel_Factory create(
      Provider<GetNowPlayingMoviesUseCase> getNowPlayingMoviesUseCaseProvider,
      Provider<GetPopularMoviesUseCase> getPopularMoviesUseCaseProvider,
      Provider<GetTopRatedMoviesUseCase> getTopRatedMoviesUseCaseProvider) {
    return new HomeViewModel_Factory(getNowPlayingMoviesUseCaseProvider, getPopularMoviesUseCaseProvider, getTopRatedMoviesUseCaseProvider);
  }

  public static HomeViewModel newInstance(GetNowPlayingMoviesUseCase getNowPlayingMoviesUseCase,
      GetPopularMoviesUseCase getPopularMoviesUseCase,
      GetTopRatedMoviesUseCase getTopRatedMoviesUseCase) {
    return new HomeViewModel(getNowPlayingMoviesUseCase, getPopularMoviesUseCase, getTopRatedMoviesUseCase);
  }
}
