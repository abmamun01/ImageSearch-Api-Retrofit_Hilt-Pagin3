package com.mamunsproject.imagesearch_retrofit_dg_hilt_paging3.paging3

import androidx.paging.PagingSource
import com.mamunsproject.imagesearch_retrofit_dg_hilt_paging3.api.UnsplashAPI
import com.mamunsproject.imagesearch_retrofit_dg_hilt_paging3.data.UnsplashPhoto
import retrofit2.HttpException
import java.io.IOException

private const val UNSPLASH_STARTING_PAGE_IDX = 1

class UnsplashPagingSource(
    private val unsplashAPI: UnsplashAPI,
    private val query: String
) : PagingSource<Int, UnsplashPhoto>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UnsplashPhoto> {

        // this is the function when we will trigger api request and turn data into pages
        // here we will init search query

        //current page
        val position = params.key ?: UNSPLASH_STARTING_PAGE_IDX

        return try {
            val response = unsplashAPI.getSearchedPhoto(query, position, params.loadSize)
            val photos = response.results

            // we will load all the result here if it is successful
            LoadResult.Page(
                data = photos,
                prevKey = if (position == UNSPLASH_STARTING_PAGE_IDX) null else position - 1,
                nextKey = if (photos.isEmpty()) null else position + 1

            )
        } catch (e: IOException) {

            LoadResult.Error(e)
        } catch (e: HttpException) {
            LoadResult.Error(e)

        }


    }
}