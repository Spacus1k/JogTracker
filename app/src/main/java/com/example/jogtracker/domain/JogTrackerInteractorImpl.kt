package com.example.jogtracker.domain

import com.example.jogtracker.data.network.model.response.Jog
import com.example.jogtracker.data.network.model.response.LoginResponseObj
import com.example.jogtracker.data.network.utils.TokenHolder

class JogTrackerInteractorImpl(
    private val networkRepository: NetworkRepository
) : JogTrackerInteractor {

    override suspend fun getJogs(): List<Jog> {
        return networkRepository.getJogs()
    }

    override suspend fun addJog() {
        TODO("Not yet implemented")
    }

    override suspend fun changedJog() {
        TODO("Not yet implemented")
    }
}