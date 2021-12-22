package com.example.cutedoggy.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

import kotlin.jvm.Volatile;

@Database(entities = [DogImageEntity::class], version = 1)
// Create one database to be accessed by all parts of the app
public abstract class AppDatabase: RoomDatabase() {
    abstract fun dogImageDao(): DogImageDao

        companion object {
@Volatile
private var INSTANCE: AppDatabase? = null

public fun getDatabase(context: Context): AppDatabase {
        return INSTANCE ?: synchronized(this) {
        val instance = Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        "app_database")
        .allowMainThreadQueries()
        .build()
        INSTANCE = instance

        instance
        }
        }
        }
        }