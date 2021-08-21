package com.example.jogtracker.data.network.model

import com.google.gson.annotations.SerializedName

data class Response(

    @SerializedName("access_token")
    val token: String
)