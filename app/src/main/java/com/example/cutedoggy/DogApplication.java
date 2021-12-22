package com.example.cutedoggy

import android.app.Application
import com.example.cutedoggy.database.AppDatabase


public class DogApplication : Application() {
        val database: AppDatabase by lazy { AppDatabase.getDatabase(this) } {
}
