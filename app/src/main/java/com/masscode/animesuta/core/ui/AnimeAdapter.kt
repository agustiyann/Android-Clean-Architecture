package com.masscode.animesuta.core.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.masscode.animesuta.core.domain.model.Anime
import com.masscode.animesuta.databinding.ItemListAnimeBinding

class AnimeAdapter(private val showDetail: (Anime) -> Unit) :
    ListAdapter<Anime, AnimeAdapter.AnimeViewHolder>(DiffCallback) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AnimeAdapter.AnimeViewHolder {
        return AnimeViewHolder(
            ItemListAnimeBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: AnimeAdapter.AnimeViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    inner class AnimeViewHolder(private var binding: ItemListAnimeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(anime: Anime?) {
            binding.anime = anime

            with(binding.root) {
                setOnClickListener { showDetail(anime!!) }
            }

            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Anime>() {
        override fun areItemsTheSame(oldItem: Anime, newItem: Anime): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Anime, newItem: Anime): Boolean {
            return oldItem.id == newItem.id
        }
    }
}