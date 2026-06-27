package id.adr.mobile.moviesbyparkee.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import id.adr.mobile.moviesbyparkee.BuildConfig
import id.adr.mobile.moviesbyparkee.data.remote.api.DetailService
import id.adr.mobile.moviesbyparkee.data.remote.api.HomeService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val clientBuilder = OkHttpClient.Builder()
        clientBuilder.addInterceptor { chain ->
                val request = chain.request()
                    .newBuilder()
                    .addHeader(
                        "Authorization",
                        "Bearer ${BuildConfig.API_KEY}"
                    )
                    .addHeader(
                        "Accept",
                        "application/json"
                    )
                    .build()

                chain.proceed(request)
            }

        if (BuildConfig.DEBUG) {
            clientBuilder.addInterceptor(
                HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            )
        }

        return clientBuilder.build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(
        client: OkHttpClient,
    ): Retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideDetailApi(
        retrofit: Retrofit,
    ): DetailService = retrofit.create(DetailService::class.java)

    @Provides
    @Singleton
    fun provideHomeApi(
        retrofit: Retrofit,
    ): HomeService = retrofit.create(HomeService::class.java)
}