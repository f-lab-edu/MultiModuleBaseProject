package com.example.data.datasource.remote

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * data <-> domain Binds
 *
 * @since 0.0
 */
@InstallIn(SingletonComponent::class)
@Module(includes = [DataModule.ApiModule::class])
internal abstract class DataModule {

    @InstallIn(SingletonComponent::class)
    @Module
    internal object ApiModule{

        /**
         * @param url BaseUrl 값
         * @param cls Service Interface
         *
         * @since 0.0
         */
        private fun createApi(
            url : String,
            client : OkHttpClient,
            cls : Class<*>,
        ):Any{
            return Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
                .create(cls)
        }
    }
}