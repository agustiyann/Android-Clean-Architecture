package com.masscode.animesuta.core.domain.repository

import androidx.lifecycle.LiveData
import com.masscode.animesuta.core.data.Resource
import com.masscode.animesuta.core.domain.model.Anime

interface IAnimeRepository {

    fun getAllAnime(): LiveData<Resource<List<Anime>>>

    fun getFavoriteAnime(): LiveData<List<Anime>>

    fun setFavoriteAnime(anime: Anime, state: Boolean)

}