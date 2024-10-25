package com.jhavidit.movielistxml.usecase

import com.jhavidit.movielistxml.MovieRepository
import com.jhavidit.movielistxml.api.model.MovieListingResponse
import com.jhavidit.movielistxml.network.NetworkResult
import javax.inject.Inject

class MovieListingUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {

    suspend operator fun invoke(): NetworkResult<MovieListingResponse> {
        return movieRepository.getMovieList()
    }

}