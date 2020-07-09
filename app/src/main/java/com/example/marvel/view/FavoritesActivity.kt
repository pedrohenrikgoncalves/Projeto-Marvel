package com.example.marvel.view

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import bolts.Bolts
import com.example.marvel.R
import com.example.marvel.adapter.AdapterCharacters
import com.example.marvel.adapter.AdapterRoom
import com.example.marvel.model.characters.CharacterRoom
import com.example.marvel.model.characters.ResultsCharacters
import com.example.marvel.viewmodel.ViewModelRoom

class FavoritesActivity : AppCompatActivity() {

    private var results = mutableSetOf<CharacterRoom>()
    private val viewModelRoom : ViewModelRoom by viewModels()
    private val activity = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorites)
        val window = window
        window.statusBarColor = getColor(R.color.colorSplash)
        getWindow().navigationBarColor = ContextCompat.getColor(this, R.color.colorSplash)

        val recycler = findViewById<RecyclerView>(R.id.recycler_fav)
        val progressbar = findViewById<ProgressBar>(R.id.progressFav)

        val adapterCharacter = AdapterRoom(results)
        recycler.adapter = adapterCharacter
        val layoutManager = LinearLayoutManager(this)
        recycler.layoutManager = layoutManager

        viewModelRoom.getListRoom(activity)
        viewModelRoom.listFav.observe(this, Observer {
            it?.let {
                mutableList -> results.addAll(mutableList)
                adapterCharacter.notifyDataSetChanged()
            }
        })
        viewModelRoom.loading.observe(this, Observer { loading ->
            if (loading) {
                progressbar.visibility = View.VISIBLE
            } else {
                progressbar.visibility = View.GONE
                adapterCharacter.notifyDataSetChanged()
            }
        })
    }
}