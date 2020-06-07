package com.example.marvel.model.personagens

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Personagens(
    val comics: Comics,
    val description: String,
    val events: Events,
    val id: Int,
    val modified: String,
    val name: String,
    val resourceURI: String,
    val series: Series,
    val stories: Stories,
    val thumbnail: Thumbnail,
    val urls: List<Url>
) : Parcelable