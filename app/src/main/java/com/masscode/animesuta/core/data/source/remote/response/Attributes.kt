package com.masscode.animesuta.core.data.source.remote.response

data class Attributes(
    val canonicalTitle : String,
    val startDate : String,
    val averageRating : Double,
    val synopsis : String,
    val posterImage : PosterImage,
    val coverImage : CoverImage,
    val youtubeVideoId : String
)