package com.yadaniyil.newsfeedandroid.ui.articleslist

import androidx.recyclerview.widget.DiffUtil
import com.yadaniyil.newsfeedandroid.models.Article

class ArticleDiffCallback : DiffUtil.ItemCallback<Article>() {
    override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
        return oldItem.title == newItem.title
    }

}