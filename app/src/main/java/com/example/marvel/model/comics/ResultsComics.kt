package com.example.marvel.model.comics


import android.annotation.SuppressLint
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import android.os.Parcelable
import kotlinx.android.parcel.RawValue

@SuppressLint("ParcelCreator")
@Parcelize
data class ResultsComics(
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
        val results: MutableSet<Comics> = mutableSetOf(),
        @SerializedName("total")
        val total: Int = 0
    ) : Parcelable {
        @SuppressLint("ParcelCreator")
        @Parcelize
        data class Comics(
                @SerializedName("characters")
            val characters: Characters = Characters(),
                @SerializedName("collectedIssues")
            val collectedIssues: List<CollectedIssue> = listOf(),
                @SerializedName("collections")
            val collections: @RawValue List<Any> = listOf(),
                @SerializedName("creators")
            val creators: Creators = Creators(),
                @SerializedName("dates")
            val dates: List<Date> = listOf(),
                @SerializedName("description")
            val description: String = "",
                @SerializedName("diamondCode")
            val diamondCode: String = "",
                @SerializedName("digitalId")
            val digitalId: Int = 0,
                @SerializedName("ean")
            val ean: String = "",
                @SerializedName("events")
            val events: Events = Events(),
                @SerializedName("format")
            val format: String = "",
                @SerializedName("id")
            val id: Int = 0,
                @SerializedName("images")
            val images: List<Image> = listOf(),
                @SerializedName("isbn")
            val isbn: String = "",
                @SerializedName("issn")
            val issn: String = "",
                @SerializedName("issueNumber")
            val issueNumber: Int = 0,
                @SerializedName("modified")
            val modified: String = "",
                @SerializedName("pageCount")
            val pageCount: Int = 0,
                @SerializedName("prices")
            val prices: List<Price> = listOf(),
                @SerializedName("resourceURI")
            val resourceURI: String = "",
                @SerializedName("series")
            val series: Series = Series(),
                @SerializedName("stories")
            val stories: Stories = Stories(),
                @SerializedName("textObjects")
            val textObjects: List<TextObject> = listOf(),
                @SerializedName("thumbnail")
            val thumbnail: Thumbnail = Thumbnail(),
                @SerializedName("title")
            val title: String = "",
                @SerializedName("upc")
            val upc: String = "",
                @SerializedName("urls")
            val urls: List<Url> = listOf(),
                @SerializedName("variantDescription")
            val variantDescription: String = "",
                @SerializedName("variants")
            val variants: List<Variant> = listOf()
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
            data class CollectedIssue(
                @SerializedName("name")
                val name: String = "",
                @SerializedName("resourceURI")
                val resourceURI: String = ""
            ) : Parcelable

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
            data class Date(
                @SerializedName("date")
                val date: String = "",
                @SerializedName("type")
                val type: String = ""
            ) : Parcelable

            @SuppressLint("ParcelCreator")
            @Parcelize
            data class Events(
                @SerializedName("available")
                val available: Int = 0,
                @SerializedName("collectionURI")
                val collectionURI: String = "",
                @SerializedName("items")
                val items: @RawValue List<Any> = listOf(),
                @SerializedName("returned")
                val returned: Int = 0
            ) : Parcelable

            @SuppressLint("ParcelCreator")
            @Parcelize
            data class Image(
                @SerializedName("extension")
                val extension: String = "",
                @SerializedName("path")
                val path: String = ""
            ) : Parcelable

            @SuppressLint("ParcelCreator")
            @Parcelize
            data class Price(
                    @SerializedName("price")
                val price: Double = 0.0,
                    @SerializedName("type")
                val type: String = ""
            ) : Parcelable

            @SuppressLint("ParcelCreator")
            @Parcelize
            data class Series(
                @SerializedName("name")
                val name: String = "",
                @SerializedName("resourceURI")
                val resourceURI: String = ""
            ) : Parcelable

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
            data class TextObject(
                @SerializedName("language")
                val language: String = "",
                @SerializedName("text")
                val text: String = "",
                @SerializedName("type")
                val type: String = ""
            ) : Parcelable

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

            @SuppressLint("ParcelCreator")
            @Parcelize
            data class Variant(
                @SerializedName("name")
                val name: String = "",
                @SerializedName("resourceURI")
                val resourceURI: String = ""
            ) : Parcelable
        }
    }
}