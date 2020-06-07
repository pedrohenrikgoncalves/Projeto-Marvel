package com.example.marvel.adapter

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.marvel.R
import com.example.marvel.model.criadores.Criadores
import com.example.marvel.model.eventos.Eventos
import com.example.marvel.view.DetailCriadores
import com.example.marvel.view.DetailEventos
import com.squareup.picasso.Picasso

class AdapterEventos(private val eventosList: MutableSet<Eventos>) : RecyclerView.Adapter<ViewHolderEventos>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): ViewHolderEventos {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.events_iten, viewGroup, false)
        return ViewHolderEventos(view)
    }

    override fun onBindViewHolder(viewHolderEventos: ViewHolderEventos, position: Int) {
        val eventos = eventosList.elementAt(position)
        viewHolderEventos.events.text = eventos.title
        Picasso.get().load(eventos.thumbnail.path + ".jpg").error(R.drawable.logo_aplicativo)
                .into(viewHolderEventos.imageView)
        viewHolderEventos.cardViewEvents.setOnClickListener { view ->
            val intent = Intent(view.context, DetailEventos::class.java)
            val bundle = Bundle()
            bundle.putParcelable("Evento", eventos)
            intent.putExtras(bundle)
            view.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return eventosList.size
    }

}