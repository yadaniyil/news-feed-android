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
import com.yadaniyil.newsfeedandroid.R
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

        vm.articles.observe(this, Observer { articles ->

        })
    }

    companion object {
        fun newInstance() = ArticlesListFragment()
    }
}

