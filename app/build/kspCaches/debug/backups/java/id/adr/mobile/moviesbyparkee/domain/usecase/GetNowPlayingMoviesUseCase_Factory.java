package id.adr.mobile.moviesbyparkee.domain.usecase;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import id.adr.mobile.moviesbyparkee.domain.repository.HomeRepository;
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
public final class GetNowPlayingMoviesUseCase_Factory implements Factory<GetNowPlayingMoviesUseCase> {
  private final Provider<HomeRepository> homeRepositoryProvider;

  private GetNowPlayingMoviesUseCase_Factory(Provider<HomeRepository> homeRepositoryProvider) {
    this.homeRepositoryProvider = homeRepositoryProvider;
  }

  @Override
  public GetNowPlayingMoviesUseCase get() {
    return newInstance(homeRepositoryProvider.get());
  }

  public static GetNowPlayingMoviesUseCase_Factory create(
      Provider<HomeRepository> homeRepositoryProvider) {
    return new GetNowPlayingMoviesUseCase_Factory(homeRepositoryProvider);
  }

  public static GetNowPlayingMoviesUseCase newInstance(HomeRepository homeRepository) {
    return new GetNowPlayingMoviesUseCase(homeRepository);
  }
}
