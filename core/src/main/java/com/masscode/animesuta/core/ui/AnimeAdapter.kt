package com.masscode.animesuta.core.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.masscode.animesuta.core.databinding.ItemListAnimeBinding
import com.masscode.animesuta.core.domain.model.Anime

class AnimeAdapter(private val showDetail: (Anime) -> Unit) :
    RecyclerView.Adapter<AnimeAdapter.AnimeViewHolder>() {

    private var listData = ArrayList<Anime>()

    fun setData(newListData: List<Anime>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

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
        val item = listData[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = listData.size

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
}