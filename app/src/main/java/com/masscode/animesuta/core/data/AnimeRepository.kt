package com.masscode.animesuta.core.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.masscode.animesuta.core.data.source.local.LocalDataSource
import com.masscode.animesuta.core.data.source.local.entity.AnimeEntity
import com.masscode.animesuta.core.data.source.remote.RemoteDataSource
import com.masscode.animesuta.core.data.source.remote.network.ApiResponse
import com.masscode.animesuta.core.data.source.remote.response.AnimeResponse
import com.masscode.animesuta.core.domain.model.Anime
import com.masscode.animesuta.core.utils.AppExecutors
import com.masscode.animesuta.core.utils.DataMapper

class AnimeRepository private constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) {

    companion object {
        @Volatile
        private var instance: AnimeRepository? = null

        fun getInstance(
            remoteData: RemoteDataSource,
            localData: LocalDataSource,
            appExecutors: AppExecutors
        ): AnimeRepository =
            instance ?: synchronized(this) {
                instance ?: AnimeRepository(remoteData, localData, appExecutors)
            }
    }

    fun getAllAnime(): LiveData<Resource<List<Anime>>> =
        object : NetworkBoundResource<List<Anime>, List<AnimeResponse>>(appExecutors) {
            override fun loadFromDB(): LiveData<List<Anime>> {
                return Transformations.map(localDataSource.getAllAnime()) {
                    DataMapper.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Anime>?): Boolean {
                return true// data == null || data.isEmpty()
            }

            override fun createCall(): LiveData<ApiResponse<List<AnimeResponse>>> {
                return remoteDataSource.getAllAnime()
            }

            override fun saveCallResult(data: List<AnimeResponse>) {
                val animeList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertAnime(animeList)
            }
        }.asLiveData()

    fun getFavoriteAnime(): LiveData<List<Anime>> {
        return Transformations.map(localDataSource.getFavoriteAnime()) {
            DataMapper.mapEntitiesToDomain(it)
        }
    }

    fun setFavoriteAnime(anime: Anime, state: Boolean) {
        val animeEntity = DataMapper.mapDomainToEntity(anime)
        appExecutors.diskIO().execute {
            localDataSource.setFavoriteAnime(animeEntity, state)
        }
    }
}