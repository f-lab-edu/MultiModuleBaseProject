package com.example.data.datasource.remote

import com.example.data.api.GithubAPI
//import com.example.data.repository.GithubRepositoryImpl
//import com.example.data.repository.GithubRepository
import com.example.data.api.OpenWeatherAPI
import com.example.data.repository.OpenWeatherRepositoryImpl
import com.example.data.repository.OpenWeatherRepository
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

    // TODO interface를 잘 만드셨는데 왜 파라미터 type 으로 Impl? 캡슐화에 대해 공부 필요.
    // TODO. Present layer -> (Domain layer) -> data layer 이렇게 의존성을 가져야하지 않나? 약간 짬뽕구조
    // https://velog.io/@sery270/Android의-Clean-Architecture에-대해-알아보자-n9ihbaj4
    // https://developer.android.com/topic/architecture/domain-layer?hl=ko
    // Domain layer 는 옵셔널 https://developer.android.com/topic/architecture/recommendations?hl=ko
//    @Binds
//    abstract fun bindGithubRepository(repo: GithubRepositoryImpl): GithubRepository

    @Binds
    abstract fun bindOpenWeatherRepository(repo: OpenWeatherRepositoryImpl): OpenWeatherRepository

    @InstallIn(SingletonComponent::class)
    @Module
    internal object ApiModule {

        @Provides
        @Singleton
        @Named("githubApi")
        // TODO. OkHttpClient 가 그때 그때 변화를 하나? 따로 파라미터를 받는 이유는?
        fun provideGithubApi(okHttpClient: OkHttpClient): GithubAPI {
            return createApi(
                url = "https://api.github.com",
                client = okHttpClient,
            )

//            return createApi(
//                url = githubEndpoint,
//                client = okHttpClient,
//                cls = GithubAPI::class.java
//            ) as GithubAPI
        }

        @Singleton
        @Provides
        @Named("openWeatherApi")
        fun provideOpenWeatherApi(okHttpClient: OkHttpClient): OpenWeatherAPI {
            return createApi(
                url = "https://api.openweathermap.org",
                client = okHttpClient,
            )

//            return createApi(
//                url = openWeatherEndPoint,
//                client = okHttpClient,
//                cls = OpenWeatherAPI::class.java
//            ) as OpenWeatherAPI
        }


        // TODO. Generic 을 사용. inline function 을 사용
        /**
         * @param url BaseUrl 값
         * @param client OkhttpClient
//         * @param cls Service Interface
         * @since 0.0
         */
//        private fun createApi(
//            url: String,
//            client: OkHttpClient,
//            cls: Class<*>,
//        ): Any {
//            return Retrofit.Builder()
//                .baseUrl(url)
//                .addConverterFactory(GsonConverterFactory.create())
//                .client(client)
//                .build()
//                .create(cls)
//        }


        private inline fun <reified T : Any> createApi(
            url: String,
            client: OkHttpClient,
        ): T {
            return Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
                .create(T::class.java)
        }
    }
}