package com.example.data.datasource.remote

import com.example.data.api.GithubAPI
import com.example.data.repository.GithubRepositoryImpl
import com.example.domain.repository.GithubRepository
import com.example.data.api.EndPoint.githubEndpoint
import com.example.data.api.EndPoint.openWeatherEndPoint
import com.example.data.api.OpenWeatherAPI
import com.example.data.repository.OpenWeatherRepositoryImpl
import com.example.domain.repository.OpenWeatherRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

/**
 * data <-> domain Binds
 *
 * @since 0.0
 */
@InstallIn(SingletonComponent::class)
@Module(includes = [DataModule.ApiModule::class])
internal abstract class DataModule {

    @Binds
    abstract fun bindGithubRepository(repo: GithubRepositoryImpl): GithubRepository

    @Binds
    abstract fun bindOpenWeatherRepository(repo: OpenWeatherRepositoryImpl): OpenWeatherRepository

    @InstallIn(SingletonComponent::class)
    @Module
    internal object ApiModule {

        @Provides
        @Singleton
        @Named("githubApi")
        fun provideGithubApi(okHttpClient: OkHttpClient): GithubAPI {
            return createApi(
                url = githubEndpoint,
                client = okHttpClient,
                cls = GithubAPI::class.java
            ) as GithubAPI
        }

        @Singleton
        @Provides
        @Named("openWeatherApi")
        fun provideOpenWeatherApi(okHttpClient: OkHttpClient): OpenWeatherAPI {
            return createApi(
                url = openWeatherEndPoint,
                client = okHttpClient,
                cls = OpenWeatherAPI::class.java
            ) as OpenWeatherAPI
        }

        /**
         * @param url BaseUrl 값
         * @param client OkhttpClient
         * @param cls Service Interface
         * @since 0.0
         */
        private fun createApi(
            url: String,
            client: OkHttpClient,
            cls: Class<*>,
        ): Any {
            return Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
                .create(cls)
        }
    }
}