package com.example.appmusicas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.appmusicas.databinding.ActivityAddNewMusicBinding

class AddNewMusic : AppCompatActivity(), View.OnClickListener {
    lateinit var binding: ActivityAddNewMusicBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNewMusicBinding.inflate(layoutInflater)
        binding.buttonCadastrar.setOnClickListener(this)
        setContentView(binding.root)
        //remove action bar
        supportActionBar!!.hide()

    }

    override fun onClick(v: View) {
        if (v.id == binding.buttonCadastrar.id){
            RealizaCadastro()
        }

    }

    fun RealizaCadastro(){
        val nome = binding.editTitleLayout.text.toString()
        val autor = binding.editAuthorLayout.text.toString()
        val duracao = binding.editDurationLayout.text.toString()
        val url = "empty"
        val musica = Musica(nome, autor, duracao, url)
        val album = Album()
        album.addMusica(musica)
        finish()
    }
}