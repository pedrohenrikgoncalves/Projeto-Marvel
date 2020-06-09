package com.example.marvel.model.events

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Series(
    val available: Int,
    val collectionURI: String,
    val items: List<ItemXXX>,
    val returned: Int
): Parcelable