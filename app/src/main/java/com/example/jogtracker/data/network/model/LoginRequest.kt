package com.example.jogtracker.data.network.model

import com.google.gson.annotations.SerializedName

data class LoginRequest(

    @SerializedName("uuid")
    val uuid: String
)