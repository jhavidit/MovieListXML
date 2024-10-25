package com.jhavidit.movielistxml

import android.view.LayoutInflater
import android.view.ViewGroup
import com.jhavidit.movielistxml.baseviews.BaseFragment
import com.jhavidit.movielistxml.databinding.FragmentMovieDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieDetailFragment : BaseFragment<FragmentMovieDetailBinding>() {

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentMovieDetailBinding {
        return FragmentMovieDetailBinding.inflate(inflater, container, false)
    }

}