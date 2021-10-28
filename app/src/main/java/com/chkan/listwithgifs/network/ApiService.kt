package com.chkan.listwithgifs.network

import com.chkan.listwithgifs.model.GifModel
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.*


private const val API_URL =
    "https://api.giphy.com/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(API_URL)
    .build()

interface ApiService {

    @GET("v1/gifs/trending?api_key=BhV54Rr7wBVmlrwDxygy3hyAG3W9tY71&q=&limit=25")
    suspend fun getListGifts() : GifModel
}

object Api {
    val retrofitService: ApiService by lazy { retrofit.create(ApiService::class.java) }
}


