package com.jhavidit.movielistxml

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jhavidit.movielistxml.api.model.MovieListingResponse
import com.jhavidit.movielistxml.databinding.MovieListingItemBinding

class MovieListAdapter : RecyclerView.Adapter<MovieListAdapter.MovieListViewHolder>() {

    private var movieList: List<MovieListingResponse.Result> = emptyList()

    inner class MovieListViewHolder(val binding: MovieListingItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListViewHolder {
        val binding =
            MovieListingItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieListViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: MovieListViewHolder, position: Int) {
        val item = movieList[position]
        holder.apply {
            binding.title.text = item.originalTitle
            binding.ratingText.text = (item.voteAverage ?: 0).toString()
            binding.description.text = item.overview
            Glide.with(holder.itemView.context)
                .load("https://image.tmdb.org/t/p/w500" + item.posterPath)
                .into(binding.poster)
        }
    }

    fun setMovieList(movieList: List<MovieListingResponse.Result>) {
        val diffCallback = MovieDiffCallback(this.movieList, movieList)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        this.movieList = movieList
        diffResult.dispatchUpdatesTo(this)
    }

}