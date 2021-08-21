package com.example.jogtracker.data.network

import com.example.jogtracker.data.network.model.JogsResponse
import com.example.jogtracker.data.network.model.LoginRequest
import com.example.jogtracker.data.network.model.LoginResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface JogTrackerApi {

    @GET("v1/data/sync")
    suspend fun syncJogsAndUsers(): LoginResponse

    @POST("v1/auth/uuidLogin")
    fun authUserByUUId(@Body request: LoginRequest): Call<LoginResponse>

    @GET("v1/data/sync")
    fun fetchPosts(@Header("Authorization") token: String): Call<JogsResponse>
}
