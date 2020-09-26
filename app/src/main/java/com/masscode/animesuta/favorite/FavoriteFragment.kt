package com.masscode.animesuta.favorite

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.masscode.animesuta.R
import com.masscode.animesuta.core.data.source.local.entity.AnimeEntity
import com.masscode.animesuta.core.ui.AnimeAdapter
import com.masscode.animesuta.core.ui.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_favorite.*
import kotlinx.android.synthetic.main.fragment_home.rv_anime

class FavoriteFragment : Fragment() {

    private lateinit var favoriteViewModel: FavoriteViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val animeAdapter = AnimeAdapter { item -> showDetail(item) }

            val factory = ViewModelFactory.getInstance(requireActivity())
            favoriteViewModel = ViewModelProvider(this, factory)[FavoriteViewModel::class.java]

            favoriteViewModel.favoriteAnime.observe(viewLifecycleOwner, { anime ->
                animeAdapter.submitList(anime)
                view_empty.visibility = if (anime.isNotEmpty()) View.GONE else View.VISIBLE
            })

            with(rv_anime) {
                layoutManager = GridLayoutManager(requireContext(), 2)
                setHasFixedSize(true)
                adapter = animeAdapter
            }
        }
    }

    private fun showDetail(anime: AnimeEntity) {
        Log.d("debug", "OnClick : ${anime.canonicalTitle}")
        findNavController().navigate(
            FavoriteFragmentDirections.actionFavoriteFragmentToDetailAnimeActivity(
                anime
            )
        )
    }
}