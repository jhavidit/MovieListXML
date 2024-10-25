package com.jhavidit.movielistxml

import com.jhavidit.movielistxml.api.model.MovieDetailResponse
import com.jhavidit.movielistxml.api.model.MovieListingResponse
import com.jhavidit.movielistxml.network.NetworkResult

interface MovieRepository {
    suspend fun getMovieList(): NetworkResult<MovieListingResponse>
    suspend fun getMovieDetail(id: Int): NetworkResult<MovieDetailResponse>
}