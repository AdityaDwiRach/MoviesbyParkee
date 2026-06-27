package id.adr.mobile.moviesbyparkee.data.repository;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import id.adr.mobile.moviesbyparkee.data.remote.api.HomeService;
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
public final class HomeRepositoryImpl_Factory implements Factory<HomeRepositoryImpl> {
  private final Provider<HomeService> serviceProvider;

  private HomeRepositoryImpl_Factory(Provider<HomeService> serviceProvider) {
    this.serviceProvider = serviceProvider;
  }

  @Override
  public HomeRepositoryImpl get() {
    return newInstance(serviceProvider.get());
  }

  public static HomeRepositoryImpl_Factory create(Provider<HomeService> serviceProvider) {
    return new HomeRepositoryImpl_Factory(serviceProvider);
  }

  public static HomeRepositoryImpl newInstance(HomeService service) {
    return new HomeRepositoryImpl(service);
  }
}
