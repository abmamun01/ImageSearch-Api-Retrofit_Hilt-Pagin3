package com.mamunsproject.imagesearch_retrofit_dg_hilt_paging3.api

import com.mamunsproject.Constant.API_KEY
import com.mamunsproject.imagesearch_retrofit_dg_hilt_paging3.data.UnsplashPhoto
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface UnsplashAPI {

    @Headers("Accept-Version: v1", "Authorization: Client-ID $API_KEY")
    @GET("/search/photos")
    suspend fun getSearchedPhoto(
        @Query("query") query: String,
        @Query("page") page: Int,
        @Query("per_page") per_page: Int
    ): List<UnsplashPhoto>
}