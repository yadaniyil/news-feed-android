package com.yadaniyil.newsfeedandroid.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Article {

    @SerializedName("created_at")
    @Expose
    var createdAt: String? = null
    @SerializedName("title")
    @Expose
    var title: String? = null
    @SerializedName("url")
    @Expose
    var url: String? = null
    @SerializedName("author")
    @Expose
    var author: String? = null
    @SerializedName("points")
    @Expose
    var points: Long = 0
    @SerializedName("story_text")
    @Expose
    var storyText: String? = null
    @SerializedName("comment_text")
    @Expose
    var commentText: String? = null
    @SerializedName("num_comments")
    @Expose
    var numComments: Long = 0
    @SerializedName("story_id")
    @Expose
    var storyId: Long? = null
    @SerializedName("story_title")
    @Expose
    var storyTitle: String? = null
    @SerializedName("story_url")
    @Expose
    var storyUrl: String? = null
    @SerializedName("parent_id")
    @Expose
    var parentId: Long? = null
    @SerializedName("created_at_i")
    @Expose
    var createdAtI: Long = 0
    @SerializedName("_tags")
    @Expose
    var tags: List<String>? = null
    @SerializedName("objectID")
    @Expose
    var objectID: String? = null
    @SerializedName("_highlightResult")
    @Expose
    var highlightResult: HighlightResult? = null

    inner class Author {

        @SerializedName("value")
        @Expose
        var value: String? = null
        @SerializedName("matchLevel")
        @Expose
        var matchLevel: String? = null
        @SerializedName("matchedWords")
        @Expose
        var matchedWords: List<Any>? = null

    }

    inner class HighlightResult {

        @SerializedName("title")
        @Expose
        var title: Title? = null
        @SerializedName("url")
        @Expose
        var url: Url? = null
        @SerializedName("author")
        @Expose
        var author: Author? = null

    }

    inner class Title {

        @SerializedName("value")
        @Expose
        var value: String? = null
        @SerializedName("matchLevel")
        @Expose
        var matchLevel: String? = null
        @SerializedName("matchedWords")
        @Expose
        var matchedWords: List<String>? = null

    }

    inner class Url {

        @SerializedName("value")
        @Expose
        var value: String? = null
        @SerializedName("matchLevel")
        @Expose
        var matchLevel: String? = null
        @SerializedName("matchedWords")
        @Expose
        var matchedWords: List<String>? = null

    }

}