package com.masscode.animesuta.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.masscode.animesuta.R
import com.masscode.animesuta.core.data.Resource
import com.masscode.animesuta.core.domain.model.Anime
import com.masscode.animesuta.core.ui.AnimeAdapter
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.view_error.*
import org.koin.android.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val animeAdapter = AnimeAdapter { item -> showDetail(item) }

            homeViewModel.anime.observe(viewLifecycleOwner, { anime ->
                if (anime != null) {
                    when (anime) {
                        is Resource.Loading -> progress_bar.visibility = View.VISIBLE
                        is Resource.Success -> {
                            progress_bar.visibility = View.GONE
                            animeAdapter.submitList(anime.data)
                        }
                        is Resource.Error -> {
                            progress_bar.visibility = View.GONE
                            view_error.visibility = View.VISIBLE
                            tv_error.text = anime.message ?: getString(R.string.something_wrong)
                        }
                    }
                }
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
        this.findNavController()
            .navigate(HomeFragmentDirections.actionHomeFragmentToDetailAnimeActivity(anime))
    }
}