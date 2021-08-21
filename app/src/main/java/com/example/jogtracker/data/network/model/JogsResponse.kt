package com.example.jogtracker.data.network.model

import com.google.gson.annotations.SerializedName

data class JogsResponse(

    @SerializedName("jogs")
    var posts: List<Jog>
)