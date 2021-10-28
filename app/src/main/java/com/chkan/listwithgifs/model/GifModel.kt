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
    @Json(name = "images")
    val images: Images,
    @Json(name = "title")
    val title: String
):Parcelable

@Parcelize
data class Images(
    @Json(name = "downsized_large")
    val largeSize: DownsizedLarge,
    @Json(name = "fixed_height_downsampled")
    val fixedHeight: FixedHeight
):Parcelable

@Parcelize
data class DownsizedLarge(
    @Json(name = "url")
    val url: String
):Parcelable

@Parcelize
data class FixedHeight(
    @Json(name = "url")
    val url: String
):Parcelable
