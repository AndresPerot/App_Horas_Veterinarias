package com.example.apphorasveterinarias

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
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
            val email = tilEmail.editText?.text
            val password = tilpassword.editText?.text

            val emailValid = TilValidator(tilEmail).required().email().isValid()
            val paswordValid= TilValidator(tilpassword).required().password().isValid()

            val intent= Intent(this,MainActivity::class.java)
            if( emailValid && paswordValid ) {
                startActivity(intent)
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