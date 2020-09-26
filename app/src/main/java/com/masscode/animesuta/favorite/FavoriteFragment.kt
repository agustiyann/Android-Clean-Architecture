package com.masscode.animesuta.favorite

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.masscode.animesuta.R
import com.masscode.animesuta.core.domain.model.Anime
import com.masscode.animesuta.core.ui.AnimeAdapter
import kotlinx.android.synthetic.main.fragment_favorite.*
import kotlinx.android.synthetic.main.fragment_home.rv_anime
import org.koin.android.viewmodel.ext.android.viewModel

class FavoriteFragment : Fragment() {

    private val favoriteViewModel: FavoriteViewModel by viewModel()

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

            favoriteViewModel.favoriteAnime.observe(viewLifecycleOwner, { anime ->
                animeAdapter.setData(anime)
                view_empty.visibility = if (anime.isNotEmpty()) View.GONE else View.VISIBLE
            })

            with(rv_anime) {
                layoutManager = GridLayoutManager(requireContext(), 2)
                setHasFixedSize(true)
                adapter = animeAdapter
            }
        }
    }

    private fun showDetail(anime: Anime) {
        Log.d("debug", "OnClick : ${anime.canonicalTitle}")
        findNavController().navigate(
            FavoriteFragmentDirections.actionFavoriteFragmentToDetailAnimeActivity(
                anime
            )
        )
    }
}