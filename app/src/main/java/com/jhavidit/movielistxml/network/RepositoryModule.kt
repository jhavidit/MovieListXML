package com.jhavidit.movielistxml.network

import com.jhavidit.movielistxml.MovieRepository
import com.jhavidit.movielistxml.MovieRepositoryImpl
import com.jhavidit.movielistxml.api.MovieService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideMovieRepository(movieService: MovieService): MovieRepository {
        return MovieRepositoryImpl(movieService)
    }

}