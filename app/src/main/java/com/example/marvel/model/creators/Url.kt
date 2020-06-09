package com.example.marvel.model.creators

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Url(
    val type: String,
    val url: String
): Parcelable