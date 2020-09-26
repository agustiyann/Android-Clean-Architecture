package com.masscode.animesuta.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.masscode.animesuta.core.domain.usecase.AnimeUseCase

class FavoriteViewModel(animeUseCase: AnimeUseCase) : ViewModel() {

    val favoriteAnime = animeUseCase.getFavoriteAnime().asLiveData()

}