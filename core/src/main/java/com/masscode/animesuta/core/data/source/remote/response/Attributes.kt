package com.masscode.animesuta.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class Attributes(
    @SerializedName("canonicalTitle")
    val canonicalTitle : String,

    @SerializedName("startDate")
    val startDate : String,

    @SerializedName("averageRating")
    val averageRating : Double,

    @SerializedName("synopsis")
    val synopsis : String,

    @SerializedName("posterImage")
    val posterImage : PosterImage,

    @SerializedName("coverImage")
    val coverImage : CoverImage,

    @SerializedName("youtubeVideoId")
    val youtubeVideoId : String
)