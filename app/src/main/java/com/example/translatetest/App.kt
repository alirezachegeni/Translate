package com.example.translatetest

import android.app.Application
import com.example.translatetest.data.NetworkDataSource
import com.example.translatetest.repository.Repository
import timber.log.Timber

class App:Application() {
lateinit var repository: Repository
    override fun onCreate() {
        super.onCreate()
    val networkDataSource = NetworkDataSource()
        repository = Repository(networkDataSource)
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}