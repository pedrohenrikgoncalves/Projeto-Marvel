package com.example.marvel.data

import androidx.room.TypeConverter
import com.example.marvel.model.characters.ResultsCharacters.Data.Characters.Thumbnail
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class TypeConverter {

    @TypeConverter
    fun fromTimestamp(value: String): Thumbnail? {
        return Thumbnail(value)
    }

    @TypeConverter
    fun dateToTimestamp(date: Thumbnail?): String? {
        return date?.extension
    }
}