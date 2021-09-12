package com.example.jogtracker.data.network.model.response

import com.google.gson.annotations.SerializedName

data class Jog(
    @SerializedName("id")
    val id: Int,

    @SerializedName("user_id")
    val userId: String,

    @SerializedName("distance")
    val distance: Long,

    @SerializedName("time")
    val time: Int,

    @SerializedName("date")
    val date: Long
)