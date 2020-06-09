package com.example.marvel.model.events

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Data(
        val count: Int,
        val limit: Int,
        val offset: Int,
        val results: MutableSet<Events>,
        val total: Int
): Parcelable