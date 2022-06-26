package com.example.apphorasveterinarias.dao

import androidx.room.Insert
import androidx.room.Query
import com.example.apphorasveterinarias.Models.DateEntity

interface DateDAO {

    @Query("SELECT * FROM date WHERE id = :id LIMIT 1"  )
    fun findById(id: String): DateEntity


    @Insert
    fun insert(date: DateEntity)
}