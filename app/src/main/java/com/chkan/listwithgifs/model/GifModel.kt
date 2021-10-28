package com.chkan.listwithgifs.model


import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

data class GifModel(
    @Json(name = "data")
    val listGifts: List<Gif>
)

@Parcelize
data class Gif(
    @Json(name = "id")
    val id: String,
    @Json(name = "images")
    val images: Images,
    @Json(name = "title")
    val title: String
):Parcelable

@Parcelize
data class Images(
    @Json(name = "downsized_large")
    val largeSize: DownsizedLarge,
    @Json(name = "fixed_height")
    val fixedHeight: FixedHeight,
    @Json(name = "fixed_width")
    val fixedWidth: FixedWidth
):Parcelable

@Parcelize
data class DownsizedLarge(
    @Json(name = "height")
    val height: String,
    @Json(name = "url")
    val url: String,
    @Json(name = "width")
    val width: String
):Parcelable

@Parcelize
data class FixedHeight(
    @Json(name = "height")
    val height: String,
    @Json(name = "url")
    val url: String,
    @Json(name = "width")
    val width: String
):Parcelable

@Parcelize
data class FixedWidth(
    @Json(name = "height")
    val height: String,
    @Json(name = "url")
    val url: String,
    @Json(name = "width")
    val width: String
):Parcelable