package com.example.mydiapp1

import android.content.SharedPreferences
import javax.inject.Inject

interface UserRepositoryIntf {
    fun getUser(): User
    fun saveUser(user: User)
}

class UserRepository @Inject constructor(private var sharedPreferences: SharedPreferences) :
    UserRepositoryIntf {

    private val KEY_NAME = "KEY_NAME"
    private val KEY_SURNAME = "KEY_SURNAME"

    override fun getUser(): User {

        return User(
            sharedPreferences.getString(KEY_NAME, "")!!,
            sharedPreferences.getString(KEY_SURNAME, "")!!
        )

    }

    override fun saveUser(user: User) {
        sharedPreferences.edit()
            .putString(KEY_NAME, user.getName())
            .putString(KEY_SURNAME, user.getSurname())
            .apply()
    }
}
