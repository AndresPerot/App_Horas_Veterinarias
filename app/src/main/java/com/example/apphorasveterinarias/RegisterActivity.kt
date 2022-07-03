package com.example.apphorasveterinarias

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.apphorasveterinarias.Models.User
import com.example.apphorasveterinarias.controllers.AuthController
import com.example.apphorasveterinarias.utils.TilValidator
import com.google.android.material.textfield.TextInputLayout

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val btnToLogin = findViewById<Button>(R.id.activity_register_button_check)
        val btnToMain = findViewById<Button>(R.id.activity_register_button_back)
        val tilusername = findViewById<TextInputLayout>(R.id.activity_register_til_name)
        val tilemail = findViewById<TextInputLayout>(R.id.activity_register_til_email)
        val tilpassword = findViewById<TextInputLayout>(R.id.activity_register_til_password)

        btnToMain.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)

        }

        btnToLogin.setOnClickListener {
            val username = tilusername.editText?.text.toString()
            val email= tilemail.editText?.text.toString()
            val password= tilpassword.editText?.text.toString()

            val usernameValid = TilValidator(tilusername).required().nombre().isValid()
            val emailValid = TilValidator(tilemail).required().email().isValid()
            val passwordValid= TilValidator(tilpassword).required().password().isValid()


            if (usernameValid && emailValid && passwordValid ) {
                val user = User(
                    id= null,
                    username = username,
                    email = email,
                    password = password
                )
                AuthController(this).register(user)
            } else {
                Toast.makeText(this, "Campos invalidos", Toast.LENGTH_SHORT).show()
            }

        }
    }
}
