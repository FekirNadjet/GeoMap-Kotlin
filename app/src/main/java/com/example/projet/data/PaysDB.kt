package com.example.projet.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities =arrayOf(Pays::class),version = 1)
abstract class PaysDB: RoomDatabase() {
    abstract fun paysDao(): PaysDao
    companion object {
        @Volatile
        private var instance: PaysDB? = null
        private val Lock = Any()
        operator fun invoke(context: Context) = instance ?: synchronized(Lock) {
            instance ?:buildDataBase(context).also {
                instance= it
            }

        }

        private fun buildDataBase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            PaysDB::class.java,
            "paysdatabase"
        ).build()
    }
}