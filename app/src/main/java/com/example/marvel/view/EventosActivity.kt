package com.example.marvel.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.marvel.R
import com.example.marvel.adapter.AdapterEventos
import com.example.marvel.model.eventos.Eventos
import com.example.marvel.viewmodel.ViewModelMarvel

class EventosActivity : AppCompatActivity() {

private var results = mutableSetOf<Eventos>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eventos)
    val recycler = findViewById<RecyclerView>(R.id.recycler_eventos)
    val viewModelEvents =  ViewModelProviders.of(this).get(ViewModelMarvel::class.java)
    val adapterEvents = AdapterEventos(results)
    recycler.adapter = adapterEvents
    val layoutManager = LinearLayoutManager(this)
    recycler.layoutManager = layoutManager

    viewModelEvents.getAllEvents()
    viewModelEvents.listEvents.observe(this, androidx.lifecycle.Observer {
        it?.let { itChar -> results.addAll(itChar) }
        adapterEvents.notifyDataSetChanged()
    })
  }
}