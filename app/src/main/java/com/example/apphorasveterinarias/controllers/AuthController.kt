package com.example.apphorasveterinarias.controllers

import android.content.Context
import android.content.Intent
import android.text.Editable
<<<<<<< HEAD
import androidx.room.Room
import com.example.apphorasveterinarias.LoginActivity
import com.example.apphorasveterinarias.MainActivity
import com.example.apphorasveterinarias.Models.DateEntity
import com.example.apphorasveterinarias.Models.DatePet
=======
import android.widget.Toast
import androidx.room.Room
import com.example.apphorasveterinarias.LoginActivity
import com.example.apphorasveterinarias.MainActivity
import com.example.apphorasveterinarias.Models.User
import com.example.apphorasveterinarias.Models.UserEntity
>>>>>>> b32e80e1714ced4cfcecd294854088dea6264bd0
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

    fun register2(user: User) {
        val userEntity = UserEntity(
            id = null,
            name = user.name,
            lastname = user.lastname,
            email = user.email,
            password = user.password

        )
        val db = Room.databaseBuilder(
            ctx.applicationContext, AppDatabase::class.java, "database-name"
        )
            .allowMainThreadQueries()
            .build()

        val dao = db.userDao()

        dao.insert(userEntity)
    }


}