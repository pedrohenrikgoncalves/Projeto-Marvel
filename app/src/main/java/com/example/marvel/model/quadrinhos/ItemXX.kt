package com.example.marvel.model.quadrinhos

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ItemXX(
    val name: String,
    val resourceURI: String,
    val type: String
): Parcelable