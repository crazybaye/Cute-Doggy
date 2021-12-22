package com.example.cutedoggy.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

import java.util.List;

import kotlinx.coroutines.flow.Flow

@Dao
interface DogImageDao {

    @Query("SELECT * FROM DogImages")
    fun getAllDogImages(): Flow<List<com.example.cutedoggy.database.DogImageEntity>>

    @Query("SELECT * FROM DogImages ORDER BY id DESC LIMIT 1")
    fun getMostRecentlyAddDog() : com.example.cutedoggy.database.DogImageEntity

    @Query("DELETE from DogImages where id=(select max(id)-1 from DogImages)")
    suspend fun deleteDog()

    @Insert
    suspend fun addDogImage(dogImageEntity:com.example.cutedoggy.database.DogImageEntity)

}
