package com.example.myapp

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface HourDao {
    @Insert
    suspend fun insert(entry: HourEntry)

    @Query("SELECT * FROM HourEntry ORDER BY time DESC")
    fun getAll(): Flow<List<HourEntry>>
}