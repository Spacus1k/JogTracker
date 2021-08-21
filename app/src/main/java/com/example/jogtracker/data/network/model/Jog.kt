package com.example.jogtracker.data.network.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class Jog(
    @SerializedName("id")
    val id: Long,

    @SerializedName("user_id")
    val userId: String,

    @SerializedName("distance")
    val distance: Int,

    @SerializedName("time")
    val time: Long,

    @SerializedName("date")
    val date: Date
)