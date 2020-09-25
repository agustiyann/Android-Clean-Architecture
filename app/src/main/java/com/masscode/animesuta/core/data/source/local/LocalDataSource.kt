package com.masscode.animesuta.core.data.source.local

import androidx.lifecycle.LiveData
import com.masscode.animesuta.core.data.source.local.entity.AnimeEntity
import com.masscode.animesuta.core.data.source.local.room.AnimeDao

class LocalDataSource private constructor(private val animeDao: AnimeDao){

    companion object {
        private var instance: LocalDataSource? = null

        fun getInstance(animeDao: AnimeDao): LocalDataSource =
            instance ?: synchronized(this) {
                instance ?: LocalDataSource(animeDao)
            }
    }

    fun getAllAnime(): LiveData<List<AnimeEntity>> = animeDao.getAllAnime()

    fun getFavoriteAnime(): LiveData<List<AnimeEntity>> = animeDao.getFavoriteAnime()

    fun insertAnime(animeList: List<AnimeEntity>) = animeDao.insertAnime(animeList)

    fun setFavoriteAnime(anime: AnimeEntity, newState: Boolean) {
        anime.isFavorite = newState
        animeDao.updateFavoriteAnime(anime)
    }
}