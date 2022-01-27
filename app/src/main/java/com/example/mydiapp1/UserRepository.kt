package com.example.mydiapp1

import android.content.SharedPreferences

class UserRepository(sp: SharedPreferences) {
    private val sharedPreferences: SharedPreferences = sp

    fun getUser(): User {
        // что-то делаем....
        return User()
    }

    fun saveUser(user: User) {
        // что-то делаем....
    }

}