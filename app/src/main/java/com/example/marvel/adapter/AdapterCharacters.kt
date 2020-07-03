package com.example.marvel.adapter

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.marvel.R
import com.example.marvel.model.characters.ResultsCharacters
import com.example.marvel.view.DetailCharacters
import com.squareup.picasso.Picasso

class AdapterCharacters(private val charactersList: MutableSet<ResultsCharacters.Data.Characters>) : RecyclerView.Adapter<ViewHolderCharacters>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): ViewHolderCharacters {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.characters_iten, viewGroup, false)
        return ViewHolderCharacters(view)
    }

    override fun onBindViewHolder(viewHolderCharacters: ViewHolderCharacters, position: Int) {
        val character = charactersList.elementAt(position)
        viewHolderCharacters.heroi.text = character.name
        Picasso.get().load(character.thumbnail?.path + ".jpg").error(R.drawable.logo_aplicativo)
                .into(viewHolderCharacters.imageView)
        viewHolderCharacters.cardViewCharacters.setOnClickListener { view ->
            val intent = Intent(view.context, DetailCharacters::class.java)
            val bundle = Bundle()
            bundle.putParcelable("Hero", character)
            intent.putExtras(bundle)
            view.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return charactersList.size
    }

}