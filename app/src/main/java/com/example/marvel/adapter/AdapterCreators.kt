package com.example.marvel.adapter

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.marvel.R
import com.example.marvel.model.creators.ResultsCreators
import com.example.marvel.view.DetailCreators

class AdapterCreators(private val creatorsList: MutableSet<ResultsCreators.Data.Creators>) : RecyclerView.Adapter<ViewHolderCreators>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): ViewHolderCreators {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.creators_iten, viewGroup, false)
        return ViewHolderCreators(view)
    }

    override fun onBindViewHolder(viewHolderCreators: ViewHolderCreators, position: Int) {
        val creators = creatorsList.elementAt(position)
        viewHolderCreators.creators.text = creators.firstName
        viewHolderCreators.cardViewCreators.setOnClickListener { view ->
            val intent = Intent(view.context, DetailCreators::class.java)
            val bundle = Bundle()
            bundle.putParcelable("Creator", creators)
            intent.putExtras(bundle)
            view.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return creatorsList.size
    }

}