package com.yadaniyil.newsfeedandroid.ui.articleslist

import android.view.LayoutInflater
import android.view.View
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yadaniyil.newsfeedandroid.R
import kotlinx.android.synthetic.main.article_footer_item.view.*
import com.yadaniyil.newsfeedandroid.api.State

class LoadingFooterViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun bind(state: State?) {
        itemView.progress_bar.visibility = if (state == State.LOADING) VISIBLE else View.INVISIBLE
        itemView.txt_error.visibility = if (state == State.ERROR) VISIBLE else View.INVISIBLE
    }

    companion object {
        fun create(retry: () -> Unit, parent: ViewGroup): LoadingFooterViewHolder {
            val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.article_footer_item, parent, false)
            view.txt_error.setOnClickListener { retry() }
            return LoadingFooterViewHolder(view)
        }
    }
}