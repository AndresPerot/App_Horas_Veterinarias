package com.example.apphorasveterinarias.lib

import androidx.databinding.adapters.Converters
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
<<<<<<< HEAD
import com.example.apphorasveterinarias.Models.DateEntity
=======
>>>>>>> b32e80e1714ced4cfcecd294854088dea6264bd0
import com.example.apphorasveterinarias.Models.UserEntity
import com.example.apphorasveterinarias.dao.DateDAO
import com.example.apphorasveterinarias.dao.UserDAO
import com.example.apphorasveterinarias.utils.Converters

<<<<<<< HEAD
@Database(entities = [UserEntity::class, DateEntity::class], version = 2, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDAO
    abstract fun dateDao(): DateDAO

    companion object {
        const val DATABASE_NAME = "app-horas-veterinarias"
    }
=======
@Database(entities = [UserEntity::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDAO

    companion object {
        const val DATABASE_NAME = "App-Horas-Veterinarias"
    }


>>>>>>> b32e80e1714ced4cfcecd294854088dea6264bd0
}