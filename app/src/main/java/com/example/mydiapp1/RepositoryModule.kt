package com.example.mydiapp1

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import toothpick.config.Module

class RepositoryModule(context: Context) : Module() {

    init {
        val sp: SharedPreferences = context.getSharedPreferences("app.prefs", MODE_PRIVATE)
        bind(SharedPreferences::class.java).toInstance(sp)

        bind(UserRepositoryIntf::class.java).to(UserRepository::class.java).singleton()
    }
}