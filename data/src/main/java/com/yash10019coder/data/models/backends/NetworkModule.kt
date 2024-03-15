package com.yash10019coder.data.models.backends

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @BaseUrl
    fun provideBaseUrl(): String {
        return "https://cms.samespace.com"
    }

    @Provides
    @CoverImageUrl
    fun provideCoverImageUrl(@BaseUrl baseUrl: String): String {
        return "$baseUrl/assets"
    }

    @Provides
    fun provideOkhttpClient(interceptor: AssetSetUrlInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
    }

    @Provides
    fun provideRetrofit(@BaseUrl baseUrl: String, okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Provides
    fun provideSongsService(retrofit: Retrofit): SongsService {
        return retrofit.create(SongsService::class.java)
    }
}
