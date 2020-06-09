package com.example.marvel.model.creators

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Events(
    val available: Int,
    val collectionURI: String,
    val items: List<ItemX>,
    val returned: Int
): Parcelable