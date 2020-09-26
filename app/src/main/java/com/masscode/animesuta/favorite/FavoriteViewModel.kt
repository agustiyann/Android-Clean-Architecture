package com.masscode.animesuta.favorite

import androidx.lifecycle.ViewModel
import com.masscode.animesuta.core.data.AnimeRepository

class FavoriteViewModel(animeRepository: AnimeRepository) : ViewModel() {

    val favoriteAnime = animeRepository.getFavoriteAnime()

}