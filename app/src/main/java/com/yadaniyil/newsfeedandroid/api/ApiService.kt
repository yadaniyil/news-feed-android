package com.yadaniyil.newsfeedandroid.api

import com.yadaniyil.newsfeedandroid.models.ArticlesResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("search_by_date")
    fun searchByDate(
            @Query("page") pageNumber: Int = 0,
            @Query("tags") tags: String = "story"): Single<ArticlesResponse>
}