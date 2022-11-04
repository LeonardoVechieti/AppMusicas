package com.example.appmusicas

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Musica::class], version = 1)
abstract class MusicaDatabase  : RoomDatabase(){
    abstract fun MusicaDao(): MusicaDao
    fun returnBd(context: Context): MusicaDatabase {
        return Room. databaseBuilder(
            context,
            MusicaDatabase::class.java,
            "Musica.db"
        ).allowMainThreadQueries().build()
    }
}