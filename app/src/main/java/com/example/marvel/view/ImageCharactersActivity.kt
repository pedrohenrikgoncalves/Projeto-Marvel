package com.example.marvel.view

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.marvel.R
import com.example.marvel.model.characters.ResultsCharacters
import com.squareup.picasso.Picasso

class ImageCharactersActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.popup_image_characters)
        val imageView = findViewById<ImageView>(R.id.image_at_expansio)
        val imageExit = findViewById<ImageView>(R.id.imageExit)
        window.statusBarColor = getColor(R.color.detailColor)
        window.navigationBarColor = ContextCompat.getColor(this, R.color.detailColor)
        if (intent.extras != null) {
            val character: ResultsCharacters.Data.Characters = intent.extras?.getParcelable("Hero")?: ResultsCharacters.Data.Characters()
            Picasso.get().load(character.thumbnail!!.path + ".jpg").error(R.drawable.logo_aplicativo).into(imageView)
        }
        imageExit.setOnClickListener { onBackPressed() }
    }
}