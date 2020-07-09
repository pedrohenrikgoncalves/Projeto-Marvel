package com.example.marvel.model.characters

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "characters")
data class CharacterRoom(
        @ColumnInfo(name = "description")
        var description: String?,
        @PrimaryKey(autoGenerate = true)
        var id: Int?,
        @ColumnInfo(name = "name")
        var name: String?,
        @ColumnInfo(name = "image")
        var image: String?
) : Parcelable