package com.yadaniyil.newsfeedandroid.ui.articleslist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.yadaniyil.newsfeedandroid.R
import com.yadaniyil.newsfeedandroid.models.Article

class ArticlesAdapter(private val context: Context) : ListAdapter<Article,
        ArticlesAdapter.ArticleViewHolder>(ArticleDiffCallback()) {

    class ArticleViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var itemRootLayout: LinearLayout = view.findViewById(R.id.item_root_layout)
        var title: TextView = view.findViewById(R.id.article_title)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item_article, parent, false)
        return ArticleViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        getItem(position).let { article ->
            with(holder) {
                title.text = article.title
            }
        }
    }

    private fun View.createOnClickListener(article: Int) {
        val onClick = View.OnClickListener {

        }
        this.setOnClickListener(onClick)
    }
}