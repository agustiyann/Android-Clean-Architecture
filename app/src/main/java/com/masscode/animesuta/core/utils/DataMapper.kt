package com.masscode.animesuta.core.utils

import com.masscode.animesuta.core.data.source.local.entity.AnimeEntity
import com.masscode.animesuta.core.data.source.remote.response.AnimeResponse

object DataMapper {

    fun mapResponsesToEntities(input: List<AnimeResponse>): List<AnimeEntity> {
        val animeList = ArrayList<AnimeEntity>()
        input.map {
            val anime = AnimeEntity(
                id = it.id,
                canonicalTitle = it.attributes.canonicalTitle,
                startDate = it.attributes.startDate,
                averageRating = it.attributes.averageRating,
                synopsis = it.attributes.synopsis,
                posterImage = it.attributes.posterImage.medium,
                coverImage = it.attributes.coverImage.large,
                youtubeVideoId = it.attributes.youtubeVideoId,
                isFavorite = false
            )
            animeList.add(anime)
        }
        return animeList
    }

}