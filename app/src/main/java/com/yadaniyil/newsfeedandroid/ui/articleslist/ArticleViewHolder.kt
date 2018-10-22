package com.yadaniyil.newsfeedandroid.ui.articleslist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yadaniyil.newsfeedandroid.R
import com.yadaniyil.newsfeedandroid.models.Article
import kotlinx.android.synthetic.main.list_item_article.view.*

class ArticleViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun bind(article: Article?) {
        if (article != null) {
            itemView.article_title.text = article.title
            itemView.article_time.text = article.createdAt
        }
    }

    companion object {
        fun create(parent: ViewGroup): ArticleViewHolder {
            val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.list_item_article, parent, false)
            return ArticleViewHolder(view)
        }
    }
}