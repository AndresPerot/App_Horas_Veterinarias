package com.example.apphorasveterinarias.controllers

import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.room.Room
import com.example.apphorasveterinarias.LoginActivity
import com.example.apphorasveterinarias.Models.DateEntity
import com.example.apphorasveterinarias.Models.DatePet
import com.example.apphorasveterinarias.lib.AppDatabase

class DatePetController constructor(ctx: Context, userId:Long=0) {
    private val ctx = ctx
    private val userId = userId
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

        val date_pets = ArrayList<DatePet>()

        DatePetEntities.forEach { date_pet -> date_pets.add(DatePet(
            pet_id = date_pet.pet_id,
            namePet = date_pet.name_pet,
            owner = date_pet.owner,
            date_pet = date_pet.date_pet,
            hour = date_pet.hour,
            race = date_pet.race,
            contact = date_pet.contact,
            user_id= date_pet.user_id
        )) }

        return date_pets
    }


    fun register (datePet: DatePet){

        val dateEntity= DateEntity(
            pet_id = null,
            name_pet = datePet.namePet,
            owner = datePet.owner,
            race = datePet.race,
            hour = datePet.hour,
            contact = datePet.contact,
            date_pet = datePet.date_pet,
            user_id = datePet.user_id
        )

        val db = Room.databaseBuilder(
            ctx.applicationContext,
            AppDatabase::class.java, "database-name"
        )
            .allowMainThreadQueries()
            .build()

        val dao = db.dateDAO()

        dao.insertDatePet(dateEntity)

        Toast.makeText(this.ctx,"Cuenta Registrada", Toast.LENGTH_SHORT).show()
        val intent = Intent(this.ctx, LoginActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        this.ctx.startActivity(intent)
    }
    fun delete (pet_id: Long){
         dao.delete(petId = pet_id)
    }

    fun update (pet_id: Long){
        dao.update()

    }

}


