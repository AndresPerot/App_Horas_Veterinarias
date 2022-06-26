package com.example.apphorasveterinarias

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.apphorasveterinarias.Models.DatePet

class DatePetActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_date_pet)

        val datepet = intent.getSerializableExtra("datepet") as DatePet

        val tvnamePet = findViewById<TextView>(R.id.activity_datepet_tv_name)
        val tvowner= findViewById<TextView>(R.id.activity_register_date_til_owner)
        val tvrace = findViewById<TextView>(R.id.activity_datepet_tv_race)
        val tvdate = findViewById<TextView>(R.id.activity_datepet_tv_date)
        val tvcontact = findViewById<TextView>(R.id.activity_register_date_til_contact)

        tvnamePet.text = datepet.namePet
        tvowner.text = datepet.owner
        tvrace.text = datepet.race
        tvdate.text = datepet.hour
        tvcontact.text = datepet.contact

    }

}