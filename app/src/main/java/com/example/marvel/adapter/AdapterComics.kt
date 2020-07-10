package com.example.marvel.adapter

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.marvel.R
import com.example.marvel.model.comics.ResultsComics
import com.example.marvel.view.DetailComics
import com.squareup.picasso.Picasso

class AdapterComics(private val comicsList: MutableSet<ResultsComics.Data.Comics>) : RecyclerView.Adapter<ViewHolderComics>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): ViewHolderComics {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.comics_iten, viewGroup, false)
        return ViewHolderComics(view)
    }

    override fun onBindViewHolder(viewHolderComics: ViewHolderComics, position: Int) {
        val comic = comicsList.elementAt(position)
        viewHolderComics.titulo.text = comic.title
        viewHolderComics.identification.text = comic.id.toString()
        Picasso.get().load(comic.thumbnail?.path + ".jpg").error(R.drawable.logo_aplicativo)
                .into(viewHolderComics.imageView)
        viewHolderComics.cardViewComics.setOnClickListener { v ->
            val intent = Intent(v.context, DetailComics::class.java)
            val bundle = Bundle()
            bundle.putParcelable("Title", comic)
            intent.putExtras(bundle)
            v.context.startActivity(intent)
        }
    }
    override fun getItemCount(): Int {
        return comicsList.size
    }

}