package com.example.marvel.model.events

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ItemXXXX(
    val name: String,
    val resourceURI: String,
    val type: String
): Parcelable