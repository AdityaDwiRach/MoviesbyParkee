package id.adr.mobile.moviesbyparkee.domain.usecase;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import id.adr.mobile.moviesbyparkee.domain.repository.DetailRepository;
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
public final class GetMovieReviewsUseCase_Factory implements Factory<GetMovieReviewsUseCase> {
  private final Provider<DetailRepository> detailRepositoryProvider;

  private GetMovieReviewsUseCase_Factory(Provider<DetailRepository> detailRepositoryProvider) {
    this.detailRepositoryProvider = detailRepositoryProvider;
  }

  @Override
  public GetMovieReviewsUseCase get() {
    return newInstance(detailRepositoryProvider.get());
  }

  public static GetMovieReviewsUseCase_Factory create(
      Provider<DetailRepository> detailRepositoryProvider) {
    return new GetMovieReviewsUseCase_Factory(detailRepositoryProvider);
  }

  public static GetMovieReviewsUseCase newInstance(DetailRepository detailRepository) {
    return new GetMovieReviewsUseCase(detailRepository);
  }
}
