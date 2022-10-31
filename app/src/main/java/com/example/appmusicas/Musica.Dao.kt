package com.example.appmusicas

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update


@Dao
interface MusicaDao {

    @Query("SELECT * FROM Musica")
    fun buscaChecklist(): List<Musica>

    @Insert
    fun insereChecklist(task: Musica)

    @Delete
    fun deleteChecklist(task: Musica)

    @Update
    fun updateChecklist(task: Musica)
}