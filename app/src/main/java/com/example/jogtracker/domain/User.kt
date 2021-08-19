package com.example.jogtracker.domain

import java.util.*

class User(
    val userId: UUID,
    val email: String,
    phone: String,
    role: String,
    firstName: String,
    lastName: String
)