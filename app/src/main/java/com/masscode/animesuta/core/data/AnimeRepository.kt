package com.masscode.animesuta.core.data

import androidx.lifecycle.LiveData
import com.masscode.animesuta.core.data.source.local.LocalDataSource
import com.masscode.animesuta.core.data.source.local.entity.AnimeEntity
import com.masscode.animesuta.core.data.source.remote.RemoteDataSource
import com.masscode.animesuta.core.data.source.remote.network.ApiResponse
import com.masscode.animesuta.core.data.source.remote.response.AnimeResponse
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

    fun getAllAnime(): LiveData<Resource<List<AnimeEntity>>> =
        object : NetworkBoundResource<List<AnimeEntity>, List<AnimeResponse>>(appExecutors) {
            override fun loadFromDB(): LiveData<List<AnimeEntity>> {
                return localDataSource.getAllAnime()
            }

            override fun shouldFetch(data: List<AnimeEntity>?): Boolean {
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

    fun getFavoriteTourism(): LiveData<List<AnimeEntity>> {
        return localDataSource.getFavoriteAnime()
    }

    fun setFavoriteAnime(anime: AnimeEntity, state: Boolean) {
        appExecutors.diskIO().execute {
            localDataSource.setFavoriteAnime(anime, state)
        }
    }
}