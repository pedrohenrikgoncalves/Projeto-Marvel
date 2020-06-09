package com.example.marvel.model.comics

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Events(
    val available: Int,
    val collectionURI: String,
    val items: List<String>,
    val returned: Int
): Parcelable