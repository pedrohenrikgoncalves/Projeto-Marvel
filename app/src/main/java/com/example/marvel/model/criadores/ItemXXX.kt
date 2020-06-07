package com.example.marvel.model.criadores

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ItemXXX(
    val name: String,
    val resourceURI: String,
    val type: String
): Parcelable