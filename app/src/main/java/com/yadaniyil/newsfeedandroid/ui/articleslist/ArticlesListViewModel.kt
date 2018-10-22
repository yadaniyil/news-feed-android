package com.yadaniyil.newsfeedandroid.ui.articleslist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yadaniyil.newsfeedandroid.api.ApiService
import com.yadaniyil.newsfeedandroid.models.Article
import com.yadaniyil.newsfeedandroid.models.Resource
import io.reactivex.disposables.CompositeDisposable

class ArticlesListViewModel(val api: ApiService) : ViewModel() {

    val articles: MutableLiveData<Resource<List<Article>>> = MutableLiveData()
    private val compositeDisposable = CompositeDisposable()


    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}

