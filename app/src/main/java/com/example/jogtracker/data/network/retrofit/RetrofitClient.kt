package com.example.jogtracker.data.network.retrofit

import com.example.jogtracker.data.network.utils.Constants.CONNECT_TIMEOUT
import com.example.jogtracker.data.network.utils.Constants.READ_WRITE_TIMEOUT
import com.example.jogtracker.data.network.utils.URL
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitClient {

    private var gson: Gson = GsonBuilder()
        .setLenient()
        .create()

    fun getJogTrackerApi(): JogTrackerApi {
        return getClient().create(JogTrackerApi::class.java)
    }

    private fun getClient() =
        Retrofit.Builder()
            .baseUrl(URL.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(getOkhttpClient())
            .build()

    private fun getOkhttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(CustomInterceptor())
            .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(READ_WRITE_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(READ_WRITE_TIMEOUT, TimeUnit.SECONDS)
            .build()
    }
}