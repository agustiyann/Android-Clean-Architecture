package com.masscode.animesuta.home

import androidx.lifecycle.ViewModel
import com.masscode.animesuta.core.domain.usecase.AnimeUseCase

class HomeViewModel(animeUseCase: AnimeUseCase) : ViewModel() {

    val anime = animeUseCase.getAllAnime()

}