package com.masscode.animesuta.core.domain.usecase

import androidx.lifecycle.LiveData
import com.masscode.animesuta.core.data.Resource
import com.masscode.animesuta.core.domain.model.Anime

interface AnimeUseCase {
    fun getAllAnime(): LiveData<Resource<List<Anime>>>
    fun getFavoriteAnime(): LiveData<List<Anime>>
    fun setFavoriteAnime(anime: Anime, state: Boolean)
}