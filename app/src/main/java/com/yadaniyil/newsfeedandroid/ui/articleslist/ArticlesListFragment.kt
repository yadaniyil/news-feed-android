package com.yadaniyil.newsfeedandroid.ui.articleslist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yadaniyil.newsfeedandroid.R
import com.yadaniyil.newsfeedandroid.gone
import com.yadaniyil.newsfeedandroid.visible
import kotlinx.android.synthetic.main.articles_list_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.yadaniyil.newsfeedandroid.api.State

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

        articlesAdapter = ArticlesAdapter { vm.retry() }
        articles_list.apply {
            layoutManager = viewManager
            adapter = articlesAdapter
        }

        vm.newsList.observe(this, Observer {
            articlesAdapter.submitList(it)
        })

        tv_error.setOnClickListener { vm.retry() }
        vm.getState().observe(this, Observer { state ->
            if (vm.listIsEmpty() && state == State.LOADING) {
                articles_progress_bar.visible()
            } else {
                articles_progress_bar.gone()
            }

            if (vm.listIsEmpty() && state == State.ERROR) {
                tv_error.visible()
            } else {
                tv_error.gone()
            }

            if (!vm.listIsEmpty()) {
                articlesAdapter.setState(state ?: State.DONE)
                (activity as AppCompatActivity).supportActionBar?.title =
                        "Articles: ${articlesAdapter.getArticlesCount()}"
            }
        })
    }

    companion object {
        fun newInstance() = ArticlesListFragment()
    }
}

