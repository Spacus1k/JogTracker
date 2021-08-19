package com.example.jogtracker.domain

import java.util.*

data class Jog(
    val id: Long,
    val userId: String,
    val distance: Int,
    val time: Long,
    val date: Date
)