package com.masscode.animesuta.detail

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.masscode.animesuta.R
import com.masscode.animesuta.databinding.ActivityDetailAnimeBinding


class DetailAnimeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailAnimeBinding
    private lateinit var detailViewModel: DetailAnimeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail_anime)
        val mAnime = DetailAnimeActivityArgs.fromBundle(intent.extras!!).anime
        with(binding) {
            activity = this@DetailAnimeActivity
            lifecycleOwner = this@DetailAnimeActivity
            anime = mAnime
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
}