package com.example.apphorasveterinarias

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.apphorasveterinarias.controllers.AuthController
import com.example.apphorasveterinarias.utils.TilValidator
import com.google.android.material.textfield.TextInputLayout

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btnToMain= findViewById<Button>(R.id.activity_login_button_log_in)
        val btnToRegister= findViewById<Button>(R.id.activity_login_button_check_in)
        val tilEmail = findViewById<TextInputLayout>(R.id.activity_login_til_email)
        val tilpassword= findViewById<TextInputLayout>(R.id.activity_login_til_password)

        btnToMain.setOnClickListener {
            val email = tilEmail.editText?.text.toString()
            val password = tilpassword.editText?.text.toString()

            val emailValid = TilValidator(tilEmail).required().email().isValid()
            val paswordValid= TilValidator(tilpassword).required().password().isValid()

            if( emailValid && paswordValid ) {
                AuthController(this).login(email, password)

            }else{
                Toast.makeText(this, "Campos invalidos", Toast.LENGTH_SHORT).show()
            }

        }

        btnToRegister.setOnClickListener{
            val intent1= Intent(this,RegisterActivity::class.java)
            startActivity(intent1)

        }

    }
}