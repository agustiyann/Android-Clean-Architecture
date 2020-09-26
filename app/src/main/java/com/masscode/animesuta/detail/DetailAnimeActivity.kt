package com.masscode.animesuta.detail

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.masscode.animesuta.R
import com.masscode.animesuta.core.data.source.local.entity.AnimeEntity
import com.masscode.animesuta.core.ui.ViewModelFactory
import com.masscode.animesuta.databinding.ActivityDetailAnimeBinding


class DetailAnimeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailAnimeBinding
    private lateinit var detailViewModel: DetailAnimeViewModel
    private lateinit var mAnime: AnimeEntity
    private var statusFavorite: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail_anime)

        val factory = ViewModelFactory.getInstance(this)
        detailViewModel = ViewModelProvider(this, factory)[DetailAnimeViewModel::class.java]

        mAnime = DetailAnimeActivityArgs.fromBundle(intent.extras!!).anime
        statusFavorite = mAnime.isFavorite
        setStatusFavorite(statusFavorite)
        with(binding) {
            activity = this@DetailAnimeActivity
            lifecycleOwner = this@DetailAnimeActivity
            anime = mAnime
            fab.setOnClickListener { fabListener() }
        }
    }

    fun playTrailer(id: String) {
        val appIntent = Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:$id"))
        val webIntent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?v=$id"))

        try {
            startActivity(appIntent)
        } catch (ex: ActivityNotFoundException) {
            startActivity(webIntent)
        }
    }

    private fun fabListener() {
        statusFavorite = !statusFavorite
        detailViewModel.setFavoriteAnime(mAnime, statusFavorite)
        setStatusFavorite(statusFavorite)
    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite) {
            binding.fab.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.ic_favorite_white
                )
            )
        } else {
            binding.fab.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.ic_not_favorite_white
                )
            )
        }
    }

}