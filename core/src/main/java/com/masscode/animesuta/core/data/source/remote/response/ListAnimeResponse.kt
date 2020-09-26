package com.masscode.animesuta.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ListAnimeResponse(
    @SerializedName("data") val animeList: List<AnimeResponse>
)