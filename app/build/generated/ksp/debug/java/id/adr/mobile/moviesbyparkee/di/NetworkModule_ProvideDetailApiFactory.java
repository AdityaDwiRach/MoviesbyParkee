package id.adr.mobile.moviesbyparkee.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import id.adr.mobile.moviesbyparkee.data.remote.api.DetailService;
import javax.annotation.processing.Generated;
import retrofit2.Retrofit;

@ScopeMetadata("javax.inject.Singleton")
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
public final class NetworkModule_ProvideDetailApiFactory implements Factory<DetailService> {
  private final Provider<Retrofit> retrofitProvider;

  private NetworkModule_ProvideDetailApiFactory(Provider<Retrofit> retrofitProvider) {
    this.retrofitProvider = retrofitProvider;
  }

  @Override
  public DetailService get() {
    return provideDetailApi(retrofitProvider.get());
  }

  public static NetworkModule_ProvideDetailApiFactory create(Provider<Retrofit> retrofitProvider) {
    return new NetworkModule_ProvideDetailApiFactory(retrofitProvider);
  }

  public static DetailService provideDetailApi(Retrofit retrofit) {
    return Preconditions.checkNotNullFromProvides(NetworkModule.INSTANCE.provideDetailApi(retrofit));
  }
}
