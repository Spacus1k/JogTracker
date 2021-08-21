package com.example.jogtracker.data.network

import com.example.jogtracker.data.network.model.JogsResponse
import com.example.jogtracker.data.network.model.LoginRequest
import com.example.jogtracker.data.network.model.LoginResponse
import retrofit2.Call
import retrofit2.http.*

interface JogTrackerApi {

    @GET("v1/data/sync")
    suspend fun syncJogsAndUsers(): LoginResponse

    @POST("v1/auth/uuidLogin")
    fun authUserByUUId(@Body login: LoginRequest): Call <LoginResponse>

    @GET("v1/data/sync")
    fun fetchPosts(@Header("Authorization") token: String): Call<JogsResponse>
}
