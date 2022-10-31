package com.example.appmusicas

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Musica (nome: String, autor: String, duracao: String, url: String = "null"){
    @PrimaryKey (autoGenerate = true) var id: Int = 0
    @ColumnInfo var nome: String = nome
    @ColumnInfo var autor: String = autor
    @ColumnInfo var duracao: String = duracao
    @ColumnInfo var url: String = url

}






