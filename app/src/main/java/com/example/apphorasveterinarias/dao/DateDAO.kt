package com.example.apphorasveterinarias.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.apphorasveterinarias.Models.DateEntity


@Dao
interface DateDAO {

    @Query("SELECT * FROM date_pet WHERE user_id= :userId"  )
    fun findAll(userId:Long): List<DateEntity>

    @Query("SELECT * FROM date_pet WHERE pet_id= :petId"  )
    fun findById(petId:Long): DateEntity?

    @Update
    fun update(date: DateEntity)

    @Insert
    fun insertDatePet(date: DateEntity)

    @Query("SELECT * FROM date_pet WHERE pet_id= :petId"  )
    fun delete (petId:Long): DateEntity

}