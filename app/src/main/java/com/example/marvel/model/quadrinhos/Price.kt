package com.example.marvel.model.quadrinhos

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Price(
    val price: Int,
    val type: String
): Parcelable