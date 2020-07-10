package com.example.marvel.view

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.marvel.R
import com.example.marvel.model.characters.CharacterRoom
import com.example.marvel.model.characters.ResultsCharacters
import com.example.marvel.viewmodel.ViewModelRoom
import com.squareup.picasso.Picasso

class DetailFavoritesActivity : AppCompatActivity() {

    private lateinit var imageFavorites: ImageView
    private lateinit var imageBackFavorites: ImageView
    private lateinit var titleFavorites: TextView
    private lateinit var descripitonFavorites: TextView
    private lateinit var removeFavorites: Button
    private lateinit var character: CharacterRoom
    private val activity = this
    private val viewModelRoom : ViewModelRoom by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_favorites)
        val window = window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = getColor(R.color.detailColor)
        getWindow().navigationBarColor = ContextCompat.getColor(this, R.color.detailColor)

        imageFavorites = findViewById(R.id.img_favorites)
        imageBackFavorites = findViewById(R.id.img_favorites_two)
        titleFavorites = findViewById(R.id.title_favorites)
        descripitonFavorites = findViewById(R.id.description_favorites)
        removeFavorites = findViewById(R.id.remove_favorites)

        if (intent != null) {
            character = intent.extras?.getParcelable("Hero") ?: CharacterRoom()
            if (character.description.isNullOrEmpty()) {
                descripitonFavorites.setText(R.string.descri_off)
            } else {
                descripitonFavorites.text = character.description
            }
            titleFavorites.text = character.name
            Picasso.get().load(character.image + ".jpg").error(R.drawable.logo_aplicativo).into(imageBackFavorites)
            Picasso.get().load(character.image + ".jpg").error(R.drawable.logo_aplicativo).into(imageFavorites)
        } else {
            Toast.makeText(this, R.string.problem_server, Toast.LENGTH_LONG).show()
        }
        imageFavorites.setOnClickListener {
            val bundle = Bundle()
            bundle.putParcelable("Hero", character)
            startActivity(Intent(this, ImageCharactersActivity::class.java).putExtras(bundle))
        }
        removeFavorites.setOnClickListener {
            viewModelRoom.removeCharacterFav(this,character)
            Toast.makeText(this, R.string.remove_sucess_favorites, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(activity, FavoritesActivity::class.java)
        startActivity(intent)
    }
}