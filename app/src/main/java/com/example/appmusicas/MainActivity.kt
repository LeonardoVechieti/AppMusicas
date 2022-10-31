package com.example.appmusicas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.appmusicas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var binding: ActivityMainBinding
    var album =  Album()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.floatingActionButton.setOnClickListener(this)
        setContentView(binding.root)
        //remove action bar
        supportActionBar!!.hide()



    }

    override fun onClick(v: View) {
        if (v.id == binding.floatingActionButton.id){
            val intent = Intent(this,AddNewMusic::class.java)
            startActivity(intent)
        }

    }

    override fun onResume() {
        super.onResume()
        val recycler = binding.recyclerMusics

        val db = Room.databaseBuilder(
            this,
            MusicaDatabase::class.java,
            "Musica.db"
        ).allowMainThreadQueries().build()

        recycler.adapter = MusicasAdapter(album.getListMusicas(),this)
        recycler.layoutManager = LinearLayoutManager(this)
    }
}