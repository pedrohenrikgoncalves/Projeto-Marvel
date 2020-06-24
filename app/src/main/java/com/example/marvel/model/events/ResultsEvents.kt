package com.example.marvel.model.events


import android.annotation.SuppressLint
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import android.os.Parcelable

@SuppressLint("ParcelCreator")
@Parcelize
data class ResultsEvents(
    @SerializedName("attributionHTML")
    val attributionHTML: String = "",
    @SerializedName("attributionText")
    val attributionText: String = "",
    @SerializedName("code")
    val code: Int = 0,
    @SerializedName("copyright")
    val copyright: String = "",
    @SerializedName("data")
    val `data`: Data = Data(),
    @SerializedName("etag")
    val etag: String = "",
    @SerializedName("status")
    val status: String = ""
) : Parcelable {
    @SuppressLint("ParcelCreator")
    @Parcelize
    data class Data(
        @SerializedName("count")
        val count: Int = 0,
        @SerializedName("limit")
        val limit: Int = 0,
        @SerializedName("offset")
        val offset: Int = 0,
        @SerializedName("results")
        val results: MutableSet<Events> = mutableSetOf(),
        @SerializedName("total")
        val total: Int = 0
    ) : Parcelable {
        @SuppressLint("ParcelCreator")
        @Parcelize
        data class Events(
            @SerializedName("characters")
            val characters: Characters = Characters(),
            @SerializedName("comics")
            val comics: Comics = Comics(),
            @SerializedName("creators")
            val creators: Creators = Creators(),
            @SerializedName("description")
            val description: String = "",
            @SerializedName("end")
            val end: String = "",
            @SerializedName("id")
            val id: Int = 0,
            @SerializedName("modified")
            val modified: String = "",
            @SerializedName("next")
            val next: Next = Next(),
            @SerializedName("previous")
            val previous: Previous = Previous(),
            @SerializedName("resourceURI")
            val resourceURI: String = "",
            @SerializedName("series")
            val series: Series = Series(),
            @SerializedName("start")
            val start: String = "",
            @SerializedName("stories")
            val stories: Stories = Stories(),
            @SerializedName("thumbnail")
            val thumbnail: Thumbnail = Thumbnail(),
            @SerializedName("title")
            val title: String = "",
            @SerializedName("urls")
            val urls: List<Url> = listOf()
        ) : Parcelable {
            @SuppressLint("ParcelCreator")
            @Parcelize
            data class Characters(
                @SerializedName("available")
                val available: Int = 0,
                @SerializedName("collectionURI")
                val collectionURI: String = "",
                @SerializedName("items")
                val items: List<Item> = listOf(),
                @SerializedName("returned")
                val returned: Int = 0
            ) : Parcelable {
                @SuppressLint("ParcelCreator")
                @Parcelize
                data class Item(
                    @SerializedName("name")
                    val name: String = "",
                    @SerializedName("resourceURI")
                    val resourceURI: String = ""
                ) : Parcelable
            }

            @SuppressLint("ParcelCreator")
            @Parcelize
            data class Comics(
                @SerializedName("available")
                val available: Int = 0,
                @SerializedName("collectionURI")
                val collectionURI: String = "",
                @SerializedName("items")
                val items: List<Item> = listOf(),
                @SerializedName("returned")
                val returned: Int = 0
            ) : Parcelable {
                @SuppressLint("ParcelCreator")
                @Parcelize
                data class Item(
                    @SerializedName("name")
                    val name: String = "",
                    @SerializedName("resourceURI")
                    val resourceURI: String = ""
                ) : Parcelable
            }

            @SuppressLint("ParcelCreator")
            @Parcelize
            data class Creators(
                @SerializedName("available")
                val available: Int = 0,
                @SerializedName("collectionURI")
                val collectionURI: String = "",
                @SerializedName("items")
                val items: List<Item> = listOf(),
                @SerializedName("returned")
                val returned: Int = 0
            ) : Parcelable {
                @SuppressLint("ParcelCreator")
                @Parcelize
                data class Item(
                    @SerializedName("name")
                    val name: String = "",
                    @SerializedName("resourceURI")
                    val resourceURI: String = "",
                    @SerializedName("role")
                    val role: String = ""
                ) : Parcelable
            }

            @SuppressLint("ParcelCreator")
            @Parcelize
            data class Next(
                @SerializedName("name")
                val name: String = "",
                @SerializedName("resourceURI")
                val resourceURI: String = ""
            ) : Parcelable

            @SuppressLint("ParcelCreator")
            @Parcelize
            data class Previous(
                @SerializedName("name")
                val name: String = "",
                @SerializedName("resourceURI")
                val resourceURI: String = ""
            ) : Parcelable

            @SuppressLint("ParcelCreator")
            @Parcelize
            data class Series(
                @SerializedName("available")
                val available: Int = 0,
                @SerializedName("collectionURI")
                val collectionURI: String = "",
                @SerializedName("items")
                val items: List<Item> = listOf(),
                @SerializedName("returned")
                val returned: Int = 0
            ) : Parcelable {
                @SuppressLint("ParcelCreator")
                @Parcelize
                data class Item(
                    @SerializedName("name")
                    val name: String = "",
                    @SerializedName("resourceURI")
                    val resourceURI: String = ""
                ) : Parcelable
            }

            @SuppressLint("ParcelCreator")
            @Parcelize
            data class Stories(
                @SerializedName("available")
                val available: Int = 0,
                @SerializedName("collectionURI")
                val collectionURI: String = "",
                @SerializedName("items")
                val items: List<Item> = listOf(),
                @SerializedName("returned")
                val returned: Int = 0
            ) : Parcelable {
                @SuppressLint("ParcelCreator")
                @Parcelize
                data class Item(
                    @SerializedName("name")
                    val name: String = "",
                    @SerializedName("resourceURI")
                    val resourceURI: String = "",
                    @SerializedName("type")
                    val type: String = ""
                ) : Parcelable
            }

            @SuppressLint("ParcelCreator")
            @Parcelize
            data class Thumbnail(
                @SerializedName("extension")
                val extension: String = "",
                @SerializedName("path")
                val path: String = ""
            ) : Parcelable

            @SuppressLint("ParcelCreator")
            @Parcelize
            data class Url(
                @SerializedName("type")
                val type: String = "",
                @SerializedName("url")
                val url: String = ""
            ) : Parcelable
        }
    }
}