package com.example.appmusicas

class Album {

    fun addMusica(musica: Musica){
        Companion.musicas.add(musica)
    }
    fun getListMusicas():ArrayList<Musica>{
        return Companion.musicas
    }

    companion object {
        var musicas = ArrayList<Musica>(

        )
    }
}