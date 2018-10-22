package com.yadaniyil.newsfeedandroid.api

import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource
import com.yadaniyil.newsfeedandroid.models.Article
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Action
import io.reactivex.schedulers.Schedulers

class ArticlesDataSource(
        private val api: ApiService,
        private val compositeDisposable: CompositeDisposable)
    : PageKeyedDataSource<Int, Article>() {

    var state: MutableLiveData<State> = MutableLiveData()
    private var retryCompletable: Completable? = null


    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, Article>) {
        updateState(State.LOADING)
        compositeDisposable.add(
                api.searchByDate(0)
                        .subscribe(
                                { response ->
                                    updateState(State.DONE)
                                    callback.onResult(response.articles ?: emptyList(),
                                            null, 1)
                                }, {
                            updateState(State.ERROR)
                            setRetry(Action { loadInitial(params, callback) })
                        }
                        )
        )
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Article>) {
        updateState(State.LOADING)
        compositeDisposable.add(
                api.searchByDate(params.key)
                        .subscribe(
                                { response ->
                                    updateState(State.DONE)
                                    callback.onResult(response.articles ?: emptyList(),
                                            params.key + 1)
                                }, {
                            updateState(State.ERROR)
                            setRetry(Action { loadAfter(params, callback) })
                        }
                        )
        )
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Article>) {
    }

    private fun updateState(state: State) = this.state.postValue(state)


    fun retry() {
        if (retryCompletable != null) {
            compositeDisposable.add(retryCompletable!!
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe())
        }
    }

    private fun setRetry(action: Action?) {
        retryCompletable = if (action == null) null else Completable.fromAction(action)
    }

}