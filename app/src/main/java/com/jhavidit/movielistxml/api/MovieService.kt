package com.jhavidit.movielistxml.api

import com.jhavidit.movielistxml.api.model.MovieDetailResponse
import com.jhavidit.movielistxml.api.model.MovieListingResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path


interface MovieService {

    @GET("movie/popular")
    suspend fun getPopularMovieList(): Response<MovieListingResponse>

    @GET("movie/{movie_id}")
    suspend fun getMovieDetails(
        @Path("movie_id") movieId: Int
    ): Response<MovieDetailResponse>
}