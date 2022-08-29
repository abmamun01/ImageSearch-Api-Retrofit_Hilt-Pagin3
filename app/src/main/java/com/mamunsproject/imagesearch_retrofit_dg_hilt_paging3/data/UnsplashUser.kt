package com.mamunsproject.imagesearch_retrofit_dg_hilt_paging3.data

data class UnsplashUser(
    val name: String,
    val userName: String
) {
    // it's computed
    val attributionUrl get() = "https:///unsplash.com/$userName?utm_source=ImageSearchApp&utm_medium=referral"
}