package com.masscode.animesuta.core.data.source.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.masscode.animesuta.core.data.source.remote.network.ApiResponse
import com.masscode.animesuta.core.data.source.remote.network.ApiService
import com.masscode.animesuta.core.data.source.remote.response.AnimeResponse
import com.masscode.animesuta.core.data.source.remote.response.ListAnimeResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource private constructor(private val apiService: ApiService) {

    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(service: ApiService): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(service)
            }
    }

    fun getAllAnime(): LiveData<ApiResponse<List<AnimeResponse>>> {
        val resultData = MutableLiveData<ApiResponse<List<AnimeResponse>>>()

        val client = apiService.getAnimeList()

        client.enqueue(object : Callback<ListAnimeResponse> {
            override fun onResponse(
                call: Call<ListAnimeResponse>,
                response: Response<ListAnimeResponse>
            ) {
                val dataArray = response.body()?.animeList
                resultData.value =
                    if (dataArray != null) ApiResponse.Success(dataArray) else ApiResponse.Empty

            }

            override fun onFailure(call: Call<ListAnimeResponse>, t: Throwable) {
                resultData.value = ApiResponse.Error(t.message.toString())
                Log.e("RemoteDataSource", t.message.toString())
            }
        })

        return resultData
    }
}