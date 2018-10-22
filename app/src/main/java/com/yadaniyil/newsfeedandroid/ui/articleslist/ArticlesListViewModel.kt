package com.yadaniyil.newsfeedandroid.ui.articleslist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yadaniyil.newsfeedandroid.api.ApiService
import com.yadaniyil.newsfeedandroid.models.Article
import com.yadaniyil.newsfeedandroid.models.Resource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

class ArticlesListViewModel(val api: ApiService) : ViewModel() {

    val articles: MutableLiveData<Resource<List<Article>>> = MutableLiveData()
    private val compositeDisposable = CompositeDisposable()

    init {
        loadFirstPage()
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

    private fun loadFirstPage() {
        articles.value = Resource.loading(null)
        compositeDisposable.add(api.searchByDate()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ data ->
                    articles.value = Resource.success(data.articles)
                    Timber.d("Articles refreshed")
                }, { error ->
                    articles.value = Resource.error(error.localizedMessage, null)
                    Timber.e(error.localizedMessage)
                }))
    }

}
