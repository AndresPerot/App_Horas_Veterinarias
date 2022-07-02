package com.example.apphorasveterinarias.Models

import java.io.Serializable

data class User(
    val id: Long?,
    val name: String,
    val lastname: String,
    val email: String,
    val password: String
)  : Serializable
