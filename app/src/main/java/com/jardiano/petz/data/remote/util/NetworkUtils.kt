package com.jardiano.petz.data.remote.util

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

//TODO: erro na api
const val TIMEOUT = 60L

fun buildOkHttpClient(): OkHttpClient {
    return OkHttpClient.Builder()
        .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
        .readTimeout(TIMEOUT, TimeUnit.SECONDS)
        .build()
}

fun buildRetrofit(httpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        //TODO: incluir no flavor e usar da forma correta -> BuildConfig.API_URL
        .baseUrl("https://omgvamp-hearthstone-v1.p.rapidapi.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(httpClient)
        .build()
}
