package com.example.jogtracker.data.network.model.response

import com.google.gson.annotations.SerializedName

data class LoginResponseObj(
    @SerializedName("response")
    val loginResponse: LoginResponse
)

data class LoginResponse(
    @SerializedName("access_token")
    val token: String
)