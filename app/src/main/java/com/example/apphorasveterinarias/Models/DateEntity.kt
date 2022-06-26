package com.example.apphorasveterinarias.Models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey


@Entity (tableName = "date", indices = [Index(value = ["id"], unique = true)] )

data class DateEntity (
    @PrimaryKey(autoGenerate = true) val id: Long?,
    @ColumnInfo(name = "name_pet") val name_pet: String,
    @ColumnInfo(name = "owner") val owner: String,
    @ColumnInfo(name = "race") val race: String,
    @ColumnInfo(name = "hour") val hour: String,
    @ColumnInfo(name = "phone") val phone: String,

    )