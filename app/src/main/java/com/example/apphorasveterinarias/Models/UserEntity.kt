package com.example.apphorasveterinarias.Models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "usuarios", indices = [Index(value = ["email"], unique = true)] )
 data class UserEntity (
    @PrimaryKey (autoGenerate = true) val id: Long?,
    @ColumnInfo(name = "nombre") val name: String,
    @ColumnInfo(name = "apellido") val lastname: String,
    @ColumnInfo(name = "email") val email: String,
    val password: String
         )






