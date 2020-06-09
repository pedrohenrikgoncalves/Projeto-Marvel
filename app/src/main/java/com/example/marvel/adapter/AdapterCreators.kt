package com.example.marvel.adapter

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.marvel.R
import com.example.marvel.model.creators.Creators
import com.example.marvel.view.DetailCreators
import com.squareup.picasso.Picasso

class AdapterCreators(private val creatorsList: MutableSet<Creators>) : RecyclerView.Adapter<ViewHolderCreators>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): ViewHolderCreators {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.creators_iten, viewGroup, false)
        return ViewHolderCreators(view)
    }

    override fun onBindViewHolder(viewHolderCreators: ViewHolderCreators, position: Int) {
        val creators = creatorsList.elementAt(position)
        viewHolderCreators.creators.text = creators.firstName
        Picasso.get().load(creators.thumbnail.path + ".jpg").error(R.drawable.logo_aplicativo)
                .into(viewHolderCreators.imageView)
        viewHolderCreators.cardViewCreators.setOnClickListener { view ->
            val intent = Intent(view.context, DetailCreators::class.java)
            val bundle = Bundle()
            bundle.putParcelable("creator", creators)
            intent.putExtras(bundle)
            view.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return creatorsList.size
    }

}