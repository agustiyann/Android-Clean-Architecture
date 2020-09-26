package com.masscode.animesuta.core.domain.usecase

import androidx.lifecycle.LiveData
import com.masscode.animesuta.core.data.Resource
import com.masscode.animesuta.core.domain.model.Anime
import com.masscode.animesuta.core.domain.repository.IAnimeRepository

class AnimeInteractor(private val animeRepository: IAnimeRepository): AnimeUseCase {
    override fun getAllAnime(): LiveData<Resource<List<Anime>>> {
        return animeRepository.getAllAnime()
    }

    override fun getFavoriteAnime(): LiveData<List<Anime>> {
        return animeRepository.getFavoriteAnime()
    }

    override fun setFavoriteAnime(anime: Anime, state: Boolean) {
        return animeRepository.setFavoriteAnime(anime, state)
    }
}