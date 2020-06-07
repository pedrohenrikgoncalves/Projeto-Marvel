package com.example.marvel.model.eventos

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Data(
        val count: Int,
        val limit: Int,
        val offset: Int,
        val results: MutableSet<Eventos>,
        val total: Int
): Parcelable