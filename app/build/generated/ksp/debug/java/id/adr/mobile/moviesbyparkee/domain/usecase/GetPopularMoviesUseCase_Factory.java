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
public final class GetPopularMoviesUseCase_Factory implements Factory<GetPopularMoviesUseCase> {
  private final Provider<HomeRepository> homeRepositoryProvider;

  private GetPopularMoviesUseCase_Factory(Provider<HomeRepository> homeRepositoryProvider) {
    this.homeRepositoryProvider = homeRepositoryProvider;
  }

  @Override
  public GetPopularMoviesUseCase get() {
    return newInstance(homeRepositoryProvider.get());
  }

  public static GetPopularMoviesUseCase_Factory create(
      Provider<HomeRepository> homeRepositoryProvider) {
    return new GetPopularMoviesUseCase_Factory(homeRepositoryProvider);
  }

  public static GetPopularMoviesUseCase newInstance(HomeRepository homeRepository) {
    return new GetPopularMoviesUseCase(homeRepository);
  }
}
