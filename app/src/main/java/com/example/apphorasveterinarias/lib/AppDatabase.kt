package com.example.apphorasveterinarias.lib

import androidx.databinding.adapters.Converters
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.apphorasveterinarias.Models.DateEntity
import com.example.apphorasveterinarias.Models.UserEntity
import com.example.apphorasveterinarias.dao.DateDAO
import com.example.apphorasveterinarias.dao.UserDAO

@Database(entities = [UserEntity::class, DateEntity::class], version = 2, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDAO
    abstract fun dateDao(): DateDAO

    companion object {
        const val DATABASE_NAME = "app-horas-veterinarias"
    }
}