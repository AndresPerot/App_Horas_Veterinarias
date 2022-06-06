package com.example.apphorasveterinarias.controllers

import android.content.Context
import android.content.Intent
import com.example.apphorasveterinarias.MainActivity

class AuthController constructor(ctx: Context) {
    private val ctx = ctx

    fun login(email: String, password: String){
        val intent = Intent(this.ctx, MainActivity::class.java)
        this.ctx.startActivity(intent)

    }
}