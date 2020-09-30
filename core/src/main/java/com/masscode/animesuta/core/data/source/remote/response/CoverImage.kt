package com.masscode.animesuta.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class CoverImage(
    @SerializedName("small")
    val small : String,
    @SerializedName("large")
    val large : String
)