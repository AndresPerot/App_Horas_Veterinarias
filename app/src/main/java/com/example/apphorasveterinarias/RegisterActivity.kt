package com.example.apphorasveterinarias

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val btnToLogin= findViewById<Button>(R.id.activity_register_button_back_in2)

        btnToLogin.setOnClickListener{
            val intent= Intent(this,LoginActivity::class.java)
            startActivity(intent)

        }
        val btnToMain= findViewById<Button>(R.id.activity_register_button_check_in2)

        btnToMain.setOnClickListener{
            val intent= Intent(this,MainActivity::class.java)
            startActivity(intent)

        }
    }
}