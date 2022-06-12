package com.example.apphorasveterinarias.controllers

import android.content.Context
import com.example.apphorasveterinarias.Models.DatePet

class DatePetController constructor(ctx: Context) {
    private val ctx = ctx

    fun getAll (): List < DatePet> {
        val datepets = ArrayList<DatePet>()
        for (i in 1..10) {
            datepets.add(DatePet(
                id = i.toLong(),
                namePet = "Bigote $i",
                race = "Gato $i",
                hour = "25-10-2022 $i",
                phone = "+5692738521 $i"
            ))

        }
        return datepets

    }


}