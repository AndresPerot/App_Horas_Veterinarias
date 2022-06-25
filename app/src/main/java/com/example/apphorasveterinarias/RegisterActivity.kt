package com.example.apphorasveterinarias

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.apphorasveterinarias.Models.User
import com.example.apphorasveterinarias.Models.UserEntity
import com.example.apphorasveterinarias.controllers.AuthController
import com.example.apphorasveterinarias.utils.TilValidator
import com.google.android.material.textfield.TextInputLayout

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val btnToLogin = findViewById<Button>(R.id.activity_register_button_check)
        val btnToMain = findViewById<Button>(R.id.activity_register_button_back)
        val tilname = findViewById<TextInputLayout>(R.id.activity_register_til_name)
        val tillastname = findViewById<TextInputLayout>(R.id.activity_register_til_last_name)
        val tilemail = findViewById<TextInputLayout>(R.id.activity_register_til_email)
        val tilpassword = findViewById<TextInputLayout>(R.id.activity_register_til_password)

        btnToMain.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)

        }

        btnToLogin.setOnClickListener {
            val name = tilname.editText?.text
            val lastName= tillastname.editText?.text
            val email= tilemail.editText?.text
            val password= tilpassword.editText?.text

            val nameValid = TilValidator(tilname).required().nombre().isValid()
            val lastNameValid = TilValidator(tillastname).required().apellido().isValid()
            val emailValid = TilValidator(tilemail).required().email().isValid()
            val passwordValid= TilValidator(tilpassword).required().password().isValid()







            if (nameValid && lastNameValid && emailValid && passwordValid ) {
                Toast.makeText(this, "Contraseña creada", Toast.LENGTH_SHORT).show()
                AuthController(this).register(name, lastName, email, password)
            } else {
                Toast.makeText(this, "Campos invalidos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
