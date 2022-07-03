package com.example.apphorasveterinarias.Models

import java.io.Serializable

data class User(
    val id: Long?,
    val username: String,
    val email: String,
    val password: String
)  : Serializable
