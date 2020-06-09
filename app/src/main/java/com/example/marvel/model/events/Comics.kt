package com.example.marvel.model.events

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Comics(
    val available: Int,
    val collectionURI: String,
    val items: List<ItemX>,
    val returned: Int
): Parcelable