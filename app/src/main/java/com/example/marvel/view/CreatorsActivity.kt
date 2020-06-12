package com.example.marvel.view

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.marvel.R
import com.example.marvel.adapter.AdapterCreators
import com.example.marvel.model.creators.Creators
import com.example.marvel.viewmodel.ViewModelMarvel
import kotlinx.android.synthetic.main.activity_login.*


class CreatorsActivity : AppCompatActivity() {

    private var results = mutableSetOf<Creators>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_creators)
        val recycler = findViewById<RecyclerView>(R.id.recycler_creators)
        val progressbar = findViewById<ProgressBar>(R.id.progressBar)
        val viewModelCreators = ViewModelProviders.of(this).get(ViewModelMarvel::class.java)
        val adapterCreators = AdapterCreators(results)
        recycler.adapter = adapterCreators
        val layoutManager = LinearLayoutManager(this)
        recycler.layoutManager = layoutManager

        viewModelCreators.getAllCreators()
        viewModelCreators.listCreators.observe(this, androidx.lifecycle.Observer {
            it?.let {
                it.forEach { creators ->
                    if (!creators.thumbnail.path.contains("image_not_available")){
                        results.add(creators)
                    }
                }
            }
            adapterCreators.notifyDataSetChanged()
        })

        viewModelCreators.loading.observe(this, Observer { loading ->
            if (loading) {
                progressbar.visibility = View.VISIBLE
            } else {
                progressbar.visibility = View.GONE
            }
        })
    }
}