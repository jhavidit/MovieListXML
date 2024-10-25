package com.jhavidit.movielistxml

import com.jhavidit.movielistxml.api.MovieService
import com.jhavidit.movielistxml.api.model.MovieDetailResponse
import com.jhavidit.movielistxml.api.model.MovieListingResponse
import com.jhavidit.movielistxml.network.NetworkResult
import com.jhavidit.movielistxml.network.safeApiCall
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val movieService: MovieService
) : MovieRepository {
    override suspend fun getMovieList(): NetworkResult<MovieListingResponse> {
        return safeApiCall {
            movieService.getPopularMovieList()
        }
    }

    override suspend fun getMovieDetail(id: Int): NetworkResult<MovieDetailResponse> {
        return safeApiCall {
            movieService.getMovieDetails(movieId = id)
        }
    }
}