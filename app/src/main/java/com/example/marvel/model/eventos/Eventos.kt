package com.example.marvel.model.eventos

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Eventos(
    val characters: Characters,
    val comics: Comics,
    val creators: Creators,
    val description: String,
    val end: String,
    val id: Int,
    val modified: String,
    val next: Next,
    val previous: Previous,
    val resourceURI: String,
    val series: Series,
    val start: String,
    val stories: Stories,
    val thumbnail: Thumbnail,
    val title: String,
    val urls: List<Url>
): Parcelable