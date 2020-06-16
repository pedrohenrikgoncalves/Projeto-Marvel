package com.example.marvel.adapter

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.marvel.R
import com.example.marvel.model.events.ResultsEvents
import com.example.marvel.view.DetailEvents
import com.squareup.picasso.Picasso

class AdapterEvents(private val eventsList: MutableSet<ResultsEvents.Data.Events>) : RecyclerView.Adapter<ViewHolderEvents>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): ViewHolderEvents {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.events_iten, viewGroup, false)
        return ViewHolderEvents(view)
    }

    override fun onBindViewHolder(viewHolderEvents: ViewHolderEvents, position: Int) {
        val eventos = eventsList.elementAt(position)
        viewHolderEvents.events.text = eventos.title
        Picasso.get().load(eventos.thumbnail.path + ".jpg").error(R.drawable.logo_aplicativo)
                .into(viewHolderEvents.imageView)
        viewHolderEvents.cardViewEvents.setOnClickListener { view ->
            val intent = Intent(view.context, DetailEvents::class.java)
            val bundle = Bundle()
            bundle.putParcelable("Event", eventos)
            intent.putExtras(bundle)
            view.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return eventsList.size
    }

}