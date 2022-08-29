package com.mamunsproject.imagesearch_retrofit_dg_hilt_paging3.di

import com.mamunsproject.Constant.BASE_URL
import com.mamunsproject.imagesearch_retrofit_dg_hilt_paging3.api.UnsplashAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()


    @Provides
    @Singleton
    fun provideUnsplashAPI(retrofit: Retrofit): UnsplashAPI =
        retrofit.create(UnsplashAPI::class.java)


}