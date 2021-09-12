package com.example.jogtracker.data.network.retrofit

import com.example.jogtracker.data.network.utils.Constants
import com.example.jogtracker.data.network.model.request.LoginRequest
import com.example.jogtracker.data.network.model.response.JogsAndUsersResponse
import com.example.jogtracker.data.network.model.response.LoginResponseObj
import retrofit2.http.*

interface JogTrackerApi {

    @POST(Constants.UUID_LOGIN_URL)
    suspend fun authUserByUUId(@Body login: LoginRequest): LoginResponseObj

    @GET(Constants.GET_JOGS_URL)
    suspend fun getJogsList(): JogsAndUsersResponse
}
