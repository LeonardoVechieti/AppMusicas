package com.example.appmusicas

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.dialog.MaterialAlertDialogBuilder

//import coil.load

class MusicasAdapter(private var musicas: ArrayList<Musica>, private var context: Context)
    : RecyclerView.Adapter<MusicasAdapter.ViewHolder>() {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val delete_button = itemView.findViewById<ImageView>(R.id.img_delete)
        fun bind(musica: Musica) {
            itemView.findViewById<TextView>(R.id.txt_author).text = musica.autor
            itemView.findViewById<TextView>(R.id.txt_duration).text = musica.duracao
            itemView.findViewById<TextView>(R.id.txt_title).text = musica.nome
            //if(musica.url == null) {
                //itemView.findViewById<ImageView>(R.id.img_music).load(R.drawable.ic_music)
            //}else{
                //itemView.findViewById<ImageView>(R.id.img_music).load(musica.url)
            //}
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicasAdapter.ViewHolder {
        val inflater = LayoutInflater.from(context)
        val view =  inflater.inflate(R.layout.item_music, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: MusicasAdapter.ViewHolder, position: Int) {
        val musica = this.musicas[position]
        holder.bind(musica)
        holder.delete_button.setOnClickListener{
            AlertDialog.Builder(this.context)
                .setTitle("Deletar ${musica.nome} ?")
                .setPositiveButton("Confirmar",{ _, _-> deleteItem(musica) })
                .setNegativeButton(" Cancelar",{ _, _->})
                .show()
        }
    }

    override fun getItemCount(): Int {
        return this.musicas.size
    }

    fun deleteItem(item: Musica){
        this.musicas.remove(item)
        Toast.makeText(context, "Removida com sucesso",
            Toast.LENGTH_SHORT).show()
        this.notifyDataSetChanged()
    }




}
