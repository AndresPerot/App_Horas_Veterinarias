package com.example.apphorasveterinarias.Models

import java.util.*

data class DatePet(
    val pet_id: Long?,
    val namePet: String,
    val owner: String,
    val race: String,
    val hour: String,
    val date_pet: Date?,
    val contact: String
    )


