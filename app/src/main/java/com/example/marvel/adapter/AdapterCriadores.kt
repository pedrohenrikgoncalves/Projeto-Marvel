package com.example.marvel.adapter

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.marvel.R
import com.example.marvel.model.criadores.Criadores
import com.example.marvel.view.DetailCriadores
import com.squareup.picasso.Picasso

class AdapterCriadores(private val criadoresList: MutableSet<Criadores>) : RecyclerView.Adapter<ViewHolderCriadores>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): ViewHolderCriadores {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.creators_iten, viewGroup, false)
        return ViewHolderCriadores(view)
    }

    override fun onBindViewHolder(viewHolderCriadores: ViewHolderCriadores, position: Int) {
        val criadores = criadoresList.elementAt(position)
        viewHolderCriadores.creators.text = criadores.firstName
        Picasso.get().load(criadores.thumbnail.path + ".jpg").error(R.drawable.logo_aplicativo)
                .into(viewHolderCriadores.imageView)
        viewHolderCriadores.cardViewCreators.setOnClickListener { view ->
            val intent = Intent(view.context, DetailCriadores::class.java)
            val bundle = Bundle()
            bundle.putParcelable("Criador", criadores)
            intent.putExtras(bundle)
            view.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return criadoresList.size
    }

}