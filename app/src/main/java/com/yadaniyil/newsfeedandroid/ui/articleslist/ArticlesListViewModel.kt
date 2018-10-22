package com.yadaniyil.newsfeedandroid.ui.articleslist

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.yadaniyil.newsfeedandroid.api.ApiService
import com.yadaniyil.newsfeedandroid.api.ArticlesDataSource
import com.yadaniyil.newsfeedandroid.api.ArticlesDataSourceFactory
import com.yadaniyil.newsfeedandroid.models.Article
import io.reactivex.disposables.CompositeDisposable
import com.yadaniyil.newsfeedandroid.api.State

class ArticlesListViewModel(api: ApiService) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()
    private val articlesDataSourceFactory: ArticlesDataSourceFactory
    private val pageSize = 20
    var newsList: LiveData<PagedList<Article>>

    init {
        articlesDataSourceFactory = ArticlesDataSourceFactory(compositeDisposable, api)
        val config = PagedList.Config.Builder()
                .setPageSize(pageSize)
                .setInitialLoadSizeHint(pageSize * 2)
                .build()
        newsList = LivePagedListBuilder<Int, Article>(articlesDataSourceFactory, config).build()
    }

    fun getState(): LiveData<State> = Transformations.switchMap<ArticlesDataSource,
            State>(articlesDataSourceFactory.newsDataSourceLiveData, ArticlesDataSource::state)

    fun retry() {
        articlesDataSourceFactory.newsDataSourceLiveData.value?.retry()
    }

    fun listIsEmpty(): Boolean {
        return newsList.value?.isEmpty() ?: true
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}
