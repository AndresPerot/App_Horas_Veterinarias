package com.example.apphorasveterinarias.Models

import java.io.Serializable

data class DatePet(
    val id: Long?,
    val namePet: String,
    val race: String,
    val hour: String,
    val phone: String
    ): Serializable


