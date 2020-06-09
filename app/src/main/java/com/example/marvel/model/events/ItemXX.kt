package com.example.marvel.model.events

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ItemXX(
    val name: String,
    val resourceURI: String,
    val role: String
): Parcelable