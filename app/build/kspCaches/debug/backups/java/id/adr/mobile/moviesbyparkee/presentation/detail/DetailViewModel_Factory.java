package id.adr.mobile.moviesbyparkee.presentation.detail;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import id.adr.mobile.moviesbyparkee.domain.usecase.DeleteFavoriteUseCase;
import id.adr.mobile.moviesbyparkee.domain.usecase.GetMovieReviewsUseCase;
import id.adr.mobile.moviesbyparkee.domain.usecase.InsertFavoriteUseCase;
import id.adr.mobile.moviesbyparkee.domain.usecase.IsFavoriteUseCase;
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
public final class DetailViewModel_Factory implements Factory<DetailViewModel> {
  private final Provider<GetMovieReviewsUseCase> getMovieReviewsUseCaseProvider;

  private final Provider<DeleteFavoriteUseCase> deleteFavoriteUseCaseProvider;

  private final Provider<InsertFavoriteUseCase> insertFavoriteUseCaseProvider;

  private final Provider<IsFavoriteUseCase> isFavoriteUseCaseProvider;

  private DetailViewModel_Factory(Provider<GetMovieReviewsUseCase> getMovieReviewsUseCaseProvider,
      Provider<DeleteFavoriteUseCase> deleteFavoriteUseCaseProvider,
      Provider<InsertFavoriteUseCase> insertFavoriteUseCaseProvider,
      Provider<IsFavoriteUseCase> isFavoriteUseCaseProvider) {
    this.getMovieReviewsUseCaseProvider = getMovieReviewsUseCaseProvider;
    this.deleteFavoriteUseCaseProvider = deleteFavoriteUseCaseProvider;
    this.insertFavoriteUseCaseProvider = insertFavoriteUseCaseProvider;
    this.isFavoriteUseCaseProvider = isFavoriteUseCaseProvider;
  }

  @Override
  public DetailViewModel get() {
    return newInstance(getMovieReviewsUseCaseProvider.get(), deleteFavoriteUseCaseProvider.get(), insertFavoriteUseCaseProvider.get(), isFavoriteUseCaseProvider.get());
  }

  public static DetailViewModel_Factory create(
      Provider<GetMovieReviewsUseCase> getMovieReviewsUseCaseProvider,
      Provider<DeleteFavoriteUseCase> deleteFavoriteUseCaseProvider,
      Provider<InsertFavoriteUseCase> insertFavoriteUseCaseProvider,
      Provider<IsFavoriteUseCase> isFavoriteUseCaseProvider) {
    return new DetailViewModel_Factory(getMovieReviewsUseCaseProvider, deleteFavoriteUseCaseProvider, insertFavoriteUseCaseProvider, isFavoriteUseCaseProvider);
  }

  public static DetailViewModel newInstance(GetMovieReviewsUseCase getMovieReviewsUseCase,
      DeleteFavoriteUseCase deleteFavoriteUseCase, InsertFavoriteUseCase insertFavoriteUseCase,
      IsFavoriteUseCase isFavoriteUseCase) {
    return new DetailViewModel(getMovieReviewsUseCase, deleteFavoriteUseCase, insertFavoriteUseCase, isFavoriteUseCase);
  }
}
