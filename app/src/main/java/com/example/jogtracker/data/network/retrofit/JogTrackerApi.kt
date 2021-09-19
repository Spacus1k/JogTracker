package com.example.jogtracker.data.network.retrofit

import com.example.jogtracker.data.network.model.request.LoginRequest
import com.example.jogtracker.data.network.model.response.JogsAndUsersResponse
import com.example.jogtracker.data.network.model.response.LoginResponseObj
import com.example.jogtracker.data.network.utils.URL
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface JogTrackerApi {

    @POST(URL.UUID_LOGIN_URL)
    suspend fun authUserByUUId(@Body login: LoginRequest): LoginResponseObj

    @GET(URL.GET_JOGS_URL)
    suspend fun getJogsList(): JogsAndUsersResponse
}
