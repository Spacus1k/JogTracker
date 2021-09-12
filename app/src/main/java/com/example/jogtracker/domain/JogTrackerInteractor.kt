package com.example.jogtracker.domain

import com.example.jogtracker.data.network.model.response.Jog
import com.example.jogtracker.data.network.model.response.LoginResponseObj

interface JogTrackerInteractor {

    suspend fun getJogs(): List<Jog>

    suspend fun addJog()

    suspend fun changedJog()
}