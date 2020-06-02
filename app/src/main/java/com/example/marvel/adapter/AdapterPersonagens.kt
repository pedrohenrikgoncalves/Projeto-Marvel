package com.example.marvel.adapter

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.marvel.R
import com.example.marvel.model.personagens.Personagem
import com.example.marvel.view.DetailPersonagens
import com.squareup.picasso.Picasso

class AdapterPersonagens(private val personagensList: MutableSet<Personagem>) : RecyclerView.Adapter<ViewHolderPersonagem>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): ViewHolderPersonagem {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.characters_iten, viewGroup, false)
        return ViewHolderPersonagem(view)
    }

    override fun onBindViewHolder(viewHolderPersonagens: ViewHolderPersonagem, position: Int) {
        val personage = personagensList.elementAt(position)
        viewHolderPersonagens.heroi.text = personage.name
        Picasso.get().load(personage.thumbnail.path + ".jpg")
                .into(viewHolderPersonagens.imageView)
        viewHolderPersonagens.cardViewCharacters.setOnClickListener { view ->
            val intent = Intent(view.context, DetailPersonagens::class.java)
            val bundle = Bundle()
            bundle.putParcelable("Heroi", personage)
            intent.putExtras(bundle)
            view.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return personagensList.size
    }

}