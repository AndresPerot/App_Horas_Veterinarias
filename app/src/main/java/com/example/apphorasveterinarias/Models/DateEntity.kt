package com.example.apphorasveterinarias.Models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import java.util.*


@Entity (tableName = "date_pet", indices = [Index(value = ["name_pet","owner"], unique = true)] )

data class DateEntity (
    @PrimaryKey(autoGenerate = true) val pet_id: Long?,
    @ColumnInfo(name = "name_pet") val name_pet: String,
    @ColumnInfo(name = "owner") val owner: String,
    @ColumnInfo(name = "race") val race: String,
    @ColumnInfo(name = "date_pet") val date_pet: Date?,
    @ColumnInfo(name = "hour") val hour: String,
    @ColumnInfo(name = "contact") val contact: String,

    )