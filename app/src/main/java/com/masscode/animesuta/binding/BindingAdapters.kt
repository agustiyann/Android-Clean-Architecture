package com.masscode.animesuta.binding

import android.annotation.SuppressLint
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("app:showImage")
fun showImage(imgView: ImageView, url: String?) {
    Glide.with(imgView.context).load(url).into(imgView)
}

@SuppressLint("SetTextI18n")
@BindingAdapter("app:startDate")
fun startDate(textView: TextView, date: String) {
    textView.text = "Start date: $date"
}

@BindingAdapter("app:setRating")
fun setRating(ratingBar: RatingBar, rating: Double) {
    val float = rating.toFloat()
    ratingBar.rating = float / 20
}