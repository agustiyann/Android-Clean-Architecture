package com.masscode.animesuta.core.data.source.local.room

import androidx.room.*
import com.masscode.animesuta.core.data.source.local.entity.AnimeEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AnimeDao {

    @Query("SELECT * FROM anime")
    fun getAllAnime(): Flow<List<AnimeEntity>>

    @Query("SELECT * FROM anime where isFavorite = 1")
    fun getFavoriteAnime(): Flow<List<AnimeEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAnime(anime: List<AnimeEntity>)

    @Update
    fun updateFavoriteAnime(anime: AnimeEntity)

}