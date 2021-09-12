package com.example.jogtracker.domain

import com.example.jogtracker.data.network.model.response.Jog
import com.example.jogtracker.data.network.model.response.JogsAndUsersResponse
import com.example.jogtracker.data.network.model.response.LoginResponseObj

interface NetworkRepository {

    suspend fun loginByUUID(uuid: String):String

    suspend fun getJogs():List<Jog>
}