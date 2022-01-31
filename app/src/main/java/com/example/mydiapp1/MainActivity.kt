package com.example.mydiapp1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import toothpick.Toothpick
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var userRepository: UserRepository

    lateinit var nameEdit: EditText
    lateinit var surnameEdit: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameEdit = findViewById(R.id.nameEdit)
        surnameEdit = findViewById(R.id.surnameEdit)

        findViewById<Button>(R.id.saveButton).setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                saveUser()
            }
        })

        findViewById<Button>(R.id.loadButton).setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                loadUser()
            }
        })

        val appScope = Toothpick.openScope("APP")
        Toothpick.inject(this, appScope)

        if (savedInstanceState == null) {
            loadUser()
        }
    }

    private fun loadUser() {
        showUser(userRepository.getUser())
    }

    private fun showUser(user: User) {
        fillEditText(nameEdit, user.getName())
        fillEditText(surnameEdit, user.getSurname())
    }

    private fun fillEditText(editText: EditText, text: String) {
        editText.setText(text)
    }

    private fun saveUser() {
        val user = User(
            nameEdit.text.toString().trim { it <= ' ' },
            surnameEdit.text.toString().trim { it <= ' ' }
        )
        userRepository.saveUser(user)
    }
}

