package com.masscode.animesuta.utils

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("app:showImage")
fun showImage(imgView: ImageView, url: String?) {
    Glide.with(imgView.context).load(url).into(imgView)
}