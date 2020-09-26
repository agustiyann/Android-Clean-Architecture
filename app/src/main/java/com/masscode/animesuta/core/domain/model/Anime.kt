package com.masscode.animesuta.core.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Anime(
    var id: Int,
    var canonicalTitle: String,
    var startDate: String,
    var averageRating: Double,
    var synopsis: String,
    var posterImage: String,
    var coverImage: String,
    var youtubeVideoId: String,
    var isFavorite: Boolean = false
) : Parcelable