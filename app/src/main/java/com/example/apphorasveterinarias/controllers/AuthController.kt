package com.example.apphorasveterinarias.controllers

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Handler
import android.widget.Toast
import androidx.room.Room
import com.example.apphorasveterinarias.LoginActivity
import com.example.apphorasveterinarias.MainActivity
import com.example.apphorasveterinarias.Models.LoginPayloadDTO
import com.example.apphorasveterinarias.Models.LoginResponseDTO
import com.example.apphorasveterinarias.Models.User
import com.example.apphorasveterinarias.Models.UserEntity
import com.example.apphorasveterinarias.lib.AppDatabase
import com.example.apphorasveterinarias.lib.BCrypt
import com.example.apphorasveterinarias.lib.RetrofitClient
import com.example.apphorasveterinarias.servicies.AuthServicie
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class AuthController constructor(ctx: Context) {
    private val ctx = ctx
    private val retrofit = RetrofitClient.getRetrofitInstance()
    private val authServicie = retrofit.create(AuthServicie::class.java)
    private val INCORRECT_CREDENTIALS= "Credenciales incorrectas"
    private val sharedPref = ctx.getSharedPreferences("app-horas-veterinarias", Context.MODE_PRIVATE)
    private val dao = Room.databaseBuilder(
        ctx,
        AppDatabase::class.java, "database-name"

    )
        .allowMainThreadQueries()
        .fallbackToDestructiveMigration()
        .build()
        .userDao()

    fun login(email: String, password: String) {
        val loginPayload = LoginPayloadDTO(email, password)
        val call = authServicie.login(loginPayload)

        call.enqueue(object : Callback<LoginResponseDTO> {
            override fun onFailure(call: Call<LoginResponseDTO>, t: Throwable) {
                Toast.makeText(ctx, "Error de conexión", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(
                call: Call<LoginResponseDTO>,
                response: Response<LoginResponseDTO>
            ) {
                if (response.code() != 200) {
                    Toast.makeText(ctx, INCORRECT_CREDENTIALS, Toast.LENGTH_SHORT).show()
                } else {
                    val bodyResponse = response.body()
                    Toast.makeText(ctx, "Bienvenido ${bodyResponse?.user?.id}", Toast.LENGTH_SHORT).show()
                    val sharedEdit = sharedPref.edit()
                    sharedEdit.putLong("user_id", bodyResponse?.user?.id!!)
                    sharedEdit.putString("user_jwt", bodyResponse?.jwt!!)
                    sharedEdit.commit()

                    val intent = Intent(ctx, MainActivity::class.java)
                    ctx.startActivity(intent)
                    (ctx as Activity).finish()
                }
            }
        })
    }


    fun register(user: User) {
        val hashedPassword = BCrypt.hashpw(user.password, BCrypt.gensalt())
        val userEntity = UserEntity(
            id = null,
            name = user.name,
            lastname = user.lastname,
            email = user.email,
            password = hashedPassword

        )

        try {
            dao.insertUser(userEntity)

            Toast.makeText(this.ctx, "Cuenta registrada", Toast.LENGTH_SHORT).show()
            val intent = Intent(this.ctx, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            this.ctx.startActivity(intent)
        } catch (e: Exception) {
            Toast.makeText(this.ctx, INCORRECT_CREDENTIALS, Toast.LENGTH_SHORT).show()
        }

        dao.insertUser(userEntity)

        Toast.makeText(this.ctx, "Cuenta Registrada", Toast.LENGTH_SHORT).show()
        val intent = Intent(this.ctx, LoginActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        this.ctx.startActivity(intent)
    }

    fun checkUserSession() {
        val id = sharedPref.getLong("user_id", -1)

        Handler().postDelayed({
            if (id == (-1).toLong()) {
                val intent = Intent(this.ctx, LoginActivity::class.java)
                this.ctx.startActivity(intent)
            } else {
                val intent = Intent(this.ctx, MainActivity::class.java)
                this.ctx.startActivity(intent)
            }
            (this.ctx as Activity).finish()
        }, 2000)
    }

    fun clearSession() {
        val editor = sharedPref.edit()
        editor.remove("user_id")
        editor.commit()
        val intent = Intent(this.ctx, LoginActivity::class.java)
        this.ctx.startActivity(intent)
        (this.ctx as Activity).finish()
    }

    fun getSessionUserId(): Long {
        return sharedPref.getLong("user_id", -1)
    }
}

