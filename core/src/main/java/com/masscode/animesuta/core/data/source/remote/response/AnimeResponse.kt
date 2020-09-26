package com.masscode.animesuta.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class AnimeResponse(
    @SerializedName("id")
    val id : Int,
    @SerializedName("attributes")
    val attributes : Attributes
)