package com.example.data.datasource.remote

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.google.gson.GsonBuilder
import com.google.gson.JsonParser
import com.google.gson.JsonSyntaxException
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
internal object NetworkModule {

    @RequiresApi(Build.VERSION_CODES.GINGERBREAD)
    @Provides
    @Singleton
    fun provideOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor,
    ): OkHttpClient =
        OkHttpClient.Builder()
            .connectTimeout(1, TimeUnit.MINUTES)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(20, TimeUnit.SECONDS)
            .addNetworkInterceptor(httpLoggingInterceptor)
            .build()

    /**
     *
     * success : "apiLog"
     * fail : "apiError"
     * error : "apiException"
     *
     * since 0.0
     */
    @Provides
    @Singleton
    fun provideLogger(): HttpLoggingInterceptor.Logger =
        HttpLoggingInterceptor.Logger { message ->
            if (message.startsWith("{") || message.startsWith("[")) {
                try {
                    val prettyPrintJson = GsonBuilder().setPrettyPrinting()
                        .create().toJson(JsonParser.parseString(message))
                    Log.i("apiLog", prettyPrintJson)

                } catch (m: JsonSyntaxException) {
                    Log.e("apiError JsonSyntax", message)
                }
            } else {
                Log.e("apiException", message)
            }
        }

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(logger: HttpLoggingInterceptor.Logger): HttpLoggingInterceptor =
        HttpLoggingInterceptor(logger).apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

}