package com.masscode.animesuta.core.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.masscode.animesuta.core.data.source.local.entity.AnimeEntity

@Dao
interface AnimeDao {

    @Query("SELECT * FROM anime")
    fun getAllAnime(): LiveData<List<AnimeEntity>>

    @Query("SELECT * FROM anime where isFavorite = 1")
    fun getFavoriteAnime(): LiveData<List<AnimeEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAnime(anime: List<AnimeEntity>)

    @Update
    fun updateFavoriteAnime(anime: AnimeEntity)

}