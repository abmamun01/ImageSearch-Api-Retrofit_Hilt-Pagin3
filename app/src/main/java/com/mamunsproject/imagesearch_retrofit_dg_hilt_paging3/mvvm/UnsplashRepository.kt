package com.mamunsproject.imagesearch_retrofit_dg_hilt_paging3.mvvm

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.mamunsproject.imagesearch_retrofit_dg_hilt_paging3.api.UnsplashAPI
import com.mamunsproject.imagesearch_retrofit_dg_hilt_paging3.paging3.UnsplashPagingSource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UnsplashRepository @Inject constructor(private val unsplashAPI: UnsplashAPI) {

    // it will later call by viewmodel

    fun getSearchResults(query: String) =
        // return pager
        Pager(
            config = PagingConfig(
                pageSize = 20,
                maxSize = 100,
                enablePlaceholders = false,
            ),
            pagingSourceFactory = { UnsplashPagingSource(unsplashAPI, query) }
        ).liveData


}