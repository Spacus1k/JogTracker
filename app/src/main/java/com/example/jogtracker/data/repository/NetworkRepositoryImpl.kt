package com.example.jogtracker.data.repository

import com.example.jogtracker.data.network.model.request.LoginRequest
import com.example.jogtracker.data.network.model.response.Jog
import com.example.jogtracker.data.network.retrofit.JogTrackerApi
import com.example.jogtracker.data.network.utils.Constants
import com.example.jogtracker.domain.NetworkRepository

class NetworkRepositoryImpl(private val jogTrackerApi: JogTrackerApi) : NetworkRepository {

    override suspend fun loginByUUID(uuid: String): String {
        return try {
            jogTrackerApi.authUserByUUId(LoginRequest(uuid)).loginResponse.token
        } catch (e: Exception) {
            Constants.ERROR
        }
    }

    override suspend fun getJogs(): List<Jog> {
        return try{
            jogTrackerApi.getJogsList().jogsAndUsers.jogs
        }
        catch (e : Exception){
            throw NullPointerException("error getJogsList")
        }
    }
}