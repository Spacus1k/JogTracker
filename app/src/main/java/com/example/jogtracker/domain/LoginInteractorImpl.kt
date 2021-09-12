package com.example.jogtracker.domain

import com.example.jogtracker.data.network.utils.Constants
import com.example.jogtracker.data.network.utils.TokenHolder
import kotlinx.coroutines.*

class LoginInteractorImpl(
    private val networkRepository: NetworkRepository
) : LoginInteractor {

    override suspend fun loginByUUID(uuid: String):String = coroutineScope {
        val result = networkRepository.loginByUUID(uuid)?:Constants.ERROR

        if (result != Constants.ERROR) {
            setToken(result)
        }
        return@coroutineScope result
    }

    override fun setToken(token: String) {
        TokenHolder.token = token
    }

    override fun getToken(): String? {

        return TokenHolder.token
    }


}