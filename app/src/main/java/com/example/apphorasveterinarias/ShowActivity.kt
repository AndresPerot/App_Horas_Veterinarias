package com.example.apphorasveterinarias

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ShowActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show)

        val btnToMain= findViewById<Button>(R.id.activity_show_date_button_return)

        btnToMain.setOnClickListener{
            val intent= Intent(this,MainActivity::class.java)
            startActivity(intent)

        }
    }
}