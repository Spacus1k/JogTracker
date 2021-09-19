package com.example.jogtracker.domain

import com.example.jogtracker.data.network.utils.Constants
import com.example.jogtracker.data.network.utils.TokenHolder
import kotlinx.coroutines.*

class LoginInteractorImpl(
    private val networkRepository: NetworkRepository
) : LoginInteractor {

    override suspend fun loginByUUID(uuid: String): String {
        val result = networkRepository.loginByUUID(uuid)

        if (result != Constants.ERROR) {
            setToken(result)
        }
        return result
    }

    override fun setToken(token: String) {
        TokenHolder.token = token
    }

    override fun getToken(): String? {

        return TokenHolder.token
    }


}