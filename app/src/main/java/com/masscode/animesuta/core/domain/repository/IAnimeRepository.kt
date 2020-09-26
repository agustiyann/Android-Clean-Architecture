package com.masscode.animesuta.core.domain.repository

import com.masscode.animesuta.core.data.Resource
import com.masscode.animesuta.core.domain.model.Anime
import kotlinx.coroutines.flow.Flow

interface IAnimeRepository {

    fun getAllAnime(): Flow<Resource<List<Anime>>>

    fun getFavoriteAnime(): Flow<List<Anime>>

    fun setFavoriteAnime(anime: Anime, state: Boolean)

}