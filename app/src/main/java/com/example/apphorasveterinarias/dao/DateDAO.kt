package com.example.apphorasveterinarias.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.apphorasveterinarias.Models.DateEntity


@Dao
interface DateDAO {

    @Query("SELECT * FROM date_pet WHERE pet_id= :pet_id"  )
    fun findAll(pet_id:Long): List<DateEntity>



    @Insert
    fun insertDatePet(date: DateEntity)

    @Delete
    fun delete(date: DateEntity)
}