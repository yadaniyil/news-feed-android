package com.yadaniyil.newsfeedandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yadaniyil.newsfeedandroid.ui.articleslist.ArticlesListFragment

class ArticlesListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.articles_list_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, ArticlesListFragment.newInstance())
                    .commitNow()
        }
    }

}
