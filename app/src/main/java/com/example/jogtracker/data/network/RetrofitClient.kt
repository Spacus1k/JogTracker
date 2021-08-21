package com.example.jogtracker.data.network

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitClient {

    private var gson: Gson = GsonBuilder()
        .setLenient()
        .create()

    private const val BASE_URL = "https://jogtracker.herokuapp.com/api/"
    private const val CONNECT_TIMEOUT: Long = 60 // 60 seconds
    private const val READ_WRITE_TIMEOUT: Long = 120 // 120 seconds

    private fun getClient(url: String = BASE_URL, context: Context) = Retrofit.Builder()
        .baseUrl(url)
        .client(
            OkHttpClient().newBuilder()
                .addInterceptor(AuthInterceptor(context))
                .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(READ_WRITE_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(READ_WRITE_TIMEOUT, TimeUnit.SECONDS)
                .build()
        )
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    fun getJogTrackerApi(context: Context): JogTrackerApi =
        getClient(context = context).create(JogTrackerApi::class.java)

}