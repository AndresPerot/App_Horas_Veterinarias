package com.example.apphorasveterinarias.controllers

import android.content.Context
import android.content.Intent
import android.text.Editable
import androidx.room.Room
import com.example.apphorasveterinarias.LoginActivity
import com.example.apphorasveterinarias.MainActivity
import com.example.apphorasveterinarias.Models.DateEntity
import com.example.apphorasveterinarias.Models.DatePet
import com.example.apphorasveterinarias.lib.AppDatabase

class AuthController constructor(ctx: Context) {
    private val ctx = ctx
    private val dao = Room.databaseBuilder(
        ctx,
        AppDatabase::class.java, "app-horas-veterinarias"

    )
        .allowMainThreadQueries()
        .fallbackToDestructiveMigration()
        .build()
        .userDao()

    fun login(email: Editable?, password: Editable?){
        val intent = Intent(this.ctx, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        this.ctx.startActivity(intent)

    }
    fun register(name: Editable?, lastname: Editable?, email: Editable?, password: Editable?){
        val intent = Intent(this.ctx, LoginActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        this.ctx.startActivity(intent)
    }

    fun registerDate(datePet: DatePet){

        val dateEntity= DateEntity(
            id=null,
            name_pet = datePet.namePet,
            owner = datePet.owner,
            race = datePet.race,
            hour = datePet.hour,
            phone = datePet.phone

        )
        val intent = Intent(this.ctx, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        this.ctx.startActivity(intent)
    }


}