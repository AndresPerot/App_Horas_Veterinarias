package com.example.apphorasveterinarias

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btnToMain= findViewById<Button>(R.id.activity_login_button_log_in)

        btnToMain.setOnClickListener{
            val intent= Intent(this,MainActivity::class.java)
            startActivity(intent)

        }
        val btnToRegister= findViewById<Button>(R.id.activity_login_button_check_in)

        btnToRegister.setOnClickListener{
            val intent1= Intent(this,RegisterActivity::class.java)
            startActivity(intent1)

        }

    }
}