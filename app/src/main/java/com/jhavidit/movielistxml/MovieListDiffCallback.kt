package com.jhavidit.movielistxml

import androidx.recyclerview.widget.DiffUtil
import com.jhavidit.movielistxml.api.model.MovieListingResponse

class MovieDiffCallback(
    private val oldList: List<MovieListingResponse.Result>,
    private val newList: List<MovieListingResponse.Result>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}