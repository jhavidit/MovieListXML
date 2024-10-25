package com.jhavidit.movielistxml.usecase

import com.jhavidit.movielistxml.MovieRepository
import com.jhavidit.movielistxml.api.model.MovieDetailResponse
import com.jhavidit.movielistxml.network.NetworkResult
import javax.inject.Inject

class MovieDetailUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {

    suspend operator fun invoke(id: Int): NetworkResult<MovieDetailResponse> {
        return movieRepository.getMovieDetail(id)
    }

}