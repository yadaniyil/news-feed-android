package com.yadaniyil.newsfeedandroid.ui.articleslist

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yadaniyil.newsfeedandroid.R

class ArticlesListFragment : Fragment() {

    companion object {
        fun newInstance() = ArticlesListFragment()
    }

    private lateinit var viewModel: ArticlesListViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.articles_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ArticlesListViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
