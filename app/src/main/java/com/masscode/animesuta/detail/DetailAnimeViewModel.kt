package com.masscode.animesuta.detail

import androidx.lifecycle.ViewModel
import com.masscode.animesuta.core.data.AnimeRepository
import com.masscode.animesuta.core.data.source.local.entity.AnimeEntity

class DetailAnimeViewModel(private val animeRepository: AnimeRepository) : ViewModel() {

    fun setFavoriteAnime(anime: AnimeEntity, newStatus: Boolean) =
        animeRepository.setFavoriteAnime(anime, newStatus)

}