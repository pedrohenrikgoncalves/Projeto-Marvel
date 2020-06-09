package com.example.marvel.model.characters

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Stories(
    val available: Int,
    val collectionURI: String,
    val items: List<ItemXXX>,
    val returned: Int
) : Parcelable