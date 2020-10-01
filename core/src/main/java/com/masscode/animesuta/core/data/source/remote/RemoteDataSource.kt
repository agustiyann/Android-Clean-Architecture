package com.masscode.animesuta.core.data.source.remote

import com.masscode.animesuta.core.data.source.remote.network.ApiResponse
import com.masscode.animesuta.core.data.source.remote.network.ApiService
import com.masscode.animesuta.core.data.source.remote.response.AnimeResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import timber.log.Timber

class RemoteDataSource(private val apiService: ApiService) {

    fun getAllAnime(): Flow<ApiResponse<List<AnimeResponse>>> {
        return flow {
            try {
                val response = apiService.getAnimeList()
                val dataArray = response.animeList
                if (dataArray.isNotEmpty()) {
                    emit(ApiResponse.Success(response.animeList))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Timber.e(e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }
}