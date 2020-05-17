package com.example.marvel.model

import android.os.Parcel
import android.os.Parcelable

class Quadrinhos : Parcelable {
    var image: Int
        private set
    var titulo: String?
    var edicao: String?
    var ano: String?

    constructor(image: Int, titulo: String?, edicao: String?, ano: String?) {
        this.image = image
        this.titulo = titulo
        this.edicao = edicao
        this.ano = ano
    }

    constructor(`in`: Parcel) {
        image = `in`.readInt()
        titulo = `in`.readString()
        edicao = `in`.readString()
        ano = `in`.readString()
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeInt(image)
        dest.writeString(titulo)
        dest.writeString(edicao)
        dest.writeString(ano)
    }

    companion object {
        val CREATOR: Parcelable.Creator<Quadrinhos?> = object : Parcelable.Creator<Quadrinhos?> {
            override fun createFromParcel(`in`: Parcel): Quadrinhos? {
                return Quadrinhos(`in`)
            }

            override fun newArray(size: Int): Array<Quadrinhos?> {
                return arrayOfNulls(size)
            }
        }
    }
}