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
public final class GetTopRatedMoviesUseCase_Factory implements Factory<GetTopRatedMoviesUseCase> {
  private final Provider<HomeRepository> homeRepositoryProvider;

  private GetTopRatedMoviesUseCase_Factory(Provider<HomeRepository> homeRepositoryProvider) {
    this.homeRepositoryProvider = homeRepositoryProvider;
  }

  @Override
  public GetTopRatedMoviesUseCase get() {
    return newInstance(homeRepositoryProvider.get());
  }

  public static GetTopRatedMoviesUseCase_Factory create(
      Provider<HomeRepository> homeRepositoryProvider) {
    return new GetTopRatedMoviesUseCase_Factory(homeRepositoryProvider);
  }

  public static GetTopRatedMoviesUseCase newInstance(HomeRepository homeRepository) {
    return new GetTopRatedMoviesUseCase(homeRepository);
  }
}
