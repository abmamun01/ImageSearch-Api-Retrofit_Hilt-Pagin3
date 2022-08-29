package com.mamunsproject.imagesearch_retrofit_dg_hilt_paging3.mvvm

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import javax.inject.Inject


class GalleryViewModel @ViewModelInject constructor(val repository: UnsplashRepository) :
    ViewModel() {

    val currentQuery = MutableLiveData(DEFAULT_QUERY)

    val photos = currentQuery.switchMap { queryString ->
        // we have to return livedata value
        repository.getSearchResults(queryString).cachedIn(viewModelScope)
    }

    fun searchPhotos(query: String) {
        // to swap or to search different photos use switch map
        currentQuery.value = query
    }

    companion object {
        private const val DEFAULT_QUERY = "cats"
    }
}
