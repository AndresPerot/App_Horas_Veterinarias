package com.example.apphorasveterinarias.controllers

import android.content.Context
import android.content.Intent
import android.text.Editable
import android.widget.Toast
import com.example.apphorasveterinarias.LoginActivity
import com.example.apphorasveterinarias.MainActivity

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


}