package com.example.jogtracker.data.network.model

import com.google.gson.annotations.SerializedName

data class LoginResponse(

    @SerializedName("response")
    val loginResponse: Response
)

