package com.example.network.retrofit

import com.example.network.dto.ItemsDto
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class RetrofitAndApi {
    val api: Api by lazy {
        Retrofit
            .Builder()
            .baseUrl("https://run.mocky.io")
            .addConverterFactory(GsonConverterFactory.create())
            .client(
                OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().also {
                    it.level = HttpLoggingInterceptor.Level.BODY
                }).build()
            )
            .build()
            .create(Api::class.java)
    }

    interface Api {
        @GET("/v3/97e721a7-0a66-4cae-b445-83cc0bcf9010")
        suspend fun getData(): ItemsDto
    }
}