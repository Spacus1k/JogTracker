package com.example.jogtracker.data.network.retrofit

import com.example.jogtracker.data.network.utils.Constants
import com.example.jogtracker.data.network.utils.TokenHolder
import okhttp3.Interceptor
import okhttp3.Response

class CustomInterceptor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request().newBuilder()

        // If token has been saved, add it to the request
        if(TokenHolder.token!=Constants.ERROR){
            requestBuilder.addHeader("Authorization", "Bearer ${TokenHolder.token}")
        }

        return chain.proceed(requestBuilder.build())
    }
}
