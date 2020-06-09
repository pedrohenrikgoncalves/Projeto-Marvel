package com.example.marvel.model.comics

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Image(
    val extension: String,
    val path: String
): Parcelable