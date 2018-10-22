package com.yadaniyil.newsfeedandroid.api

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.yadaniyil.newsfeedandroid.models.Article
import io.reactivex.disposables.CompositeDisposable

class ArticlesDataSourceFactory(
        private val compositeDisposable: CompositeDisposable,
        private val api: ApiService)
    : DataSource.Factory<Int, Article>() {

    val newsDataSourceLiveData = MutableLiveData<ArticlesDataSource>()

    override fun create(): DataSource<Int, Article> {
        val newsDataSource = ArticlesDataSource(api, compositeDisposable)
        newsDataSourceLiveData.postValue(newsDataSource)
        return newsDataSource
    }
}