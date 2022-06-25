package com.example.apphorasveterinarias.lib

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.apphorasveterinarias.Models.UserEntity
import com.example.apphorasveterinarias.dao.UserDAO
import com.example.apphorasveterinarias.utils.Converters

@Database(entities = [UserEntity::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDAO

    companion object {
        const val DATABASE_NAME = "App-Horas-Veterinarias"
    }


}