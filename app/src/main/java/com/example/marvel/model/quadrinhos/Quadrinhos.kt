package com.example.marvel.model.quadrinhos

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Quadrinhos(
        var image: Int,
        var titulo: String,
        var edicao: String,
        var ano: String
) :  Parcelable