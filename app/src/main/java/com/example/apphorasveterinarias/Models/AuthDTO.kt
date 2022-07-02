package com.example.apphorasveterinarias.Models



data class LoginPayloadDTO (
    val identifier: String,
    val password: String
        )

data class UserDTO (
    val id: Long
        )

data class LoginResponseDTO (
    val jwt: String,
    val user: UserDTO
        )

data class RegisterPayloadDTO (
    val username: String,
    val email: String,
    val password: String,
    val name: String,
    val lastname: String
        )