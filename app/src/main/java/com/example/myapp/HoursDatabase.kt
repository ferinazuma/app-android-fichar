package com.example.myapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [HourEntry::class], version = 1)
@TypeConverters(Converters::class)
abstract class HoursDatabase : RoomDatabase() {
    abstract fun hoursDao(): HourDao

    companion object {
        @Volatile
        private var INSTANCE: HoursDatabase? = null

        fun getDatabase(context: Context): HoursDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    HoursDatabase::class.java,
                    "hours.db"
                ).build().also { INSTANCE = it }
            }
        }
    }
}