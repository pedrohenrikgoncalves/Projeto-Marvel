package com.example.marvel.view

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.marvel.R
import com.example.marvel.adapter.AdapterEvents
import com.example.marvel.model.events.Events
import com.example.marvel.viewmodel.ViewModelMarvel

class EventsActivity : AppCompatActivity() {

private var results = mutableSetOf<Events>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_events)
    val recycler = findViewById<RecyclerView>(R.id.recycler_events)
    val progressbar = findViewById<ProgressBar>(R.id.progressBar)
    val viewModelEvents =  ViewModelProviders.of(this).get(ViewModelMarvel::class.java)
    val adapterEvents = AdapterEvents(results)
    recycler.adapter = adapterEvents
    val layoutManager = LinearLayoutManager(this)
    recycler.layoutManager = layoutManager

    viewModelEvents.getAllEvents()
    viewModelEvents.listEvents.observe(this, androidx.lifecycle.Observer {
        it?.let {
            it.forEach { events ->
                if (!events.thumbnail.path.contains("image_not_available")) {
                    results.add(events)
                }
            }
        }
        adapterEvents.notifyDataSetChanged()
    })
        viewModelEvents.loading.observe(this, Observer { loading ->
            if (loading) {
                progressbar.visibility = View.VISIBLE
            } else {
                progressbar.visibility = View.GONE
            }
        })
  }
}