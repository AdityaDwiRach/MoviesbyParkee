package id.adr.mobile.moviesbyparkee.data.local;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
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
public final class FavoritePreference_Factory implements Factory<FavoritePreference> {
  private final Provider<Context> contextProvider;

  private FavoritePreference_Factory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public FavoritePreference get() {
    return newInstance(contextProvider.get());
  }

  public static FavoritePreference_Factory create(Provider<Context> contextProvider) {
    return new FavoritePreference_Factory(contextProvider);
  }

  public static FavoritePreference newInstance(Context context) {
    return new FavoritePreference(context);
  }
}
