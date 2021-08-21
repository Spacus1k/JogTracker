package com.example.jogtracker.data.network.model

import com.google.gson.annotations.SerializedName

data class LoginResponse(

    @SerializedName("status_code")
    var statusCode: Int,

    @SerializedName("access_token")
    val accessToken: String
)

