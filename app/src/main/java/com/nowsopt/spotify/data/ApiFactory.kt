package com.nowsopt.spotify.data

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.nowsopt.spotify.BuildConfig
import com.nowsopt.spotify.data.service.ArtistService
import com.nowsopt.spotify.data.service.TestService
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

object ApiFactory {

    lateinit var retrofit: Retrofit

    @Synchronized
    fun getRetrofit(baseUrl: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(provideOkHttpClient())
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .build()
    }

    private fun getLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(
            if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor.Level.BODY
            } else {
                HttpLoggingInterceptor.Level.NONE
            },
        )
    }

    private fun provideOkHttpClient(): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(getLoggingInterceptor())
        .connectTimeout(60, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(15, TimeUnit.SECONDS)
        .build()

    inline fun <reified T> create(): T = retrofit.create(T::class.java)
}

object ServicePool {
    val testService: TestService by lazy { ApiFactory.create() }
    val artistService: ArtistService by lazy { ApiFactory.create() }
}