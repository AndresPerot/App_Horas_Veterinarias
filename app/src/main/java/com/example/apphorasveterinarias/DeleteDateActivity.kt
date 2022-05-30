package com.example.apphorasveterinarias

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class DeleteDateActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delete_date)

        val btnToMain= findViewById<Button>(R.id.activity_delete_button_return)

        btnToMain.setOnClickListener{
            val intent= Intent(this,MainActivity::class.java)
            startActivity(intent)

        }
    }
}