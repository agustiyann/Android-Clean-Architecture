package com.masscode.animesuta.core.data.source.remote

import android.util.Log
import com.masscode.animesuta.core.data.source.remote.network.ApiResponse
import com.masscode.animesuta.core.data.source.remote.network.ApiService
import com.masscode.animesuta.core.data.source.remote.response.AnimeResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoteDataSource(private val apiService: ApiService) {

//    companion object {
//        @Volatile
//        private var instance: RemoteDataSource? = null
//
//        fun getInstance(service: ApiService): RemoteDataSource =
//            instance ?: synchronized(this) {
//                instance ?: RemoteDataSource(service)
//            }
//    }

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
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }
}