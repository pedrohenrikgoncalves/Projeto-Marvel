package com.example.marvel.model.creators

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Creators(
    val comics: Comics,
    val events: Events,
    val firstName: String,
    val fullName: String,
    val id: Int,
    val lastName: String,
    val middleName: String,
    val modified: String,
    val resourceURI: String,
    val series: Series,
    val stories: Stories,
    val suffix: String,
    val thumbnail: Thumbnail,
    val urls: List<Url>
): Parcelable