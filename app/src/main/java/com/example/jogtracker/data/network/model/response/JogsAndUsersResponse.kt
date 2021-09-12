package com.example.jogtracker.data.network.model.response

import com.google.gson.annotations.SerializedName

data class JogsAndUsersResponse(
    @SerializedName("response")
    val jogsAndUsers: JogsAndUsers
)

data class JogsAndUsers(
    @SerializedName("jogs")
    val jogs: List<Jog>,

    @SerializedName("users")
    val users: List<User>
)