package com.jardiano.petz.di

import com.jardiano.petz.data.remote.HearthstoneCloudStore
import com.jardiano.petz.data.remote.api.PetzApi
import com.jardiano.petz.data.remote.util.buildOkHttpClient
import com.jardiano.petz.data.remote.util.buildRetrofit
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return buildOkHttpClient()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): PetzApi {
        return buildRetrofit(okHttpClient).create(PetzApi::class.java)
    }

    @Provides
    @Singleton
    fun provideHearthstoneCloudStore(api: PetzApi): HearthstoneCloudStore {
        return HearthstoneCloudStore(api)
    }
}