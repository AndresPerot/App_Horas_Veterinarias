package com.example.apphorasveterinarias

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.apphorasveterinarias.controllers.DatePetController
import com.example.apphorasveterinarias.ui.DatePetAdapter

class ShowActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show)

        val btnToMain= findViewById<Button>(R.id.activity_show_date_button_return)

        btnToMain.setOnClickListener{
            val intent= Intent(this,MainActivity::class.java)
            startActivity(intent)

        }

        val lvDatePet = findViewById<ListView>(R.id.activity_show_lv_datepet)

        val allDatePets = DatePetController(this).getAll()
        val adapter = DatePetAdapter(this, allDatePets)

        lvDatePet.adapter = adapter
        lvDatePet.setOnItemClickListener { adapterView, view, i, l ->
            run {
                val datePet = allDatePets[i]
                val intent = Intent(view.context, DatePetActivity::class.java)
                intent.putExtra("DatePet", "datePet")
                view.context.startActivity(intent)



                Toast.makeText(view.context, datePet.namePet, Toast.LENGTH_SHORT).show()

            }

        }





    }
}