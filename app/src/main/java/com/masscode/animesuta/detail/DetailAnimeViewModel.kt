package com.masscode.animesuta.detail

import androidx.lifecycle.ViewModel
import com.masscode.animesuta.core.data.AnimeRepository
import com.masscode.animesuta.core.domain.model.Anime

class DetailAnimeViewModel(private val animeRepository: AnimeRepository) : ViewModel() {

    fun setFavoriteAnime(anime: Anime, newStatus: Boolean) =
        animeRepository.setFavoriteAnime(anime, newStatus)

}