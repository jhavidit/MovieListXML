package com.jhavidit.movielistxml

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jhavidit.movielistxml.api.model.MovieListingResponse
import com.jhavidit.movielistxml.network.NetworkResult
import com.jhavidit.movielistxml.usecase.MovieListingUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieListingViewModel @Inject constructor(
    private val movieListingUseCase: MovieListingUseCase
) : ViewModel() {



    sealed class State {
        data class MovieListingSuccess(val movieListingResponse: MovieListingResponse) : State()
        data object Loading : State()
        data class Error(val message: String) : State()
    }

    private val _liveState = MutableLiveData<State>()
    val liveState: LiveData<State>
        get() = _liveState

    fun getMovieList() {
        viewModelScope.launch {
            _liveState.postValue(State.Loading)
            when (val result = movieListingUseCase.invoke()) {
                is NetworkResult.Error -> {
                    _liveState.postValue(State.Error(result.message))
                }

                is NetworkResult.Success -> {
                    _liveState.postValue(State.MovieListingSuccess(result.data))
                }
            }
        }
    }

}