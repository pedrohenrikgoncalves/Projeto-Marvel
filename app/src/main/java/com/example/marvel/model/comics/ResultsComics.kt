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
    var attributionHTML: String? = "",
    @SerializedName("attributionText")
    var attributionText: String? = "",
    @SerializedName("code")
    var code: Int? = 0,
    @SerializedName("copyright")
    var copyright: String? = "",
    @SerializedName("data")
    var `data`: Data? = Data(),
    @SerializedName("etag")
    var etag: String? = "",
    @SerializedName("status")
    var status: String? = ""
) : Parcelable {
    @SuppressLint("ParcelCreator")
    @Parcelize
    data class Data(
            @SerializedName("count")
        var count: Int? = 0,
            @SerializedName("limit")
        var limit: Int? = 0,
            @SerializedName("offset")
        var offset: Int? = 0,
            @SerializedName("results")
        var results: MutableSet<Comics>? = mutableSetOf(),
            @SerializedName("total")
        var total: Int? = 0
    ) : Parcelable {
        @SuppressLint("ParcelComics")
        @Parcelize
        data class Comics(
                @SerializedName("characters")
            var characters: Characters? = Characters(),
                @SerializedName("collectedIssues")
            var collectedIssues: List<CollectedIssue?>? = listOf(),
                @SerializedName("collections")
            var collections: @RawValue List<Any?>? = listOf(),
                @SerializedName("creators")
            var comics: Comics? = Comics(),
                @SerializedName("dates")
            var dates: List<Date?>? = listOf(),
                @SerializedName("description")
            var description: String? = "",
                @SerializedName("diamondCode")
            var diamondCode: String? = "",
                @SerializedName("digitalId")
            var digitalId: Int? = 0,
                @SerializedName("ean")
            var ean: String? = "",
                @SerializedName("events")
            var events: Events? = Events(),
                @SerializedName("format")
            var format: String? = "",
                @SerializedName("id")
            var id: Int? = 0,
                @SerializedName("images")
            var images: List<Image?>? = listOf(),
                @SerializedName("isbn")
            var isbn: String? = "",
                @SerializedName("issn")
            var issn: String? = "",
                @SerializedName("issueNumber")
            var issueNumber: Int? = 0,
                @SerializedName("modified")
            var modified: String? = "",
                @SerializedName("pageCount")
            var pageCount: Int? = 0,
                @SerializedName("prices")
            var prices: List<Price?>? = listOf(),
                @SerializedName("resourceURI")
            var resourceURI: String? = "",
                @SerializedName("series")
            var series: Series? = Series(),
                @SerializedName("stories")
            var stories: Stories? = Stories(),
                @SerializedName("textObjects")
            var textObjects: List<TextObject?>? = listOf(),
                @SerializedName("thumbnail")
            var thumbnail: Thumbnail? = Thumbnail(),
                @SerializedName("title")
            var title: String? = "",
                @SerializedName("upc")
            var upc: String? = "",
                @SerializedName("urls")
            var urls: List<Url?>? = listOf(),
                @SerializedName("variantDescription")
            var variantDescription: String? = "",
                @SerializedName("variants")
            var variants: List<Variant?>? = listOf()
        ) : Parcelable {
            @SuppressLint("ParcelCreator")
            @Parcelize
            data class Characters(
                @SerializedName("available")
                var available: Int? = 0,
                @SerializedName("collectionURI")
                var collectionURI: String? = "",
                @SerializedName("items")
                var items: List<Item?>? = listOf(),
                @SerializedName("returned")
                var returned: Int? = 0
            ) : Parcelable {
                @SuppressLint("ParcelCreator")
                @Parcelize
                data class Item(
                    @SerializedName("name")
                    var name: String? = "",
                    @SerializedName("resourceURI")
                    var resourceURI: String? = ""
                ) : Parcelable
            }

            @SuppressLint("ParcelCreator")
            @Parcelize
            data class CollectedIssue(
                @SerializedName("name")
                var name: String? = "",
                @SerializedName("resourceURI")
                var resourceURI: String? = ""
            ) : Parcelable

            @SuppressLint("ParcelCreator")
            @Parcelize
            data class Comics(
                @SerializedName("available")
                var available: Int? = 0,
                @SerializedName("collectionURI")
                var collectionURI: String? = "",
                @SerializedName("items")
                var items: List<Item?>? = listOf(),
                @SerializedName("returned")
                var returned: Int? = 0
            ) : Parcelable {
                @SuppressLint("ParcelCreator")
                @Parcelize
                data class Item(
                    @SerializedName("name")
                    var name: String? = "",
                    @SerializedName("resourceURI")
                    var resourceURI: String? = "",
                    @SerializedName("role")
                    var role: String? = ""
                ) : Parcelable
            }

            @SuppressLint("ParcelCreator")
            @Parcelize
            data class Date(
                @SerializedName("date")
                var date: String? = "",
                @SerializedName("type")
                var type: String? = ""
            ) : Parcelable

            @SuppressLint("ParcelCreator")
            @Parcelize
            data class Events(
                    @SerializedName("available")
                var available: Int? = 0,
                    @SerializedName("collectionURI")
                var collectionURI: String? = "",
                    @SerializedName("items")
                var items: @RawValue List<Any?>? = listOf(),
                    @SerializedName("returned")
                var returned: Int? = 0
            ) : Parcelable

            @SuppressLint("ParcelCreator")
            @Parcelize
            data class Image(
                @SerializedName("extension")
                var extension: String? = "",
                @SerializedName("path")
                var path: String? = ""
            ) : Parcelable

            @SuppressLint("ParcelCreator")
            @Parcelize
            data class Price(
                @SerializedName("price")
                var price: Double? = 0.0,
                @SerializedName("type")
                var type: String? = ""
            ) : Parcelable

            @SuppressLint("ParcelCreator")
            @Parcelize
            data class Series(
                @SerializedName("name")
                var name: String? = "",
                @SerializedName("resourceURI")
                var resourceURI: String? = ""
            ) : Parcelable

            @SuppressLint("ParcelCreator")
            @Parcelize
            data class Stories(
                @SerializedName("available")
                var available: Int? = 0,
                @SerializedName("collectionURI")
                var collectionURI: String? = "",
                @SerializedName("items")
                var items: List<Item?>? = listOf(),
                @SerializedName("returned")
                var returned: Int? = 0
            ) : Parcelable {
                @SuppressLint("ParcelCreator")
                @Parcelize
                data class Item(
                    @SerializedName("name")
                    var name: String? = "",
                    @SerializedName("resourceURI")
                    var resourceURI: String? = "",
                    @SerializedName("type")
                    var type: String? = ""
                ) : Parcelable
            }

            @SuppressLint("ParcelCreator")
            @Parcelize
            data class TextObject(
                @SerializedName("language")
                var language: String? = "",
                @SerializedName("text")
                var text: String? = "",
                @SerializedName("type")
                var type: String? = ""
            ) : Parcelable

            @SuppressLint("ParcelCreator")
            @Parcelize
            data class Thumbnail(
                @SerializedName("extension")
                var extension: String? = "",
                @SerializedName("path")
                var path: String? = ""
            ) : Parcelable

            @SuppressLint("ParcelCreator")
            @Parcelize
            data class Url(
                @SerializedName("type")
                var type: String? = "",
                @SerializedName("url")
                var url: String? = ""
            ) : Parcelable

            @SuppressLint("ParcelCreator")
            @Parcelize
            data class Variant(
                @SerializedName("name")
                var name: String? = "",
                @SerializedName("resourceURI")
                var resourceURI: String? = ""
            ) : Parcelable
        }
    }
}