package com.jmanday.remotedatasource.di

import android.app.Application
import com.jmanday.remotedatasource.api.BASE_URL
import com.jmanday.remotedatasource.api.CharacterApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteDatasourceModule {

    @Singleton
    @Provides
    fun provideOkHttpClient(
        app: Application
    ): OkHttpClient = OkHttpClient.Builder()
        .addNetworkInterceptor(HttpLoggingInterceptor { message ->
            println("LOG-NET: $message")
        }.apply {
            level = HttpLoggingInterceptor.Level.BODY
        })
        .build()

    @Singleton
    @Provides
    fun provideRetrofit(
        client: OkHttpClient
    ): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Singleton
    @Provides
    fun provideCharacterApi(
        retrofit: Retrofit
    ): CharacterApi = retrofit.create(CharacterApi::class.java)
}