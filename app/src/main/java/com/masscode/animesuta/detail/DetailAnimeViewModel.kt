package com.masscode.animesuta.detail

import androidx.lifecycle.ViewModel
import com.masscode.animesuta.core.domain.model.Anime
import com.masscode.animesuta.core.domain.usecase.AnimeUseCase

class DetailAnimeViewModel(private val animeUseCase: AnimeUseCase) : ViewModel() {

    fun setFavoriteAnime(anime: Anime, newStatus: Boolean) =
        animeUseCase.setFavoriteAnime(anime, newStatus)

}