package com.masscode.animesuta.core.di

import android.content.Context
import com.masscode.animesuta.core.data.AnimeRepository
import com.masscode.animesuta.core.data.source.local.LocalDataSource
import com.masscode.animesuta.core.data.source.local.room.AnimeDatabase
import com.masscode.animesuta.core.data.source.remote.RemoteDataSource
import com.masscode.animesuta.core.utils.AppExecutors

object Injection {
    fun provideRepository(context: Context): AnimeRepository {
        val database = AnimeDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance()
        val localDataSource = LocalDataSource.getInstance(database.animeDao())
        val appExecutors = AppExecutors()

        return AnimeRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }
}