package com.example.notemaking

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Notes(@ColumnInfo(name = "text") val text : String) {
    @PrimaryKey(autoGenerate = true) val id = 0
}