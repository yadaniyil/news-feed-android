package com.yadaniyil.newsfeedandroid

import android.view.View
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout


fun View.visible(): View {
    this.visibility = View.VISIBLE
    return this
}

fun View.invisible(): View {
    this.visibility = View.INVISIBLE
    return this
}

fun View.gone(): View {
    this.visibility = View.GONE
    return this
}

fun SwipeRefreshLayout.stopRefreshing() {
    this.isRefreshing = false
}

fun SwipeRefreshLayout.startRefreshing() {
    this.isRefreshing = true
}