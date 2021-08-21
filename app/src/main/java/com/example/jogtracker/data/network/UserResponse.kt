package com.example.jogtracker.data.network

import com.google.gson.annotations.SerializedName

data class UserResponse(
    @SerializedName("id")
    val userId: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("last_name")
    val lastName: String,
)