package com.example.mydiapp1

import android.app.Application
import toothpick.Toothpick

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        val appScope = Toothpick.openScope("APP")
        appScope.installModules(RepositoryModule(applicationContext))
    }
}