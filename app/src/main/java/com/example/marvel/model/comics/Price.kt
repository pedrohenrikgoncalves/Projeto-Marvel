package com.example.marvel.model.comics

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Price(
    val price: Double,
    val type: String
): Parcelable