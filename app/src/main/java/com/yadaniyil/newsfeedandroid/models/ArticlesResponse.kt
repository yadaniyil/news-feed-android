package com.yadaniyil.newsfeedandroid.models

import com.google.gson.annotations.SerializedName

class ArticlesResponse(
        @SerializedName("hits")
        var articles: List<Article>? = null,

        @SerializedName("nbHits")
        var numberOfArticles: Long? = null,

        @SerializedName("page")
        var page: Long? = null,

        @SerializedName("nbPages")
        var numberOfPages: Long? = null,

        @SerializedName("hitsPerPage")
        var articlesPerPage: Long? = null
)