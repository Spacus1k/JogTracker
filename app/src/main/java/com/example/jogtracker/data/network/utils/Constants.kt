package com.example.jogtracker.data.network.utils

object Constants {
    const val BASE_URL = "https://jogtracker.herokuapp.com/api/"
    const val CONNECT_TIMEOUT: Long = 60 // 60 seconds
    const val READ_WRITE_TIMEOUT: Long = 120 // 120 seconds
    const val UUID_LOGIN_URL= "v1/auth/uuidLogin"
    const val GET_JOGS_URL= "v1/data/sync"
    const val ERROR = "Error"
}