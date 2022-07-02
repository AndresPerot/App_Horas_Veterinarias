package com.example.apphorasveterinarias

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.apphorasveterinarias.Models.DatePet
import com.example.apphorasveterinarias.controllers.AuthController
import com.example.apphorasveterinarias.controllers.DatePetController

class DatePetActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_date_pet)

        val authController= AuthController(this)
        val datePetController= DatePetController(this, authController.getSessionUserId())

        val datepet = intent.getSerializableExtra("DatePet") as DatePet

        val btntoUpdate= findViewById<Button>(R.id.activity_datepet_button_update)
        val btntoDelete= findViewById<Button>(R.id.activity_datepet_button_delete)
        val tvnamePet = findViewById<TextView>(R.id.activity_datepet_tv_name)
        val tvowner= findViewById<TextView>(R.id.activity_datepet_tv_owner)
        val tvrace = findViewById<TextView>(R.id.activity_datepet_tv_race)
        val tvdate = findViewById<TextView>(R.id.activity_datepet_tv_date)
        val tvhour= findViewById<TextView>(R.id.activity_datepet_tv_hour)
        val tvcontact = findViewById<TextView>(R.id.activity_datepet_tv_contact)

        tvnamePet.text = datepet.namePet
        tvowner.text = datepet.owner
        tvrace.text = datepet.race
        tvdate.text = datepet.date_pet.toString()
        tvhour.text=datepet.hour
        tvcontact.text = datepet.contact

        btntoUpdate.setOnClickListener {
            val intent = Intent(this, EditDatepet::class.java)
            intent.putExtra("date", datepet)
            startActivity(intent)
        }

        btntoDelete.setOnClickListener {
            datePetController.delete(datepet.pet_id!!)
        }
    }

}