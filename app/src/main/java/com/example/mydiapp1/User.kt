package com.example.mydiapp1

class User(private var name: String = "", private var surname: String = "") {

    fun getName(): String {
        return name
    }

    fun getSurname(): String {
        return surname
    }
}