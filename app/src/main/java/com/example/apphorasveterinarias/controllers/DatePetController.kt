package com.example.apphorasveterinarias.controllers

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.room.Room
import com.example.apphorasveterinarias.MainActivity
import com.example.apphorasveterinarias.Models.DateEntity
import com.example.apphorasveterinarias.Models.DatePet
import com.example.apphorasveterinarias.lib.AppDatabase

class DatePetController constructor(ctx: Context, userId:Long=0) {
    private val ctx = ctx
    private val sharedPref = ctx.getSharedPreferences("app-horas-veterinarias", Context.MODE_PRIVATE)
    private val userId = sharedPref.getLong("user_id", -1)
    private val dao = Room.databaseBuilder(
        ctx,
        AppDatabase::class.java, "database-name"

    )
        .allowMainThreadQueries()
        .fallbackToDestructiveMigration()
        .build()
        .dateDAO()

    fun getAll (): List<DatePet> {
        val DatePetEntities = dao.findAll(userId)

        val datepets = ArrayList<DatePet>()

        DatePetEntities.forEach { date_pet -> datepets.add(DatePet(
            pet_id = date_pet.pet_id,
            namePet = date_pet.name_pet,
            owner = date_pet.owner,
            date_pet = date_pet.date_pet,
            hour = date_pet.hour,
            race = date_pet.race,
            contact = date_pet.contact,
            user_id = sharedPref.getLong("user_id",-1)
        )) }

        return datepets
    }

    fun register (datePet: DatePet){

        val Entity= DateEntity(
            pet_id = null,
            name_pet = datePet.namePet,
            owner = datePet.owner,
            race = datePet.race,
            hour = datePet.hour,
            contact = datePet.contact,
            date_pet = datePet.date_pet,
            user_id = sharedPref.getLong("user_id",-1)
        )

        dao.insertDatePet(Entity)

        Toast.makeText(this.ctx,"Cuenta Registrada", Toast.LENGTH_SHORT).show()
        val intent = Intent(this.ctx, MainActivity::class.java)
        this.ctx.startActivity(intent)
        (this.ctx as Activity).finish()
    }

    fun update (datePet: DatePet){

        val Entity= DateEntity(
            pet_id = datePet.pet_id,
            name_pet = datePet.namePet,
            owner = datePet.owner,
            race = datePet.race,
            hour = datePet.hour,
            contact = datePet.contact,
            date_pet = datePet.date_pet,
            user_id = sharedPref.getLong("user_id",-1)
        )

        dao.update(Entity)

        Toast.makeText(this.ctx,"Actualizacion Exitosa", Toast.LENGTH_SHORT).show()
        val intent = Intent(this.ctx, MainActivity::class.java)
        this.ctx.startActivity(intent)
        (this.ctx as Activity).finish()
    }

    fun delete (pet_id: Long){
         dao.delete(pet_id)

        val intent = Intent(ctx, MainActivity::class.java)
        ctx.startActivity(intent)
        (this.ctx as Activity).finish()
    }

}


