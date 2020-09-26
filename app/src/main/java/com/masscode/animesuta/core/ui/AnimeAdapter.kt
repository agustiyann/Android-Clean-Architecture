package com.masscode.animesuta.core.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.masscode.animesuta.core.data.source.local.entity.AnimeEntity
import com.masscode.animesuta.databinding.ItemListAnimeBinding

class AnimeAdapter(private val showDetail: (AnimeEntity) -> Unit) :
    ListAdapter<AnimeEntity, AnimeAdapter.AnimeViewHolder>(DiffCallback) {
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
        fun bind(anime: AnimeEntity?) {
            binding.anime = anime

            with(binding.root) {
                setOnClickListener { showDetail(anime!!) }
            }

            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<AnimeEntity>() {
        override fun areItemsTheSame(oldItem: AnimeEntity, newItem: AnimeEntity): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: AnimeEntity, newItem: AnimeEntity): Boolean {
            return oldItem.id == newItem.id
        }
    }
}