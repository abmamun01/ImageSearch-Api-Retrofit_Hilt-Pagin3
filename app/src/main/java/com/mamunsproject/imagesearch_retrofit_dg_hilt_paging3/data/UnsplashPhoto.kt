package com.mamunsproject.imagesearch_retrofit_dg_hilt_paging3.data

data class UnsplashPhoto(
    val id: String,
    val description: String,
    val urls: UnsplashPhotoUrls,
    val user: UnsplashUser
)
