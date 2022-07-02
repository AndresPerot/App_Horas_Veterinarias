package com.example.apphorasveterinarias

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.apphorasveterinarias.Models.DatePet
import com.example.apphorasveterinarias.controllers.DatePetController
import com.example.apphorasveterinarias.utils.TilValidator
import com.example.apphorasveterinarias.utils.showDatePickerDialog
import com.google.android.material.textfield.TextInputLayout
import java.text.SimpleDateFormat
import java.util.*

class RegisterDateActivity : AppCompatActivity() {
    @SuppressLint("SimpleDateFormat")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_date)

        val sharedPref = this.getSharedPreferences("app-horas-veterinarias", Context.MODE_PRIVATE)
        val btnRegisterDate= findViewById<Button>(R.id.activity_register_date_button_check_in2)
        val spnHours = findViewById<Spinner>(R.id.activity_register_date_spn_hora)
        val spnRaces =findViewById<Spinner>(R.id.activity_register_date_spn_raza)
        val tilowner= findViewById<TextInputLayout>(R.id.activity_register_date_til_owner)
        val tilpetname= findViewById<TextInputLayout>(R.id.activity_register_date_til_pet_name)
        val tilcontact= findViewById<TextInputLayout>(R.id.activity_register_date_til_contact)
        val tildate = findViewById<TextInputLayout>(R.id.activity_register_date_til_date_pet)




        tildate.editText?.setOnClickListener { _ ->
            showDatePickerDialog(this, tildate, Date())
        }


        ArrayAdapter.createFromResource(
            this,
            R.array.Hours_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spnHours.adapter = adapter
        }

        ArrayAdapter.createFromResource(
            this,
            R.array.Races_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spnRaces.adapter = adapter
        }

        btnRegisterDate.setOnClickListener{

            val namepet = tilpetname.editText?.text.toString()
            val owner = tilowner.editText?.text.toString()
            val race= spnRaces.selectedItem.toString()
            val hour= spnHours.selectedItem.toString()
            val contact= tilcontact.editText?.text.toString()
            val date_pet = tildate.editText?.text.toString()

            val namepetValid = TilValidator(tilpetname).required().isValid()
            val ownerValid= TilValidator(tilowner).required().isValid()
            val contacValid= TilValidator(tilcontact).required().contacto().isValid()
            val dateValid= TilValidator(tildate).required().dateAfter(Date()).isValid()

            if( namepetValid && ownerValid && contacValid && dateValid ) {
                val datePet = DatePet(
                    pet_id = null,
                    namePet = namepet,
                    owner = owner,
                    race = race,
                    hour = hour,
                    contact = contact,
                    date_pet = SimpleDateFormat("yyyy-MM-dd").parse(date_pet),
                    user_id = sharedPref.getLong("user_id",-1)
                )

                DatePetController(this).register(datePet)
                Toast.makeText(this, "Su hora ha sido registrada", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "Campos invalidos", Toast.LENGTH_SHORT).show()
            }
            val intent= Intent(this,MainActivity::class.java)
            startActivity(intent)

        }

        val btnToMain= findViewById<Button>(R.id.activity_register_date_button_return)

        btnToMain.setOnClickListener{
            val intent= Intent(this,MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)

        }
    }
}