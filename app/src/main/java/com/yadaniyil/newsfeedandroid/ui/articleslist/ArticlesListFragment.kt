package com.yadaniyil.newsfeedandroid.ui.articleslist

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yadaniyil.newsfeedandroid.*
import com.yadaniyil.newsfeedandroid.models.Article
import com.yadaniyil.newsfeedandroid.models.Resource
import com.yadaniyil.newsfeedandroid.models.Status
import kotlinx.android.synthetic.main.articles_list_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class ArticlesListFragment : Fragment() {

    private val vm: ArticlesListViewModel by viewModel()

    private lateinit var articlesAdapter: ArticlesAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.articles_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewManager = LinearLayoutManager(activity)

        articlesAdapter = ArticlesAdapter(activity as Context)
        articles_list.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = articlesAdapter
        }

//        swipe_refresh.setOnRefreshListener { viewModel.refresh() }

        vm.articles.observe(this, Observer<Resource<List<Article>>> { articles ->
            when (articles.status) {
                Status.LOADING -> renderLoading()
                Status.ERROR -> renderError()
                Status.SUCCESS -> renderSuccess(articles)
            }
        })
    }

    private fun renderLoading() {
        if (articlesAdapter.itemCount > 0) {
            swipe_refresh.visible()
            progress_bar.gone()
            swipe_refresh.startRefreshing()
        } else {
            swipe_refresh.gone()
            progress_bar.visible()
            swipe_refresh.stopRefreshing()
        }
    }

    private fun renderError() {}

    private fun renderSuccess(articles: Resource<List<Article>>) {
        progress_bar.gone()
        swipe_refresh.visible()
        swipe_refresh.stopRefreshing()
        articlesAdapter.submitList(articles.data)
    }

    companion object {
        fun newInstance() = ArticlesListFragment()
    }
}

