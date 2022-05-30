package com.example.apphorasveterinarias

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegisterDateActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_date)

        val btnRegisterDate= findViewById<Button>(R.id.activity_register_date_button_check_in2)

        btnRegisterDate.setOnClickListener{
            Toast.makeText(this, "Su hora ha sido registrada", Toast.LENGTH_SHORT).show()

        }

        val btnToMain= findViewById<Button>(R.id.activity_register_date_button_return)

        btnToMain.setOnClickListener{
            val intent= Intent(this,MainActivity::class.java)
            startActivity(intent)

        }
    }
}