package com.yadaniyil.newsfeedandroid

import android.app.Application
import com.yadaniyil.newsfeedandroid.di.getAllKoinModules
import org.koin.android.ext.android.startKoin

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(this, getAllKoinModules())
    }
}