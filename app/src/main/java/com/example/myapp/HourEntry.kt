package com.example.myapp

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity
data class HourEntry(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val time: LocalDateTime,
    val type: String
)