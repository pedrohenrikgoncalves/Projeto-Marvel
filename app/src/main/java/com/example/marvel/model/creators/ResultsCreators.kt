package com.example.marvel.model.creators


import android.annotation.SuppressLint
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import android.os.Parcelable

@SuppressLint("ParcelCreator")
@Parcelize
data class ResultsCreators(
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
        var results: MutableSet<Creators>? = mutableSetOf(),
        @SerializedName("total")
        var total: Int? = 0
    ) : Parcelable {
        @SuppressLint("ParcelCreator")
        @Parcelize
        data class Creators(
            @SerializedName("comics")
            var comics: Comics? = Comics(),
            @SerializedName("events")
            var events: Events? = Events(),
            @SerializedName("firstName")
            var firstName: String? = "",
            @SerializedName("fullName")
            var fullName: String? = "",
            @SerializedName("id")
            var id: Int? = 0,
            @SerializedName("lastName")
            var lastName: String? = "",
            @SerializedName("middleName")
            var middleName: String? = "",
            @SerializedName("modified")
            var modified: String? = "",
            @SerializedName("resourceURI")
            var resourceURI: String? = "",
            @SerializedName("series")
            var series: Series? = Series(),
            @SerializedName("stories")
            var stories: Stories? = Stories(),
            @SerializedName("suffix")
            var suffix: String? = "",
            @SerializedName("thumbnail")
            var thumbnail: Thumbnail? = Thumbnail(),
            @SerializedName("urls")
            var urls: List<Url?>? = listOf()
        ) : Parcelable {
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
                    var resourceURI: String? = ""
                ) : Parcelable
            }

            @SuppressLint("ParcelCreator")
            @Parcelize
            data class Events(
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
            data class Series(
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
        }
    }
}