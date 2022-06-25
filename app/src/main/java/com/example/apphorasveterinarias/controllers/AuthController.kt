package com.example.apphorasveterinarias.controllers

import android.content.Context
import android.content.Intent
import android.text.Editable
import android.widget.Toast
import androidx.room.Room
import com.example.apphorasveterinarias.LoginActivity
import com.example.apphorasveterinarias.MainActivity
import com.example.apphorasveterinarias.Models.User
import com.example.apphorasveterinarias.Models.UserEntity
import com.example.apphorasveterinarias.lib.AppDatabase

class AuthController constructor(ctx: Context) {
    private val ctx = ctx

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

    fun registerDate(namepet: Editable?, race: String, hour: String, contact: Editable?, date: String){
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