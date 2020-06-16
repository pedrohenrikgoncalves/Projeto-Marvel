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
import com.example.marvel.adapter.AdapterComics
import com.example.marvel.model.comics.ResultsComics
import com.example.marvel.viewmodel.ViewModelMarvel

class ComicsActivity : AppCompatActivity() {

    private var results = mutableSetOf<ResultsComics.Data.Comics>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comics)
        val recycler = findViewById<RecyclerView>(R.id.recycler_comics)
        val progressbar = findViewById<ProgressBar>(R.id.progressBar)
        val viewModelComics = ViewModelProviders.of(this).get(ViewModelMarvel::class.java)

        val adapterComics = AdapterComics(results)
        recycler.adapter = adapterComics
        val layoutManager = LinearLayoutManager(this)
        recycler.layoutManager = layoutManager

        viewModelComics.getAllComics()
        viewModelComics.listComics.observe(this, androidx.lifecycle.Observer {
            it?.let { itChar -> results.addAll(itChar) }
            adapterComics.notifyDataSetChanged()
        })
        viewModelComics.loading.observe(this, Observer { loading ->
            if (loading) {
                progressbar.visibility = View.VISIBLE
            } else {
                progressbar.visibility = View.GONE
                adapterComics.notifyDataSetChanged()
            }
        })
    }
}