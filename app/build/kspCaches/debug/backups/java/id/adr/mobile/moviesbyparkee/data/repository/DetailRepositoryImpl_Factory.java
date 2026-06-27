package id.adr.mobile.moviesbyparkee.data.repository;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import id.adr.mobile.moviesbyparkee.data.remote.api.DetailService;
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
public final class DetailRepositoryImpl_Factory implements Factory<DetailRepositoryImpl> {
  private final Provider<DetailService> serviceProvider;

  private DetailRepositoryImpl_Factory(Provider<DetailService> serviceProvider) {
    this.serviceProvider = serviceProvider;
  }

  @Override
  public DetailRepositoryImpl get() {
    return newInstance(serviceProvider.get());
  }

  public static DetailRepositoryImpl_Factory create(Provider<DetailService> serviceProvider) {
    return new DetailRepositoryImpl_Factory(serviceProvider);
  }

  public static DetailRepositoryImpl newInstance(DetailService service) {
    return new DetailRepositoryImpl(service);
  }
}
