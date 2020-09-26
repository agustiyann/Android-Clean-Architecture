package com.masscode.animesuta.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.masscode.animesuta.R
import com.masscode.animesuta.core.data.source.local.entity.AnimeEntity
import com.masscode.animesuta.databinding.ActivityDetailAnimeBinding
import kotlinx.android.synthetic.main.content_detail_anime.*
import kotlinx.android.synthetic.main.activity_detail_anime.*

class DetailAnimeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailAnimeBinding
    private lateinit var detailViewModel: DetailAnimeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail_anime)
//        setContentView(R.layout.activity_detail_anime)
        val mAnime = DetailAnimeActivityArgs.fromBundle(intent.extras!!).anime
        with(binding) {
            activity = this@DetailAnimeActivity
            lifecycleOwner = this@DetailAnimeActivity
            anime = mAnime
        }



//        tv_detail_description.text = anime.synopsis
//        Glide.with(this)
//            .load(anime.coverImage)
//            .into(text_detail_image)
//        Glide.with(this)
//            .load(anime.posterImage)
//            .into(poster_image)
    }
}