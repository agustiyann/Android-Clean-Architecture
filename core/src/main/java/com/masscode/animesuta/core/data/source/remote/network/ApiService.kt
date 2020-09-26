package com.masscode.animesuta.core.data.source.remote.network

import com.masscode.animesuta.core.data.source.remote.response.ListAnimeResponse
import retrofit2.http.GET

interface ApiService {
    @GET("trending/anime")
    suspend fun getAnimeList(): ListAnimeResponse
}