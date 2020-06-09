package com.example.marvel.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.marvel.R
import com.example.marvel.adapter.AdapterCreators
import com.example.marvel.model.creators.Creators
import com.example.marvel.viewmodel.ViewModelMarvel


class CreatesActivity : AppCompatActivity() {

    private var results = mutableSetOf<Creators>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_creators)
        val recycler = findViewById<RecyclerView>(R.id.recycler_creators)
        val viewModelCreators = ViewModelProviders.of(this).get(ViewModelMarvel::class.java)
        val adapterCreators = AdapterCreators(results)
        recycler.adapter = adapterCreators
        val layoutManager = LinearLayoutManager(this)
        recycler.layoutManager = layoutManager

        viewModelCreators.getAllCreators()
        viewModelCreators.listCreators.observe(this, androidx.lifecycle.Observer {
            it?.let { itChar -> results.addAll(itChar) }
            adapterCreators.notifyDataSetChanged()
        })

    }
}