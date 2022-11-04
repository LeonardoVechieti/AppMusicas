package com.example.appmusicas

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update


@Dao
interface MusicaDao {

    @Query("SELECT * FROM Musica")
    fun buscaMusica(): List<Musica>

    @Insert
    fun insereMusica(task: Musica)

    @Delete
    fun deleteMusica(task: Musica)

    @Update
    fun updateMusica(task: Musica)
}