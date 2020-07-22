package com.example.projet.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PaysDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addPays(pays: Pays)

    @Query("SELECT * FROM pays")
    suspend fun getAll(): List<Pays>

    @Query("SELECT * FROM pays WHERE id = :id")
    suspend fun getById(id: Int): Pays

    @Query("SELECT count(*) FROM pays")
    suspend fun getSize(): Int



}