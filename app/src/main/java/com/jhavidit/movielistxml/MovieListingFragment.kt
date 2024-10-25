package com.jhavidit.movielistxml

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.jhavidit.movielistxml.baseviews.BaseFragment
import com.jhavidit.movielistxml.databinding.FragmentMovieListingBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieListingFragment : BaseFragment<FragmentMovieListingBinding>() {

    private val viewModel: MovieListingViewModel by viewModels()
    private lateinit var adapter: MovieListAdapter

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentMovieListingBinding {
        return FragmentMovieListingBinding.inflate(inflater, container, false)
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getMovieList()
        adapter = MovieListAdapter()
        binding.recyclerView.adapter = adapter
        viewModel.liveState.observe(viewLifecycleOwner) {
            when (it) {
                is MovieListingViewModel.State.Error -> {
                    binding.swipeRefresh.isRefreshing = false
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                }

                MovieListingViewModel.State.Loading -> {
                    binding.swipeRefresh.isRefreshing = true
                }

                is MovieListingViewModel.State.MovieListingSuccess -> {
                    binding.swipeRefresh.isRefreshing = false
                    adapter.setMovieList(it.movieListingResponse.results ?: emptyList())
                }
            }
        }
    }
}