package com.example.apphorasveterinarias

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.apphorasveterinarias.Models.DatePet

class DatePetActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_date_pet)

        val datepet = intent.getSerializableExtra("datepet") as DatePet

        val tvnamePet = findViewById<TextView>(R.id.activity_datepet_tv_name)
        val tvrace = findViewById<TextView>(R.id.activity_datepet_tv_race)
        val tvdate = findViewById<TextView>(R.id.activity_datepet_tv_date)
        val tvphone = findViewById<TextView>(R.id.activity_datepet_tv_phone)

        tvnamePet.text = datepet.namePet
        tvrace.text = datepet.race
        tvdate.text = datepet.hour
        tvphone.text = datepet.phone

    }

}