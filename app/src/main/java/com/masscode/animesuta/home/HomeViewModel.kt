package com.masscode.animesuta.home

import androidx.lifecycle.ViewModel
import com.masscode.animesuta.core.data.AnimeRepository

class HomeViewModel(animeRepository: AnimeRepository) : ViewModel() {

    val anime = animeRepository.getAllAnime()

}