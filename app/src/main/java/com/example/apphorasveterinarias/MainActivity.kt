package com.example.apphorasveterinarias

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnToShowDate= findViewById<Button>(R.id.activity_main_button_search)

        btnToShowDate.setOnClickListener{
            val intent= Intent(this,ShowActivity::class.java)
            startActivity(intent)

        }
        val btnToRegisterDate= findViewById<Button>(R.id.activity_main_button_new1)

        btnToRegisterDate.setOnClickListener{
            val intent1= Intent(this,RegisterDateActivity::class.java)
            startActivity(intent1)

        }
        val btnToOff= findViewById<Button>(R.id.activity_main_button_off)

        btnToOff.setOnClickListener{
            val intent4= Intent(this,LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent4)
            finish()
        }

    }
}