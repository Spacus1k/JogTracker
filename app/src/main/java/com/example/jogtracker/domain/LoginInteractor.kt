package com.example.jogtracker.domain

interface LoginInteractor {

    suspend fun loginByUUID(uuid: String):String

    fun setToken(token: String)

    fun getToken():String?
}