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
        val btnToDeleteDate= findViewById<Button>(R.id.activity_main_button_delete)

        btnToDeleteDate.setOnClickListener{
            val intent2= Intent(this,DeleteDateActivity::class.java)
            startActivity(intent2)

        }
        val btnToUpdate= findViewById<Button>(R.id.activity_main_button_update)

        btnToUpdate.setOnClickListener{
            val intent3= Intent(this,UpdateActivity::class.java)
            startActivity(intent3)

        }
        val btnToOff= findViewById<Button>(R.id.activity_main_button_off)

        btnToOff.setOnClickListener{
            val intent4= Intent(this,LoginActivity::class.java)
            startActivity(intent4)

        }



    }
}