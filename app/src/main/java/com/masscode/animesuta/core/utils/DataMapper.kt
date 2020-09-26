package com.masscode.animesuta.core.utils

import com.masscode.animesuta.core.data.source.local.entity.AnimeEntity
import com.masscode.animesuta.core.data.source.remote.response.AnimeResponse
import com.masscode.animesuta.core.domain.model.Anime

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

    fun mapEntitiesToDomain(input: List<AnimeEntity>): List<Anime> =
        input.map {
            Anime(
                id = it.id,
                canonicalTitle = it.canonicalTitle,
                startDate = it.startDate,
                averageRating = it.averageRating,
                synopsis = it.synopsis,
                posterImage = it.posterImage,
                coverImage = it.coverImage,
                youtubeVideoId = it.youtubeVideoId,
                isFavorite = it.isFavorite
            )
        }

    fun mapDomainToEntity(input: Anime) = AnimeEntity(
        id = input.id,
        canonicalTitle = input.canonicalTitle,
        startDate = input.startDate,
        averageRating = input.averageRating,
        synopsis = input.synopsis,
        posterImage = input.posterImage,
        coverImage = input.coverImage,
        youtubeVideoId = input.youtubeVideoId,
        isFavorite = input.isFavorite
    )
}